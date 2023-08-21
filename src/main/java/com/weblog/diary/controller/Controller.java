package com.weblog.diary.controller;

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
    public ResponseEntity<DayBook> addContent(@RequestBody DayBook dayBook) {
        DayBook newDayBook = dayBookService.addContent(dayBook);
        return new ResponseEntity<>(newDayBook, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DayBook>> getAllContent() {
        List<DayBook> dayBooks = dayBookService.findAllContent();
        return new ResponseEntity<>(dayBooks, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<DayBook> getContentByID(@PathVariable("id") Long id) {
        DayBook dayBook = dayBookService.findContentById(id);
        return new ResponseEntity<>(dayBook, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<DayBook> updateContent(@RequestBody DayBook dayBook) {
        DayBook updateDayBook = dayBookService.updateContent(dayBook);
        return new ResponseEntity<>(updateDayBook, HttpStatus.OK);
    }

    @DeleteMapping("/drop/{id}")
    public ResponseEntity<?> updateContent(@PathVariable("id") Long id) {
        dayBookService.dropContent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
