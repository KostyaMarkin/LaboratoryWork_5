package ru.markin.LaboratoryWork_5.model;

import lombok.Builder;
import lombok.Data;
import ru.markin.LaboratoryWork_5.util.Codes;
import ru.markin.LaboratoryWork_5.util.ErrorMessages;
import ru.markin.LaboratoryWork_5.util.ErrorCodes;

@Data
@Builder
public class Response {

    /***
     * Уникальный идентификатор сообщения.
     */
    private String uid;
    /***
     * Уникальный идентификатор операции.
     */
    private String operationId;
    /***
     * Имя системы отправителя.
     */
    private String systemTime;
    /***
     * Статус выполнения.
     */
    private Codes code;
    /***
     * Зарплата сотрудника с бонусами.
     */
    private Double annualBonus;
    /***
     * Код ошибки.
     */
    private ErrorCodes errorCode;
    /***
     * Сообщение ошибки.
     */
    private ErrorMessages errorMessage;
}
