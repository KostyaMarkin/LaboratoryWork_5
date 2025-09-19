package ru.markin.LaboratoryWork_5.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.markin.LaboratoryWork_5.util.Positions;
import ru.markin.LaboratoryWork_5.util.SystemName;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    /***
     * Уникальный идентификатор сообщения.
     */
    @NotBlank(message = "UID не может быть пустым")
    private String uid;
    /***
     * Уникальный идентификатор операции.
     */
    @NotBlank(message =  "Operation Uid не должен быть пустым")
    private String operationId;
    /***
     * Имя системы отправителя.
     */
    private SystemName systemName;
    /***
     * Время создания сообщения.
     */
    @NotBlank(message =  "Системное время не должено быть пустым")
    private String systemTime;
    /***
     * Наименование ресурса.
     */
    @NotBlank(message =  "Source не должен быть пустым")
    private String source;
    /***
     * Должность сотрудника.
     */
    private Positions position;
    /***
     * Зарплата сотрудника.
     */
    private Double salary;
    /***
     * Коэффициент к зарплате сотрудника.
     */
    private Double bonus;
    /***
     * Отработанные дни сотрудника
     */
    private Integer workDays;
    /***
     * Уникальный идентификатор коммуникации.
     */
    private int communicationId;
    /***
     * Уникальный идентификатор шаблона.
     */
    private int templateId;
    /***
     * Код продукта.
     */
    private int productCode;
    /***
     * Код смс.
     */
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
