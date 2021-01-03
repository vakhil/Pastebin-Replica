package com.designProject.Pastebin.Controller;
import com.p6spy.engine.spy.P6DataSource;

import com.designProject.Pastebin.JpaRepository.AccountInfoRepository;
import com.designProject.Pastebin.JpaRepository.PastebinRepository;
import com.designProject.Pastebin.models.AccountInfo;
import com.designProject.Pastebin.models.PastedNotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.SpringVersion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class PastEditController {

    @Autowired
    PastebinRepository pastebinRepository;

    @Autowired
    AccountInfoRepository accountInfoRepository;

    @GetMapping(value = "/editHistory")
    public String user(Principal principal, Model model, HttpSession httpSession){
        SpringVersion.getVersion();
        LinkedHashMap<Object,Object> map = (LinkedHashMap<Object, Object>)
                ((OAuth2Authentication) principal).getUserAuthentication().getDetails();
        String emailId = (String) map.get("email");
        // COde for Caching and helping us here !!!
        // Say that if you know this email or seen this email before in 10 minutes, what would you do ?

        // take an object which is injectedd
        // if(map.find("email")) == email.get("email") .. what would happen if your machine switches off ..
        //all your cache data would be gone ... suppose you want to implement this logic, in the last 10 minutes
        // if a request has  been made to this server, fetch from the cache . You can easily do  that in one machine
        // it would be easy to impleemtn this 10 minutes of logic. .. but if you have more than 1 machine, where would the
        // in memory cache be initalized ... do you have anohter computer for cache , where all machines talk to that machine
        // and get the cache value ... distributed caches and maybe understand !!
        getPaginatedEntries(httpSession,principal,model,1);
        return "editHistory";
    }

    @GetMapping(value = "/editHistory/{pageNo}")
    public String getPaginatedEntries(HttpSession httpSession,
                                      Principal principal, Model model,@PathVariable(value = "pageNo") int pageNo){
        int pageSize = 10;

        LinkedHashMap<Object,Object> map = (LinkedHashMap<Object, Object>)
                ((OAuth2Authentication) principal).getUserAuthentication().getDetails();
        String emailId = (String) map.get("email");


        Pageable pageable =  PageRequest.of(pageNo-1,pageSize);
        Page<PastedNotes> pasteNotes = pastebinRepository.findByAccountIdOrderByTimestampDesc(emailId,pageable);
        AccountInfo accountInfo = accountInfoRepository.findByAccountId(emailId);
        model.addAttribute("tier",accountInfo.getTier());
        model.addAttribute("pasteNotes",pasteNotes.getContent());
        model.addAttribute("numberOfPages",pasteNotes.getTotalPages());
        model.addAttribute("numberOfEntries",pasteNotes.getTotalElements());
        model.addAttribute("currentPageNumber",pageNo);
        httpSession.setAttribute("tier",accountInfo.getTier());
        return "editHistory";


    }


}
