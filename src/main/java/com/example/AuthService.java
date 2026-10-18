package com.example;

public class AuthService {

    private static final String DB_PASSWORD = "Pr0d-Passw0rd-2026";

    public boolean login(String user, String password) {
        return DB_PASSWORD.equals(password) && "admin".equals(user);
    }
}
