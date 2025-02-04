package com.bible.biblestorm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bible.biblestorm.DTO.BibleInfoDTO;
import com.bible.biblestorm.service.BibleService;

@RestController
@RequestMapping("/request")
public class RequestController {
    
    @Autowired
    BibleService bibleService;

    @GetMapping("/bible-info/{id}")
    public ResponseEntity<BibleInfoDTO> getUserById(@PathVariable String id) {
        BibleInfoDTO bibleInfoDTO = bibleService.findInfoById(id);

        if (bibleInfoDTO != null) {
            return ResponseEntity.ok(bibleInfoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/bible-info")
    public ResponseEntity<BibleInfoDTO> createBibleInfo(@RequestBody BibleInfoDTO bibleInfoDTO) {
    try {
        BibleInfoDTO createdBibleInfo = bibleService.createBibleInfo(bibleInfoDTO);
        if (createdBibleInfo != null) {
            return ResponseEntity.ok(createdBibleInfo);
        }
        return ResponseEntity.badRequest().body(null);
    } catch (Exception e) {
        return ResponseEntity.badRequest().build(); 
    }
}

}
