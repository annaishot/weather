package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @RequestMapping("/")
    public String hello(){
        return "index";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("weather")
    @ResponseBody
    public Weather getWeather(@RequestParam("city") String city){
     return weatherService.getData(city);

    }


}
