package com.weblog.diary.repo;

import com.weblog.diary.model.DayBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayBookRepo extends JpaRepository<DayBook, Long> {

}
