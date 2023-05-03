"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.UserRepository = void 0;
class UserRepository {
    constructor() {
        this.list = [];
        this.counterID = 0;
    }
    add(Users) {
        for (let user of Users) {
            if (this.isExist(user.phoneNumber))
                throw new Error(`${user.phoneNumber} is already exist`);
            user.setId(++this.counterID);
            this.list.push(user);
        }
    }
    isExist(phoneNumber) {
        for (let user of this.list) {
            if (user.phoneNumber === phoneNumber)
                return true;
        }
        return false;
    }
    getByPhoneNumber(phoneNumber) {
        for (let user of this.list) {
            if (user.phoneNumber === phoneNumber)
                return user;
        }
        throw new Error(`${phoneNumber} is not exist`);
    }
    getById(id) {
        for (let user of this.list) {
            if (user.getId() === id)
                return user;
        }
        throw new Error(`${id} is not exist`);
    }
    getList() {
        return this.list;
    }
}
exports.UserRepository = UserRepository;
