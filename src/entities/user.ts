export class User {
  private id: number;

  constructor(
    public firstName: string,
    public lastName: string,
    public phoneNumber: string,
    public password: string,
    public isBlocked = false
  ) {}

  getId() {
    return this.id;
  }

  setId(newId: number) {
    this.id = newId;
  }
}
