package com.canuncuoglu.runners;


import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {
    public String getWelcomeMessage(){
        return "hello world.";
    }
}
