package com.example.movieslist.moviefinder.RestController;


import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class ConnecttoChatGpt {

   private String apiKey;
   private String apiurl;
    private String requestBody;

    public ConnecttoChatGpt(String apiKey, String apiurl, String requestBody) {
        this.apiKey = apiKey;
        this.apiurl = apiurl;
        this.requestBody =requestBody;
    }
   public String requestGPT()
   {
       HttpHeaders headers=new HttpHeaders();
       headers.set("Authorization", "Bearer " + this.apiKey);
       headers.setContentType(MediaType.APPLICATION_JSON);
       RestTemplate restTemplate=new RestTemplate();
       HttpEntity<String> requestEntity= new HttpEntity<>(requestBody, headers);
       ResponseEntity<String> responseEntity = restTemplate.exchange(apiurl, HttpMethod.POST, requestEntity, String.class);
       return responseEntity.getBody();
   }

}
