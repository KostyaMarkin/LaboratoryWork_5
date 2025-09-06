package ru.markin.LaboratoryWork_4;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorMessages {

    EMPTY(""),

    VALIDATION("Ошибка валидации"),

    UNSOPPORTED("Не поддерживаемая ошибка"),

    UNKNOW("Произошла неизвестная ошибка"),;

    private final String description;

    ErrorMessages(String description) {
        this.description = description;
    }

    @JsonValue
    public String getName(){
        return description;
    }
}
