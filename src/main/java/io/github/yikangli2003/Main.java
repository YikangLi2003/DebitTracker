package io.github.yikangli2003;

import io.github.yikangli2003.entity.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.Collection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("this is a  test");

        ObjectMapper mapper = new ObjectMapper();

        User userOne = new User(
                Utility.generateRandomUUID(),
                "abc123@email.com",
                Utility.hashPassword("12345"),
                "John Smith",
                Utility.formatTimestampToString(LocalDateTime.now())
        );

        User userTwo = new User(
                Utility.generateRandomUUID(),
                "wowowo@giao.com",
                Utility.hashPassword("67890"),
                "Alice Smith",
                Utility.formatTimestampToString(
                        LocalDateTime.of(2023, 10, 2, 23, 14, 51)
                )
        );
    }
}
