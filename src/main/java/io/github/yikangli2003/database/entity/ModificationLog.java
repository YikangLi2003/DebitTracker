package io.github.yikangli2003.database.entity;

public record ModificationLog(
        String modifiedDebtRecordId,
        String modifierUserId,
        String modificationTime,
        String modifiedAttribute,
        Object originalValue,
        Object newValue
) {}
