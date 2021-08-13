package com.example.android3lesson1.ui;

import com.example.android3lesson1.domain.Card;
import com.example.android3lesson1.domain.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmojiGame implements CheckFinishListener {

    private Game<String> game;

    public EmojiGame() {
        List<String> contents = new ArrayList<>();
        contents.add("\uD83D\uDE01");
        contents.add("\uD83D\uDE02");
        contents.add("\uD83D\uDE06");
        Collections.shuffle(contents);
        game = new Game<>(contents);
        game.setListener(this);
    }

    private CheckFinishListener checkedListener;

    public void setListener(CheckFinishListener checkedListener) {
        this.checkedListener = checkedListener;
    }

    public void choose(Card<String> card) {
        game.choose(card);
    }

    public List<Card<String>> getCards() {
        return game.getCards();
    }

    @Override
    public void checked() {
        checkedListener.checked();
    }
}
