package ru.markin.LaboratoryWork_5.service;

import org.junit.jupiter.api.Test;
import ru.markin.LaboratoryWork_5.util.Positions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AnnualBonusServiceImplTest {

    @Test
    void calculateAnnualBonus() {

        //given
        Positions position = Positions.HR;
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;

        //when
        double result = new AnnualBonusServiceImpl().calculateAnnualBonus(position, bonus, salary, workDays);

        //then
        double expectedResult = 360493.8271604938;
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void calculateQuarterlyBonus(){

        //given
        Positions position = Positions.TL;
        double avarageSalary  = 360493.8271604938;

        //when
        double result = new AnnualBonusServiceImpl().calculateQarterlyBonus(position,avarageSalary);

        //then
        double expectedResult = 540740.7407407407;
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void calculateQuarterlyBonusSecond(){

        //given
        Positions position = Positions.DEVOps;
        double avarageSalary  = 360493.8271604938;

        //when
        double result = new AnnualBonusServiceImpl().calculateQarterlyBonus(position,avarageSalary);

        //then
        double expectedResult = 0;
        assertThat(result).isEqualTo(expectedResult);
    }
}