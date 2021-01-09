package com.designProject.Pastebin.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "accounts")
public class AccountInfo {

    public AccountInfo() {
    }

    @Id
    private String accountId;
    private String tier;
}
