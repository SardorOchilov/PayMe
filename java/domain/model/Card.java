package jk.uz.pdp.domain.model;

import java.util.UUID;

public class Card {
    private Long id;
    // number should be 16 digits
    private String number;
    // password should be 4 digits
    private String password;
    private String expiry;
    // HUMO or UZCARD
    private CardType type;
    private Double balance;
    // should be taken from User class (id)
    private UUID ownerId;
    private String bankName;

    public Card(String number, String password, String expiry,
                CardType type, Double balance, UUID ownerId, String bankName) {
        this.number = number;
        this.password = password;
        this.expiry = expiry;
        this.type = type;
        this.balance = balance;
        this.ownerId = ownerId;
        this.bankName = bankName;
    }

    public Card() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "number: " + number + " || " +
                "type: " + type + " || " +
                "balance: " + balance + " || " +
                "bankName: " + bankName;
    }
}
