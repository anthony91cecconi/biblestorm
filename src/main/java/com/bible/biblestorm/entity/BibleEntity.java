package com.bible.biblestorm.entity;

import com.bible.biblestorm.DTO.BibleInfoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="BIBLE")
@Getter
@Setter
public class BibleEntity {

    public BibleEntity(BibleInfoDTO dto){
        this.name = dto.getName();
    }

    @Id
    private String id;
    private String name;
}
