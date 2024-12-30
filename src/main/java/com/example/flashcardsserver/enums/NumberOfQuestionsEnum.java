package com.example.flashcardsserver.enums;

public enum NumberOfQuestionsEnum {
    FROM_ZERO_TO_TWO(0, 2),
    FROM_THREE_TO_FIVE(3, 5),
    GREATER_THAN_FIVE(6, Integer.MAX_VALUE);

    private final int min;
    private final int max;

    NumberOfQuestionsEnum(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public boolean isInRange(int value) {
        return value >= min && value <= max;
    }
}