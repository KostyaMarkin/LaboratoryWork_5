package ru.markin.LaboratoryWork_5.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.markin.LaboratoryWork_5.service.AnnualBonusService;
import ru.markin.LaboratoryWork_5.util.Codes;
import ru.markin.LaboratoryWork_5.util.ErrorMessages;
import ru.markin.LaboratoryWork_5.exception.UnsupportedCodException;
import ru.markin.LaboratoryWork_5.exception.ValidationFailedException;
import ru.markin.LaboratoryWork_5.model.Request;
import ru.markin.LaboratoryWork_5.model.Response;
import ru.markin.LaboratoryWork_5.service.ModifyRequestService;
import ru.markin.LaboratoryWork_5.service.ModifyResponseService;
import ru.markin.LaboratoryWork_5.service.ValidationService;
import ru.markin.LaboratoryWork_5.util.DateTimeUtil;
import ru.markin.LaboratoryWork_5.util.ErrorCodes;

import java.util.Date;

@Slf4j
@RestController
public class MyController {

    private final ValidationService validationService;
    private final ModifyResponseService modifyResponseService;
    private final ModifyRequestService modifyRequestService;
    private final AnnualBonusService annualBonusService;

    @Autowired
    public MyController(ValidationService validationService, @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService,
                        ModifyRequestService modifyRequestService, ModifyRequestService modifyRequestService1, AnnualBonusService annualBonusService) {
        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;
        this.modifyRequestService = modifyRequestService1;
        this.annualBonusService = annualBonusService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedBack(@Valid @RequestBody Request request, BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodException {

        log.info("request: {}", request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationId(request.getOperationId())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()).toString())
                .code(Codes.SUCCES)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();
        validationService.isValid(bindingResult, response);
        if(!response.getErrorCode().equals(ErrorCodes.EMPTY)) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        modifyResponseService.modify(response);
        modifyRequestService.modify(request);
        response.setAnnualBonus(
                annualBonusService.calculateAnnualBonus(
                        request.getPosition(),
                        request.getSalary(),
                        request.getBonus(),
                        request.getWorkDays()
                )
        );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
