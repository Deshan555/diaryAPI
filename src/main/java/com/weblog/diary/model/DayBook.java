package com.weblog.diary.model;

import javax.persistence.*;

@Entity
public class DayBook implements java.io.Serializable{
    @Id
    @SequenceGenerator(
            name = "daybook_id_sequence",
            sequenceName = "daybook_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "daybook_id_sequence"
    )
    @Column(nullable = false, updatable = false)
    private Long id;
    private String title;
    private String content;
    private String date;
    private String timestamp;
    private String location;
    private String mood;
    @Column(nullable = false, updatable = false)
    private String entryCode;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getEntryCode() {
        return entryCode;
    }

    public void setEntryCode(String entryCode) {
        this.entryCode = entryCode;
    }

    @Override
    public String toString() {
        return "DayBook{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", location='" + location + '\'' +
                ", mood='" + mood + '\'' +
                ", entryCode='" + entryCode + '\'' +
                '}';
    }
}
