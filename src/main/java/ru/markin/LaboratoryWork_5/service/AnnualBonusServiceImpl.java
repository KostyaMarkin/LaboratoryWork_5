package ru.markin.LaboratoryWork_5.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.markin.LaboratoryWork_5.util.Positions;

import java.text.DecimalFormat;
import java.util.Calendar;

@Slf4j
@Service
public class AnnualBonusServiceImpl implements AnnualBonusService {

    @Override
    public double calculateAnnualBonus(Positions positions, double salary, double bonus, int workDays) {
        int days = getDaysToYear();
        double result = salary * bonus * days * positions.getPositionCoefficient() / workDays;
        log.info("Calculated annualBonus for " + positions.name() + " done! ");
        return (result + calculateQarterlyBonus(positions, result));
    }

    public double calculateQarterlyBonus(Positions positions, double averageSalary) {
        double bonus = 0;
        if ( isEndQuarter()) {
            if(positions.isManager()){
                bonus = averageSalary * 1.5;
                log.info("Calculated quarterly bonus for " + positions.name() + " done! ");
            }
        }

        return bonus;
    }

    private int getDaysToYear(){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        if(year % 4 == 0 ||( year % 100 == 0 && year % 400 == 0)){
            return 366;
        }else{
            return  365;
        }
    }

    private boolean isEndQuarter(){
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        return month % 3 == 0;
    }
}
