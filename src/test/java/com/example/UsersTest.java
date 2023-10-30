package com.example;

import org.junit.jupiter.api.Test;

public class UsersTest {

    @Test
    public void whenInitializeUser_thenReturnValidUser(){
        Users instance = Users.getInstance();
        assert instance.getUsers() != null;
    }
}
