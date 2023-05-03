"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Card = void 0;
class Card {
    constructor(number, password, expiry, type, ownerId, bankName) {
        this.number = number;
        this.password = password;
        this.expiry = expiry;
        this.type = type;
        this.ownerId = ownerId;
        this.bankName = bankName;
        this.balance = 0;
    }
    getId() {
        return this.id;
    }
    setId(newId) {
        this.id = newId;
    }
    depositeBalance(funds) {
        let money = this.balance;
        money += funds;
        this.balance = money;
    }
}
exports.Card = Card;
