package io.github.yikangli2003.entity;

import java.io.Serializable;

public class ModificationLog implements Serializable {
    private String debtRecordId;
    private String ModifierUserId;
    private String modificationTime;
    private String modifiedAttribute;
    private Object originalValue;
    private Object newValue;

    public ModificationLog() {}

    public ModificationLog(
            String debtRecordId,
            String modifierUserId,
            String modificationTime,
            String modifiedAttribute,
            Object originalValue,
            Object newValue
    ) {
        this.debtRecordId = debtRecordId;
        this.ModifierUserId = modifierUserId;
        this.modificationTime = modificationTime;
        this.modifiedAttribute = modifiedAttribute;
        this.originalValue = originalValue;
        this.newValue = newValue;
    }

    public String getDebtRecordId() {
        return debtRecordId;
    }

    public void setDebtRecordId(String debtRecordId) {
        this.debtRecordId = debtRecordId;
    }

    public String getModifierUserId() {
        return ModifierUserId;
    }

    public void setModifierUserId(String modifierUserId) {
        ModifierUserId = modifierUserId;
    }

    public String getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(String modificationTime) {
        this.modificationTime = modificationTime;
    }

    public String getModifiedAttribute() {
        return modifiedAttribute;
    }

    public void setModifiedAttribute(String modifiedAttribute) {
        this.modifiedAttribute = modifiedAttribute;
    }

    public Object getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(Object originalValue) {
        this.originalValue = originalValue;
    }

    public Object getNewValue() {
        return newValue;
    }

    public void setNewValue(Object newValue) {
        this.newValue = newValue;
    }
}
