package com.designProject.Pastebin.Controller;


import com.designProject.Pastebin.JpaRepository.PastebinRepository;
import com.designProject.Pastebin.models.PastedNotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GeneratedUrlController {


    @Autowired
    PastebinRepository pastebinRepository;


    @RequestMapping(method = RequestMethod.GET,path = "/r/{generatedUrlAddress}")
    public String generatedUrlController(@PathVariable final String generatedUrlAddress, Model model){
        PastedNotes pastedNotes =  pastebinRepository.findByUrlAddress(generatedUrlAddress);
        model.addAttribute("pastedNotes",pastedNotes.getText());
        model.addAttribute("urlAddress",pastedNotes.getUrlAddress());
        int a = 10;
        return "generatedURL";
    }
}
