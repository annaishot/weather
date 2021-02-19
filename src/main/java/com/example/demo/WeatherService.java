package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class WeatherService {
    @Autowired
    HttpRequest httpRequest;

    public Weather getData(String city){
      return httpRequest.httpRequest(city);
    }


}
