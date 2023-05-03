import { User } from "../entities";

export class UserRepository {
  private list: User[] = [];
  private counterID = 0;

  add(Users: User[]) {
    for (let user of Users) {
      if (this.isExist(user.phoneNumber))
        throw new Error(`${user.phoneNumber} is already exist`);
      user.setId(++this.counterID);
      this.list.push(user);
    }
  }

  isExist(phoneNumber: string) {
    for (let user of this.list) {
      if (user.phoneNumber === phoneNumber) return true;
    }

    return false;
  }

  getByPhoneNumber(phoneNumber: string) {
    for (let user of this.list) {
      if (user.phoneNumber === phoneNumber) return user;
    }

    throw new Error(`${phoneNumber} is not exist`);
  }

  getById(id: number) {
    for (let user of this.list) {
      if (user.getId() === id) return user;
    }

    throw new Error(`${id} is not exist`);
  }

  getList() {
    return this.list;
  }
}