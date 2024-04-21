package com.develliotesco.userms.controller;

import com.develliotesco.userms.entity.User;
import com.develliotesco.userms.model.Bike;
import com.develliotesco.userms.model.Car;
import com.develliotesco.userms.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable int id) {
        User user = userService.getById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/cars/{userId}")
    public ResponseEntity<List<Car>> getCars(@PathVariable int userId) {
        List<Car> cars = userService.getCars(userId);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/bikes/{userId}")
    public ResponseEntity<List<Bike>> getBikes(@PathVariable int userId) {
        List<Bike> bikes = userService.getBikes(userId);
        return ResponseEntity.ok(bikes);
    }

    @PostMapping("/savecar/{userId}")
    public ResponseEntity<Car> saveCar(@PathVariable int userId, @RequestBody Car car) {
        Car carNew = userService.saveCar(userId, car);
        return ResponseEntity.status(HttpStatus.CREATED).body(carNew);
    }

    @PostMapping("/savebike/{userId}")
    public ResponseEntity<Bike> saveBike(@PathVariable int userId, @RequestBody Bike bike) {
        Bike bikeNew = userService.saveBike(userId, bike);
        return ResponseEntity.status(HttpStatus.CREATED).body(bikeNew);
    }

    @GetMapping("/getallvehicles/{userId}")
    public ResponseEntity<Map<String, Object>> getAllVehicles(@PathVariable int userId) {
        return ResponseEntity.ok(userService.getUserAndVehicles(userId));
    }
}
