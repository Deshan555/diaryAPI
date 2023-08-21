package com.weblog.diary;

import com.weblog.diary.model.DayBook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class diaryAPI {
    public diaryAPI() {
        DayBook dayBook = new DayBook();
    }

    public static void main(String[] args) {
        SpringApplication.run(diaryAPI.class, args);
    }
}
