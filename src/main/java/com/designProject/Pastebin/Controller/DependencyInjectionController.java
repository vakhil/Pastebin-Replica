package com.designProject.Pastebin.Controller;

import com.designProject.Pastebin.service.InjectedSampleClass;
import com.designProject.Pastebin.service.InjectedSampleClassImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DependencyInjectionController {


    InjectedSampleClassImpl2 injectedSampleClass;


    @GetMapping(value = "/diTest2")
    @ResponseBody
    public String changeVariableValue()  {
        System.out.println(injectedSampleClass.getSampleVariable());
        return String.valueOf(injectedSampleClass.getSampleVariable())  ;
    }
}
