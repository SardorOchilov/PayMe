"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.User = void 0;
class User {
    constructor(firstName, lastName, phoneNumber, password, isBlocked = false) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.isBlocked = isBlocked;
    }
    getId() {
        return this.id;
    }
    setId(newId) {
        this.id = newId;
    }
}
exports.User = User;
