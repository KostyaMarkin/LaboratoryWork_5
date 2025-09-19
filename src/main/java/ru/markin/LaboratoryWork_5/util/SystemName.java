package ru.markin.LaboratoryWork_5.util;

public enum SystemName {
    ERP("Enterprise Resource Planning"),
    CRM("Customer Relationship Management"),
    WMS("Warehouse Management System"),
    Sv1("Service 1"),
    Sv2("Service 2");
    private final String name;

    private SystemName(String name) {
        this.name = name;
    }
}
