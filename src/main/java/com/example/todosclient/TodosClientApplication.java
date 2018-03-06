package com.example.todosclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/client/todos")
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrixDashboard
@EnableHystrix
public class TodosClientApplication {

    @Autowired
    TodoClient todoClient;

    public static void main(String[] args) {
        SpringApplication.run(TodosClientApplication.class, args);
    }

    @GetMapping
    public ResponseEntity<List<TodoLight>> getTodosLight() {
        List<Todo> todos = todoClient.getTodos();
        List<TodoLight> t = new ArrayList<>();
        TodoLight tl = new TodoLight();
        tl.setId(todos.get(0).getId());
        tl.setTitle(todos.get(0).getTitle());
        tl.setHost(todos.get(0).getHostPort());
        t.add(tl);
        return ResponseEntity.ok(t);
    }
}
