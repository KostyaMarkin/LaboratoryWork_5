package ru.markin.LaboratoryWork_3.util;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCodes {

    EMPTY(""),

    VALIDATION_EXCEPTION("ValidationException"),

    UNKNOW_EXCEPTION("UnknowException"),

    UNSUPPORTED_EXCEPTION("UnsupportedException"),;

    private final String name;

    ErrorCodes(String name){
        this.name = name;
    }

    @JsonValue
    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name;
    }
}
