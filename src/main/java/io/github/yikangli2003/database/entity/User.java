package io.github.yikangli2003.database.entity;

public record User(
        String id,
        String email,
        String hashedPassword,
        String name,
        String signUpTime
) {}