package jk.uz.pdp.domain.repository;

import jk.uz.pdp.domain.exception.DataNotFoundException;
import jk.uz.pdp.domain.exception.EPAMPaymentServerException;
import jk.uz.pdp.domain.model.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class CardRepository implements BaseCrudRepository<Card, Long> {
    private final List<Card> cardList = new ArrayList<>();
    private Long id = 0L;

    @Override
    public void create(Card card) {
        if(isExist(card.getNumber())) {
            throw new EPAMPaymentServerException("Card already exists");
        }
        card.setId(id++);
        cardList.add(card);
    }

    @Override
    public Card getById(Long id) {
        for (Card card:cardList) {
            if (card.getId().equals(id)){
                return card;
            }
        }
        throw new DataNotFoundException("There is not card with id: " + id);
    }

    @Override
    public List<Card> getList() {
        return cardList;
    }

    @Override
    public Card update(Card update) {
        int i = 0;
        for (Card card:cardList) {
            if (card.getId().equals(update.getId())){
                cardList.set(i,update);
                return card;
            }
            i++;
        }
        throw new DataNotFoundException("There is not card with this id " + update.getId());
    }

    @Override
    public void delete(Long id) {
        for (Card card:cardList) {
            if (card.getId().equals(id)){
                cardList.remove(card);
                break;
            }
        }
        throw new DataNotFoundException("There is not card with id: " + id);
    }

    public List<Card> getCardsByOwnerId(UUID ownerId) {
        List<Card> cards = new ArrayList<>();
        for(Card card:cardList) {
            if(card.getOwnerId().equals(ownerId)) {
                cards.add(card);
            }
        }

        if(cards.isEmpty()) {
            throw new DataNotFoundException("This user doesn't have any cards");
        }
        return cards;
    }

    private boolean isExist(String cardNumber) {
        for(Card card:cardList) {
            if(card.getNumber().equals(cardNumber)) {
                return true;
            }
        }
        return false;
    }
}
