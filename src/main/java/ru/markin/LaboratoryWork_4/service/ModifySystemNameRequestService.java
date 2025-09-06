package ru.markin.LaboratoryWork_4.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.markin.LaboratoryWork_4.model.Request;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
@Service
public class ModifySystemNameRequestService implements ModifyRequestService{

    @Override
    public void modify(Request request){
        changeSystemNameRequest(request);
        HttpEntity<Request> httpEntity = new HttpEntity<>(request);
        Date dateWorkRequestStart = new Date();
        new RestTemplate().exchange("http://localhost:8082/feedback",
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<>() {
                });
        Date dateWorkRequestEnd = new Date();
        log.info("time to work request - {} milliseconds", dateWorkRequestEnd.getTime() - dateWorkRequestStart.getTime());
    }

    @Override
    public void changeSystemNameRequest(Request request) {
        request.setSystemName("Service 1");
        request.setSource("Service 2");
    }
}
