"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.MainService = void 0;
const repository_1 = require("../repository");
class MainService {
    constructor() {
        this.userRepository = new repository_1.UserRepository();
        this.cardRepository = new repository_1.CardRepository();
    }
    getCardsByPhoneNumber(phoneNumber) {
        const id = this.userRepository.getByPhoneNumber(phoneNumber).getId();
        return this.cardRepository.getCardsByOwnerID(id);
    }
    getCardList() {
        return this.cardRepository.getList();
    }
    getUserList() {
        return this.userRepository.getList();
    }
    register(...user) {
        this.userRepository.add(user);
    }
    registerCard(...card) {
        this.cardRepository.add(card);
    }
    transaction(senderCard, recieverCard, funds) {
        this.cardRepository.transactionCard(senderCard, recieverCard, funds);
    }
}
exports.MainService = MainService;
