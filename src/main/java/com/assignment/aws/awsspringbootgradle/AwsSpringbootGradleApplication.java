package com.assignment.aws.awsspringbootgradle;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@OpenAPIDefinition(info = @Info(title = "Assignment User API", version = "2.0", description = "User Information"))
public class AwsSpringbootGradleApplication {


    Map<UUID, User> hashMap = new HashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(AwsSpringbootGradleApplication.class, args);
    }

    @GetMapping("/api/health")
    public String getHealthCheckApi() {
        return "OK";
    }

    @GetMapping("/api/hello")
    public String sayHello() {
        return "Hello";
    }

    @PostMapping("/api/save-user")
    public User getHealthCheckApi(@RequestBody User user) {
        return this.hashMap.put(UUID.randomUUID(), user);
    }

    @GetMapping("/api/get-all-users")
    public Map<UUID, User> getAllUsers() {
        return this.hashMap;
    }

    @GetMapping("/api/get-user/{id}")
    public Map<UUID, User> getUser(@PathVariable(name = "id") UUID id) {
        return this.hashMap;
    }

    class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

    }
}
