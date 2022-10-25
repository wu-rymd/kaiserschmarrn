package com.ase.restservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents Account table.
 */
@Entity
@Table(name = "account")
public class Account {

  private String accountId;
  private Float balance;
  private Float startingBalance;

  public Account() {

  }

  /**
   * Represents an account.
   *
   * @param accountId ID of an account
   * @param balance Account balance
   * @param startingBalance Starting balance of an account
   */
  public Account(String accountId, Float balance, Float startingBalance) {
    this.accountId = accountId;
    this.balance = balance;
    this.balance = startingBalance;
  }

  @Id
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  @Column(name = "balance", nullable = false)
  public Float getBalance() {
    return balance;
  }

  public void setBalance(Float balance) {
    this.balance = balance;
  }

  @Column(name = "starting_balance", nullable = false)
  public Float getStartingBalance() {
    return startingBalance;
  }

  public void setStartingBalance(Float startingBalance) {
    this.startingBalance = startingBalance;
  }

  @Override
  public String toString() {
    return "Account [accountId=" + accountId + ", balance=" + balance
        + ", startingBalance=" + startingBalance + "]";
  }
}