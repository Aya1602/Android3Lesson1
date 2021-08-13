package com.example.android3lesson1.domain;

public class Card <Content> {

    private int id;
    private boolean isFaceUp;
    private boolean isMatch;
    private Content content;

    public Card(int id, boolean isFaceUp, boolean isMatch, Content content) {
        this.id = id;
        this.isFaceUp = isFaceUp;
        this.isMatch = isMatch;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean faceUp) {
        isFaceUp = faceUp;
    }

    public boolean isMatch() {
        return isMatch;
    }

    public void setMatch(boolean match) {
        isMatch = match;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
