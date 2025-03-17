package io.github.yikangli2003.entity;

import java.time.LocalDateTime;

public class User {
    private String id;
    private String email;
    private String hashedPassword;
    private String name;
    private LocalDateTime signUpTime;

    public User() {}

    public User(String id, String email, String hashedPassword, String name, LocalDateTime signUpTime) {
        this.id = id;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.name = name;
        this.signUpTime = signUpTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getSignUpTime() {
        return signUpTime;
    }

    public void setSignUpTime(LocalDateTime signUpTime) {
        this.signUpTime = signUpTime;
    }
}
