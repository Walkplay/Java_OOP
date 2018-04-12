package com.tasks3.carddeck;
public class Deck {
    public int topCard = 36;

    public Card[] cards = new Card[36];

    public Deck() {

        for (int i = 0; i < 36; i++) {
            cards[i] = new Card(Rank.values[i % 9],Suit.values[i % 4]);
        }
    }

    //sorts deck in random order:
    public void shuffle() {
        Card[] left = new Card[18];
        Card[] right = new Card[18];
        Card[] shift = new Card[1];

        for (int n = 0; n < 61; n++) {
            for (int i = 0; i < 18; i++) {
                left[i] = cards[i];
                right[i] = cards[i + 18];
            }

            for (int i = 0, j = 0, k = 0; i < 36; i++) {
                if ((i % 2) == 1) {
                    cards[i] = right[j];
                    j++;
                } else {
                    cards[i] = left[k];
                    k++;

                }
            }
            shift[0] = cards[0];
            cards[0] = cards[35];
            cards[35] = shift[0];
        }
    }
    public void order() {
        int k = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 9; j++) {
                cards[k] = new Card(Rank.values[j],Suit.values[i]);
                k++;
            }
        }
    }

    public boolean hasNext() {
        if (topCard > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Card drawOne() {
        if (hasNext()) {
            topCard--;
            return cards[topCard];
        } else {
            return null;
        }
    }
}