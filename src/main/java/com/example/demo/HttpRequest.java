package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HttpRequest {
    public static Weather httpRequest(String city) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String uri = "http://api.weatherapi.com/v1/current.json?key=db8202e14a334820be543229211802&q=" + city;
        HttpGet httpGet = new HttpGet(uri);
        Weather w = null;
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);//执行请求
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {//请求成功执行
                HttpEntity entity = response.getEntity();//获取返回的数据
                String s = EntityUtils.toString(entity);//转换成字符串
                JSONObject datas = JSONObject.parseObject(s);//转换成JSON格式

                JSONObject current = JSONObject.parseObject(datas.get("current").toString());
                String temp = current.get("temp_c").toString();
                System.out.println(temp);
                String last_updated = current.get("last_updated").toString();

                String wind_kph =  current.get("wind_kph").toString();
                JSONObject condition = JSONObject.parseObject(current.get("condition").toString());
                String weather = condition.get("text").toString();
                w = new Weather();
                w.setWeather(weather);
                w.setDate(last_updated);
                w.setTemperature(temp + "C");
                w.setWind(wind_kph + "km/h");
                w.setCity(city);
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return w;
    }


}
