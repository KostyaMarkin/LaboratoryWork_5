package ru.markin.LaboratoryWork_3.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    @NotBlank
    private String uid;
    @NotBlank
    private String operationId;
    private String systemName;
    @NotBlank
    private String systemTime;
    @NotBlank
    private String source;
    private int communicationId;
    private int templateId;
    private int productCode;
    private int smsCode;

    @Override
    public String toString(){
        return "{" +
                "uid ='" + uid + '\'' +
                " operationUid='" + operationId + '\'' +
                " systemName='" + systemName + '\'' +
                " systemTime='" + systemTime + '\'' +
                " source='" + source + '\'' +
                " communicationId='" + communicationId + '\'' +
                " templateId='" + templateId + '\'' +
                " productCode='" + productCode + '\'' +
                " smsCode='" + smsCode + '\'';
    }
}
