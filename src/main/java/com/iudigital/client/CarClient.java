package com.iudigital.client;

import com.iudigital.client.dto.Car;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class CarClient {

    private final RestTemplate restTemplate;
    private static final String URL = "http://localhost:8005/api/car";

    public CarClient() {

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = 
                new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        
        restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(messageConverters);

    }
    
    public List<Car> getCars() {
        
        List<Car> cars = Arrays.asList(restTemplate.getForObject(URL, Car[].class));
        return cars;
        
    }
    
    public void createCar(Car car) {
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        Map<String, String> map = new HashMap<>();
        map.put("licencePlate", car.getLicencePlate());
        map.put("color", car.getColor());
        map.put("model", car.getModel());
        map.put("brand", car.getBrand());
        map.put("year", car.getYear());
        map.put("fuelType", car.getFuelType());
        map.put("numberDoors", car.getNumberDoors());
        map.put("transmission", car.getTransmission());
        map.put("motor", car.getMotor());
        map.put("kilometres", car.getKilometres());
        map.put("photo", car.getPhoto());
        
        HttpEntity<Map<String, String>> request = new HttpEntity<>(map, headers);
        
        ResponseEntity<Void> resp = restTemplate.exchange(URL, HttpMethod.POST, request, Void.class);
        
    }

}
