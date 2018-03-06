package com.example.todosclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("todos-service")
public interface TodoClient {

    @RequestMapping(method = RequestMethod.GET, value = "/todos")
    List<Todo> getTodos();

}
