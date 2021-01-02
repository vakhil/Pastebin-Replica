package com.designProject.Pastebin.service;

import org.springframework.stereotype.Service;

@Service    
public class InjectedSampleClassImpl2 {

    private int sampleVariable = 10;


    public int getSampleVariable() {
        return sampleVariable;
    }

    public void setSampleVariable(int sampleVariable) {
        this.sampleVariable = sampleVariable;
    }

}
