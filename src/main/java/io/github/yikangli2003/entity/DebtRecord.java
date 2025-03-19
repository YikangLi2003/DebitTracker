package io.github.yikangli2003.entity;

import java.io.Serializable;
import java.util.List;

public class DebtRecord implements Serializable {
    private String id;
    private String creatorUserId;
    private String debtorUserId;
    private String creditorUserId;
    private float amount;
    private String currency;
    private String creationTime;
    private String description;
    private List<ModificationLog>  modificationLogs;

    public DebtRecord() {}

    public DebtRecord(
            String id,
            String creatorUserId,
            String debtorUserId,
            String creditorUserId,
            float amount,
            String currency,
            String creationTime,
            String description,
            List<ModificationLog> modificationLogs
    ) {
        this.id = id;
        this.creatorUserId = creatorUserId;
        this.debtorUserId = debtorUserId;
        this.creditorUserId = creditorUserId;
        this.amount = amount;
        this.currency = currency;
        this.creationTime = creationTime;
        this.description = description;
        this.modificationLogs = modificationLogs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(String creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    public String getDebtorUserId() {
        return debtorUserId;
    }

    public void setDebtorUserId(String debtorUserId) {
        this.debtorUserId = debtorUserId;
    }

    public String getCreditorUserId() {
        return creditorUserId;
    }

    public void setCreditorUserId(String creditorUserId) {
        this.creditorUserId = creditorUserId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ModificationLog> getModificationLogs() {
        return modificationLogs;
    }

    public void setModificationLogs(List<ModificationLog> modificationLogs) {
        this.modificationLogs = modificationLogs;
    }
}
