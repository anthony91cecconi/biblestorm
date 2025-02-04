package com.bible.biblestorm.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bible.biblestorm.entity.BibleEntity;

@Repository
public interface BibleRepository extends JpaRepository<BibleEntity, String>{
    
}
