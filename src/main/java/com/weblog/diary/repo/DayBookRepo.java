package com.weblog.diary.repo;

import com.weblog.diary.model.DayBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DayBookRepo extends JpaRepository<DayBook, Long> {
    // query methods
    void deleteDayBookById(Long id);

    Optional<DayBook> findDayBookById(Long id);
}
