package com.example.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignInControllerTesting {

    @Test
    void goBack() {
        var goB = new SignInController();
        assertNotNull(goB);
    }

    @Test
    void userSignup() {
        var signUp = new SignInController();
        assertNotNull(signUp);
    }
}