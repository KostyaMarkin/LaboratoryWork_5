package ru.markin.LaboratoryWork_5.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.markin.LaboratoryWork_5.exception.UnsupportedCodException;
import ru.markin.LaboratoryWork_5.exception.ValidationFailedException;
import ru.markin.LaboratoryWork_5.model.Request;
import ru.markin.LaboratoryWork_5.model.Response;
import ru.markin.LaboratoryWork_5.util.Codes;
import ru.markin.LaboratoryWork_5.util.ErrorCodes;
import ru.markin.LaboratoryWork_5.util.ErrorMessages;

@Slf4j
@Service
public class RequestValidationService implements ValidationService {
    @Override
    public void isValid(BindingResult bindingResult, Response response) throws ValidationFailedException, UnsupportedCodException {
        try{
            Validation(bindingResult);
        } catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
        }catch (UnsupportedCodException e){
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNSOPPORTED);
        } catch (Exception e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOW_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNSOPPORTED);
        }

    }

    private void Validation(BindingResult bindingResult) throws ValidationFailedException,UnsupportedCodException {
        Object object = bindingResult.getTarget();
        if(bindingResult.hasErrors()) {
            log.error(bindingResult.getFieldError().toString());
            throw new ValidationFailedException(bindingResult.getFieldError().toString());
        }else if(((Request) object).getUid().equals("123")){
            log.error("Ошибка несопоставимых данных, значение uid не должно равняться \"123\"");
            throw new UnsupportedCodException("Ошибка несопоставимых данных, значение uid не должно равняться \"123\"");
        }
    }
}
