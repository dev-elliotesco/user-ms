package com.develliotesco.userms.feignclients;

import com.develliotesco.userms.model.Bike;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "bike-ms")
public interface BikeFeignClient {

    @PostMapping("/bikes")
    Bike save(@RequestBody Bike bike);

    @GetMapping("/bikes/byuser/{userId}")
    List<Bike> getByUserId(@PathVariable int userId);

}
