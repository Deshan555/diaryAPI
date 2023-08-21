package com.weblog.diary;

import com.weblog.diary.model.DayBook;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "diaryAPI Project(Spring-Boot)",
                version = "1.0.0",
                description = "\uD83D\uDE80 This API allows you to manage your daybook entries, recording your thoughts, moods, and experiences. Keep track of your journey with ease! \uD83C\uDF1F",
                contact = @Contact(
                        name = "https://github.com/Deshan555",
                        email = "deshanjayashanka84@gmail.com"
                ),
                license = @License(
                        url = "https://github.com/Deshan555/diaryAPI"
                )
        )
)
public class diaryAPI {
    public diaryAPI() {
        DayBook dayBook = new DayBook();
    }

    public static void main(String[] args) {
        SpringApplication.run(diaryAPI.class, args);
    }
}
