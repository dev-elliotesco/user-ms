package com.develliotesco.userms.feignclients;

import com.develliotesco.userms.model.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "car-ms")
public interface CarFeignClient {

    @PostMapping("/cars")
    Car save(@RequestBody Car car);

    @GetMapping("/cars/byuser/{userId}")
    List<Car> getByUserId(@PathVariable int userId);
}
