package com.example.spring.boot.learn.bean.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponse {
    private String message;
    private int code;
    private Body body;

    public LoginResponse() {
    }

    public LoginResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }

    @Getter
    @Setter
    public static class Body {
        private String status;
        private String token;

        public Body() {
        }
    }
}