package com.example.webapp.model;

public enum ContactType {
    PERSONAL("Личные качества"),
    OBJECTIVE("Позиция"),
    ACHIEVEMENT("Достижения"),
    QUALIFICATIONS("Квалификация"),
    EXPERIENCE("Опыт работы"),
    EDUCATION("Образование");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
