package ru.markin.LaboratoryWork_5.service;

import org.springframework.stereotype.Service;
import ru.markin.LaboratoryWork_5.util.Positions;

@Service
public interface AnnualBonusService {
    double calculateAnnualBonus(Positions positions, double salary, double bonus, int workDays);
}
