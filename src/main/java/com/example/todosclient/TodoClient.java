package com.example.todosclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@FeignClient(name = "todos-service")
public interface TodoClient {

    @RequestMapping(method = RequestMethod.GET)
    List<Todo> getTodos();

}
