package jk.uz.pdp.domain.service;

import jk.uz.pdp.domain.model.Card;
import jk.uz.pdp.domain.repository.CardRepository;
import jk.uz.pdp.domain.validator.CardValidator;

public class CardService extends CardRepository {
    CardValidator cardValidator = new CardValidator();

    public void add(Card card) {
        // validation process homework
        create(card);
    }


}
