package ru.markin.LaboratoryWork_4.model;

import lombok.Builder;
import lombok.Data;
import ru.markin.LaboratoryWork_4.Codes;
import ru.markin.LaboratoryWork_4.ErrorMessages;
import ru.markin.LaboratoryWork_4.util.ErrorCodes;

@Data
@Builder
public class Response {

    private String uid;
    private String operationId;
    private String systemTime;
    private Codes code;
    private ErrorCodes errorCode;
    private ErrorMessages errorMessage;
}
