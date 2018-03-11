package com.teligen.licensemgr.controller;

import com.teligen.licensemgr.entity.City;
import com.teligen.licensemgr.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/testRestController")
public class TestRestController {
    @Autowired
    CityService cityService;

    @RequestMapping("/selectAll")
    public String test1() {
        List<City> list = cityService.selectAll();
        City city = new City();
        city.setName(new Date().toLocaleString());
        city.setState("status " + new Date().toLocaleString());
        cityService.insert(city);
        return "test selectAll!";
    }
}
