package com.example.movieslist.moviefinder.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesList_api {
   private ConnecttoChatGpt askGpt;

    @RequestMapping ("/")
    public String MoviesList()

    {
        String prompt="give me the List of 10 telugu movies released in 2010";
        String model="gpt-3.5-turbo";
        String requestbody = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}]}";
        askGpt=new ConnecttoChatGpt("apikey","https://api.openai.com/v1/chat/completions",requestbody);

        return askGpt.requestGPT();
    }
}
