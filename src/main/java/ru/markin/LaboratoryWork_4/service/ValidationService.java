package ru.markin.LaboratoryWork_4.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.markin.LaboratoryWork_4.exception.UnsupportedCodException;
import ru.markin.LaboratoryWork_4.exception.ValidationFailedException;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException, UnsupportedCodException;
}
