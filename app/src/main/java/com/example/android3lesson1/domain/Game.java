package com.example.android3lesson1.domain;

import android.os.Handler;
import android.util.Log;

import com.example.android3lesson1.ui.CheckFinishListener;
import com.example.android3lesson1.ui.EmojiGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game<Content> {

    private List<Card<Content>> cards = new ArrayList<>();

    private Card<Content> previousCard;
    private int chooserCount = 0;
    private Handler handler;

    private CheckFinishListener checkedListener;

    public void setListener (CheckFinishListener checkedListener){
        this.checkedListener = checkedListener;
    }

    public Game(List<Content> contents) {
        handler = new Handler();
        for (int i = 0; i < contents.size(); i++) {
            cards.add(new Card<>(i * 2, false, false, contents.get(i)));
            cards.add(new Card<>((i * 2) + 1, false, false, contents.get(i)));
        }
        Collections.shuffle(cards);
    }

    public void choose(Card<Content> card) {
        if (chooserCount < 1) {
            previousCard = card;
            chooserCount++;
            card.setFaceUp(!card.isFaceUp());
        } else if (chooserCount < 2){
            chooserCount++;
            card.setFaceUp(!card.isFaceUp());
            handler.postDelayed(() -> checkPairs(card, previousCard),1500);
        }
    }

    private void checkPairs(Card<Content> card, Card<Content> previousCard) {
//        for (int i = 0; i < cards.size(); i++) {
//            if (cards.get(i).isFaceUp()
//                    && cards.get(i).getContent().equals(card.getContent())
//                    && cards.get(i).getId() != card.getId()
//            ){
//
//            }
//        }
        if (card.getContent().equals(previousCard.getContent())) {
            cards.remove(card);
            cards.remove(previousCard);
        } else {
            for (Card<Content> model : cards) {
                model.setFaceUp(false);
            }
        }
        clearChooses();
    }

    private void clearChooses() {
        chooserCount = 0;
        checkedListener.checked();
    }

    public List<Card<Content>> getCards() {
        return cards;
    }
}
