package ru.markin.LaboratoryWork_5.util;

import lombok.Getter;

@Getter
public enum Positions {
    DEV(2.2,false),
    HR(1.2,false),
    TL(2.6,true),
    AS(1.1,false),
    DEVOps(1.7,false),
    TS(2,false);


    private final double positionCoefficient;
    private final boolean isManager;

    Positions(double positionCoefficient, boolean isManager) {
        this.positionCoefficient = positionCoefficient;
        this.isManager = isManager;
    }
}
