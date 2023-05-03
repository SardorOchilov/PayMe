package jk.uz.pdp.domain.model;

public class Wallet {
    private Long id;
    private Double balance;
    // should be taken from User class
    private Long ownerId;

    public Wallet(Double balance, Long ownerId) {
        this.balance = balance;
        this.ownerId = ownerId;
    }

    public Wallet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
