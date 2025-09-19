package ru.markin.LaboratoryWork_5.service;

import ru.markin.LaboratoryWork_5.model.Request;

public interface ModifyRequestService {

    void modify(Request request);

    void changeSystemNameRequest(Request request);
}
