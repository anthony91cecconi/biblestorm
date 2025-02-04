package com.bible.biblestorm.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bible.biblestorm.DTO.BibleInfoDTO;
import com.bible.biblestorm.entity.BibleEntity;
import com.bible.biblestorm.repository.BibleRepository;

@Service
public class BibleService {

     private static final Logger logger = LoggerFactory.getLogger(BibleService.class);

    @Autowired
    BibleRepository repository;
    BibleInfoDTO bibleInfoDTO;

    public BibleInfoDTO findInfoById(String id){
        BibleEntity entity = repository.findById(id).orElse(null);
        if (entity != null) {
            return  bibleInfoDTO.getInfoDTO(entity);
        }
        return null;
    }

    public BibleInfoDTO createBibleInfo(BibleInfoDTO bibleInfoDTO){

        try{
            repository.save(bibleInfoDTO.getIEntity(bibleInfoDTO));
            return bibleInfoDTO;
        }  catch (Exception e) {
            logger.error("salvatagio non riuscito");
        }

        return null;
    }
}
