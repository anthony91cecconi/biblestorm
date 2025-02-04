package com.bible.biblestorm.DTO;

import com.bible.biblestorm.entity.BibleEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BibleInfoDTO {
  private String name;

  public BibleInfoDTO(){}
  public BibleInfoDTO(String name){ this.name = name; }

  public BibleInfoDTO getInfoDTO(BibleEntity entity){
    BibleInfoDTO dto = new BibleInfoDTO();
    dto.setName(entity.getName());
    return dto;
  }

  public BibleEntity getIEntity(BibleInfoDTO dto){
    BibleEntity entity = new BibleEntity(dto);
    entity.setName(entity.getName());
    return entity;
  }
}
