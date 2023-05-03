import { UserRepository } from "../repository";

export class UserService extends UserRepository {
  login(phoneNumber: string, password: string) {
    const user = this.getByPhoneNumber(phoneNumber);

    if (user.password !== password) throw new Error("❌ Incorrect password");

    return user;
  }
}
