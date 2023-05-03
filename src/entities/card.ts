type CARD_TYPE = "UZCARD" | "HUMO";
export class Card {
  private id: number;
  balance = 0;
  constructor(
    public number: string,
    public password: string,
    public expiry: string,
    public type: CARD_TYPE,
    public ownerId: number,
    public bankName: string
  ) {}

  getId() {
    return this.id;
  }

  setId(newId: number) {
    this.id = newId;
  }

  depositeBalance(funds: number){
    let money = this.balance;
    money += funds;
    this.balance = money;
  }
}