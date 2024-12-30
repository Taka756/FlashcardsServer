package com.example.flashcardsserver.enums;


public enum SubjectEnum {
    MATH("Math"),
    SCIENCE("Science"),
    HISTORY("History"),
    LITERATURE("Literature"),
    PHYSICS("Physics"),
    CHEMISTRY("Chemistry"),
    BIOLOGY("Biology"),
    ART("Art"),
    MUSIC("Music"),
    COMPUTER_SCIENCE("Computer Science");

    private final String displayName;

    SubjectEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}