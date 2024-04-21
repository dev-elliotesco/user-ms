package com.develliotesco.userms.service;

import com.develliotesco.userms.entity.User;
import com.develliotesco.userms.feignclients.BikeFeignClient;
import com.develliotesco.userms.feignclients.CarFeignClient;
import com.develliotesco.userms.model.Bike;
import com.develliotesco.userms.model.Car;
import com.develliotesco.userms.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final RestTemplate restTemplate;

    private final CarFeignClient carFeignClient;

    private final BikeFeignClient bikeFeignClient;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<Car> getCars (int userId) {
        return restTemplate.getForObject("http://car-ms/cars/byuser/" + userId, List.class);
    }

    public List<Bike> getBikes (int userId) {
        return restTemplate.getForObject("http://bike-ms/bikes/byuser/" + userId, List.class);
    }

    public Car saveCar (int userId, Car car) {
        car.setUserId(userId);
        return carFeignClient.save(car);
    }

    public Bike saveBike (int userId, Bike bike){
        bike.setUserId(userId);
        return bikeFeignClient.save(bike);
    }

    public Map<String, Object> getUserAndVehicles(int userId) {
        User user = userRepository.findById(userId).orElse(null);
        List<Car> cars = carFeignClient.getByUserId(userId);
        List<Bike> bikes = bikeFeignClient.getByUserId(userId);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("User", user);
        result.put("Cars", cars);
        result.put("Bikes", bikes);
        return result;
    }
}
