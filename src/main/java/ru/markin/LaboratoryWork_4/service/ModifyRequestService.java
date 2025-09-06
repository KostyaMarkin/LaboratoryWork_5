package ru.markin.LaboratoryWork_4.service;

import ru.markin.LaboratoryWork_4.model.Request;

public interface ModifyRequestService {

    void modify(Request request);

    void changeSystemNameRequest(Request request);
}
