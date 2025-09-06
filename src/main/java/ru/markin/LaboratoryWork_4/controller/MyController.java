package ru.markin.LaboratoryWork_4.controller;

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
import ru.markin.LaboratoryWork_4.Codes;
import ru.markin.LaboratoryWork_4.ErrorMessages;
import ru.markin.LaboratoryWork_4.exception.UnsupportedCodException;
import ru.markin.LaboratoryWork_4.exception.ValidationFailedException;
import ru.markin.LaboratoryWork_4.model.Request;
import ru.markin.LaboratoryWork_4.model.Response;
import ru.markin.LaboratoryWork_4.service.ModifyRequestService;
import ru.markin.LaboratoryWork_4.service.ModifyResponseService;
import ru.markin.LaboratoryWork_4.service.ValidationService;
import ru.markin.LaboratoryWork_4.util.DateTimeUtil;
import ru.markin.LaboratoryWork_4.util.ErrorCodes;

import java.util.Date;

@Slf4j
@RestController
public class MyController {

    private final ValidationService validationService;
    private final ModifyResponseService modifyResponseService;
    private final ModifyRequestService modifyRequestService;

    @Autowired
    public MyController(ValidationService validationService, @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService,
                        ModifyRequestService modifyRequestService, ModifyRequestService modifyRequestService1) {
        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;
        this.modifyRequestService = modifyRequestService1;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedBack(@Valid @RequestBody Request request, BindingResult bindingResult){

        log.info("request: {}", request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationId(request.getOperationId())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()).toString())
                .code(Codes.SUCCES)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();
        try{
            validationService.isValid(bindingResult);
        } catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }catch (UnsupportedCodException e){
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNSOPPORTED);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOW_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNSOPPORTED);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        modifyResponseService.modify(response);
        modifyRequestService.modify(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
