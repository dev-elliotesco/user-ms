package com.develliotesco.userms.feignclients;

import com.develliotesco.userms.model.Bike;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "bike-ms", url = "http://localhost:8003/bikes")
public interface BikeFeignClient {

    @PostMapping()
    Bike save(@RequestBody Bike bike);

    @GetMapping("/byuser/{userId}")
    List<Bike> getByUserId(@PathVariable int userId);

}
