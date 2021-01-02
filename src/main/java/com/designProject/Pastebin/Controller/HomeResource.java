package com.designProject.Pastebin.Controller;

import com.designProject.Pastebin.service.InjectedSampleClass;
import com.designProject.Pastebin.service.InjectedSampleClassImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.LinkedHashMap;

@Controller
public class HomeResource {

    @Autowired
    InjectedSampleClassImpl2 injectedSampleClass;

    @RequestMapping(method = RequestMethod.GET,path = "/")
    public String home() throws ClassNotFoundException {
        Class clazz= Class.forName("com.p6spy.engine.spy.P6DataSource");
        return "index";
    }

    @GetMapping(value = "/user")
    @ResponseBody
    public Principal user(Principal principal){
        principal.toString();
        LinkedHashMap<Object,Object> map = (LinkedHashMap<Object, Object>)
                ((OAuth2Authentication) principal).getUserAuthentication().getDetails();
        map.get("email");
        return principal;
    }


    @GetMapping(value = "/diTest1")
    @ResponseBody
    public String changeVariableValue()  {
        injectedSampleClass.setSampleVariable(4);
        return "Hello !!!";
    }

}
