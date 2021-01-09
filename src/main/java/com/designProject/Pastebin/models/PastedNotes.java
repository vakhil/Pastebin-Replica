package com.designProject.Pastebin.models;

import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "notes")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PastedNotes implements Serializable {

    public PastedNotes() {
    }

    public PastedNotes(String urlAddress, String tier, String text, String accountId) {
        this.urlAddress = urlAddress;
        this.tier = tier;
        this.text = text;
        this.accountId = accountId;
    }


    @Id
    private String urlAddress;
    private String tier;

    private String text;
    private String accountId;

    @Column(name = "created_timestamp", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp timestamp;

}
