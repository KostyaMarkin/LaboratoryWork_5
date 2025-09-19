package ru.markin.LaboratoryWork_5.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.markin.LaboratoryWork_5.model.Response;

import java.util.UUID;

@Service
@Qualifier("ModifyOperationUidResponseService")
public class ModifyOperationUidResponseService implements ModifyResponseService {


    @Override
    public Response modify(Response response){
        UUID uuid = UUID.randomUUID();

        response.setOperationId(uuid.toString());

        return response;
    }
}
