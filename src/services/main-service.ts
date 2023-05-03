import { UserRepository, CardRepository } from "../repository";
import { User, Card } from "../entities";

export class MainService {
  userRepository = new UserRepository();
  cardRepository = new CardRepository();

  getCardsByPhoneNumber(phoneNumber: string) {
    const id = this.userRepository.getByPhoneNumber(phoneNumber).getId();
    return this.cardRepository.getCardsByOwnerID(id);
  }

  getCardList() {
    return this.cardRepository.getList();
  }

  getUserList() {
    return this.userRepository.getList();
  }

  register(...user: User[]) {
    this.userRepository.add(user);
  }

  registerCard(...card: Card[]) {
    this.cardRepository.add(card);
  }

  transaction(senderCard: Card, recieverCard: Card, funds: number) {
    this.cardRepository.transactionCard(senderCard, recieverCard, funds);
  }
}
