package ru.markin.LaboratoryWork_5.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.markin.LaboratoryWork_5.exception.UnsupportedCodException;
import ru.markin.LaboratoryWork_5.exception.ValidationFailedException;
import ru.markin.LaboratoryWork_5.model.Response;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult, Response response) throws ValidationFailedException, UnsupportedCodException;
}
