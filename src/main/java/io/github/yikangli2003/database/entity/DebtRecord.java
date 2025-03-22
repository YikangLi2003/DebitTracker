package io.github.yikangli2003.database.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public record DebtRecord (
        UUID id,
        UUID creatorUserId,
        UUID creditorUserId,
        UUID debtorUserId,
        Float amount,
        LocalDateTime creationTime,
        String description
) {}