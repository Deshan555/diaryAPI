package com.weblog.diary.controller;

import com.weblog.diary.exception.ContentNotFoundException;
import com.weblog.diary.model.DayBook;
import com.weblog.diary.service.DaybookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/daybook")
public class Controller {
    private final DaybookService dayBookService;

    public Controller(DaybookService dayBookService) {
        this.dayBookService = dayBookService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addContent(@RequestBody DayBook dayBook) {
        try {
            DayBook newDayBook = dayBookService.addContent(dayBook);
            return new ResponseEntity<>(newDayBook, HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity<>("Data too long for insert", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<DayBook>> getAllContent() {
        List<DayBook> dayBooks = dayBookService.findAllContent();
        return new ResponseEntity<>(dayBooks, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getContentByID(@PathVariable("id") Long id) {
        try {
            DayBook dayBook = dayBookService.findContentById(id);
            if (dayBook != null) {
                return new ResponseEntity<>(dayBook, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Content not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception error) {
            return new ResponseEntity("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateContent(@RequestBody DayBook dayBook) {
        try {
            // Check if the content exists before updating
            DayBook existingContent = dayBookService.findContentById(dayBook.getId());
            if (existingContent != null) {
                return dayBookService.updateContent(dayBook);
            } else {
                return new ResponseEntity<>("Content not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception error) {
            return new ResponseEntity("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/drop/{id}")
    public ResponseEntity<?> deleteContent(@PathVariable("id") Long id) {
        try {
            // Check if the content exists before deleting
            DayBook existingContent = dayBookService.findContentById(id);
            if (existingContent != null) {
                return dayBookService.dropContent(id);
            } else {
                return new ResponseEntity<>("Content not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception error) {
            return new ResponseEntity("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
