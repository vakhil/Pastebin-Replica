package com.designProject.Pastebin.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

public class InjectedSampleClassImpl1 {

    private int sampleVariable = 0;


    public int getSampleVariable() {
        return sampleVariable;
    }

    public void setSampleVariable(int sampleVariable) {
        this.sampleVariable = sampleVariable;
    }
}
