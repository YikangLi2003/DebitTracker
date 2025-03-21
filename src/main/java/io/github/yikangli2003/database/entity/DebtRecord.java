package io.github.yikangli2003.database.entity;

public record DebtRecord (
        String id,
        String creatorUserId,
        String debtorUserId,
        String creditorUserId,
        Float amount,
        String creationTime,
        String description
) {}