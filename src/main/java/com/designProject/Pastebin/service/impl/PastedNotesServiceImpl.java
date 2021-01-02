package com.designProject.Pastebin.service.impl;

import com.designProject.Pastebin.JpaRepository.PastebinRepository;
import com.designProject.Pastebin.models.PastedNotes;
import com.designProject.Pastebin.service.PastedNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PastedNotesServiceImpl implements PastedNotesService {

    @Autowired
    PastebinRepository pastebinRepository;

    @Override
    public void save(String generatedAddress,String pastedNotes) {
        pastebinRepository.save(new PastedNotes(generatedAddress,"FREE",pastedNotes,"NULL"));
        return;
    }
}
