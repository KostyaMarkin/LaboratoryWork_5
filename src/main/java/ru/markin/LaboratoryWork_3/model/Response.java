package ru.markin.LaboratoryWork_3.model;

import lombok.Builder;
import lombok.Data;
import ru.markin.LaboratoryWork_3.Codes;
import ru.markin.LaboratoryWork_3.ErrorMessages;
import ru.markin.LaboratoryWork_3.util.ErrorCodes;

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
