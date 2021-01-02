package com.designProject.Pastebin.Controller;

import com.designProject.Pastebin.JpaRepository.PastebinRepository;
import com.designProject.Pastebin.models.PastedNotes;
import com.designProject.Pastebin.service.PastedNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class SnippetSaveController {

    @Autowired
    PastedNotesService pastedNotesService;

    @Autowired
    PastebinRepository pastebinRepository;

    @PostMapping("/save")
    public String saveTextMessage(@RequestBody String pastedNotes, Model model){
        //Generate a random URL address and URL encode them !!!
        String urlAddress = generateRandomURLAddress();

        //Save to Database !!
        pastedNotesService.save(urlAddress,pastedNotes);


        //Pass on the url Addresses and information !!!!

        model.addAttribute("pastedNotes",pastedNotes);
        model.addAttribute("urlAddress",urlAddress);

        return urlAddress;


    }


    @PostMapping("/update/{urlAddress}")
    public String updateNotes(@RequestBody String pastedNotes, @PathVariable final String urlAddress, Model model){

        //Get the thing from database and update it now !!!
        PastedNotes previousNote = pastebinRepository.findByUrlAddress(urlAddress);

        previousNote.setText(pastedNotes);
        pastebinRepository.save(previousNote);

        //Pass on the url Addresses and information !!!!

        model.addAttribute("pastedNotes",pastedNotes);
        model.addAttribute("urlAddress",urlAddress);

        return urlAddress;


    }
    public String generateRandomURLAddress() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);
        return generatedString;
    }
}
