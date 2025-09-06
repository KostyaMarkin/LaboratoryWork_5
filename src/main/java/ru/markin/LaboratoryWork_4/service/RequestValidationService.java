package ru.markin.LaboratoryWork_4.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.markin.LaboratoryWork_4.exception.UnsupportedCodException;
import ru.markin.LaboratoryWork_4.exception.ValidationFailedException;
import ru.markin.LaboratoryWork_4.model.Request;

@Service
public class RequestValidationService implements ValidationService {
    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodException {
        Object object = bindingResult.getTarget();
        if(bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult.getFieldError().toString());
        }else if(((Request) object).getUid().equals("123")){
            throw new UnsupportedCodException("Ошибка несопостоавимых данных, значение uid не должно равняться \"123\"");
        }
    }
}
