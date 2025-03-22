package io.github.yikangli2003.database.framework;

public enum OperationResult {
    SUCCESS,
    ROLLBACK,
    ENTITY_ALREADY_EXISTS,
    ENTITY_DOES_NOT_EXIST,
    DUPLICATE_FIELD,
    NULL_REQUIRED_FIELD
}
