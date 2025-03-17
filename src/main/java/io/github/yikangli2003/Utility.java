package io.github.yikangli2003;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.regex.Pattern;
import java.util.UUID;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utility {
    private static final BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder(12);
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    private static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String hashPassword(String plainPassword) {
        return PASSWORD_ENCODER.encode(plainPassword);
    }

    public static boolean isPasswordMatched(String plainPassword, String hashedPassword) {
        return PASSWORD_ENCODER.matches(plainPassword, hashedPassword);
    }

    public static boolean isValidEmail(String email) { return EMAIL_PATTERN.matcher(email).matches(); }

    public static String generateRandomUUID() { return UUID.randomUUID().toString(); }

    public static String formatTimestampToString(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern(TIMESTAMP_FORMAT));
    }

    public static LocalDateTime parseTimestampString(String timestampString) {
        return LocalDateTime.parse(timestampString, DateTimeFormatter.ofPattern(TIMESTAMP_FORMAT));
    }
}
