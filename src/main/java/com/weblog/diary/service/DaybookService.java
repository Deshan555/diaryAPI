package com.weblog.diary.service;

import com.weblog.diary.exception.ContentNotFoundException;
import com.weblog.diary.model.DayBook;
import com.weblog.diary.repo.DayBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class DaybookService {

    private final DayBookRepo dayBookRepo;

    @Autowired
    public DaybookService(DayBookRepo dayBookRepo) {
        this.dayBookRepo = dayBookRepo;
    }

    public DayBook addContent(DayBook dayBook) {
        dayBook.setEntryCode(UUID.randomUUID().toString());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        dayBook.setTimestamp(String.valueOf(timestamp.getTime()));
        return dayBookRepo.save(dayBook);
    }

    public List<DayBook> findAllContent() {
        return dayBookRepo.findAll();
    }

    public DayBook updateContent(DayBook dayBook) {
        return dayBookRepo.save(dayBook);
    }

    public DayBook findContentById(Long id) {
        return dayBookRepo.findDayBookById(id).orElseThrow(() -> new ContentNotFoundException("Content by id " + id + " was not found"));
    }

    public ResponseEntity<String> dropContent(Long id) {
        boolean available = dayBookRepo.existsById(id);
        if (available) {
            dayBookRepo.deleteById(id);
            return ResponseEntity.ok("{'message': 'Content deleted', 'id': " + id + "}");
        } else {
            return ResponseEntity.ok("{'message': 'Content with ID " + id + " not found'}");
        }
    }
}
