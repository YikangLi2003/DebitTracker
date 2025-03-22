package io.github.yikangli2003.database.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public record ModificationLog(
        UUID modifiedDebtRecordId,
        UUID modifierUserId,
        LocalDateTime modificationTime,
        String modifiedAttribute,
        Object originalValue,
        Object newValue
) {
    public boolean containsNull() {
        return modifiedDebtRecordId == null ||
                modifierUserId == null ||
                modificationTime == null ||
                modifiedAttribute == null ||
                originalValue == null ||
                newValue == null;
    }
}
