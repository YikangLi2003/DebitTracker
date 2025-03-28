package io.github.yikangli2003.database.entity;

import java.util.UUID;
import java.time.LocalDateTime;

public record User(
        UUID id,
        String email,
        String hashedPassword,
        String name,
        LocalDateTime signUpTime
) {
    public boolean containsNull() {
        return id == null ||
                email == null ||
                hashedPassword == null ||
                name == null ||
                signUpTime == null;
    }
}