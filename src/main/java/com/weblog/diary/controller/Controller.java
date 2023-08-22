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
    public ResponseEntity<DayBook> addContent(@RequestBody DayBook dayBook) {
        try{
            DayBook newDayBook = dayBookService.addContent(dayBook);
            return new ResponseEntity<>(newDayBook, HttpStatus.CREATED);
        }catch(Exception error){
            return new ResponseEntity("{'error':'data too long for insert'}", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<DayBook>> getAllContent() {
        List<DayBook> dayBooks = dayBookService.findAllContent();
        return new ResponseEntity<>(dayBooks, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getContentByID(@PathVariable("id") Long id) {
        try{
            DayBook dayBook = dayBookService.findContentById(id);
            return new ResponseEntity<>(dayBook, HttpStatus.OK);
        }catch(Exception error){
            return new ResponseEntity(error, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateContent(@RequestBody DayBook dayBook) {
        return dayBookService.updateContent(dayBook);
    }

    @DeleteMapping("/drop/{id}")
    public ResponseEntity<?> updateContent(@PathVariable("id") Long id) {
        return dayBookService.dropContent(id);
    }


}
