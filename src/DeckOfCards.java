import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class DeckOfCards {
    private List<Card> cards;

    public DeckOfCards() {
        cards = new ArrayList<>();
        for (String suit : Suit.values()) {
            for (int rank = 2; rank <= 13; rank++) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> deal(int numberOfCards) {
        List<Card> dealtCards = new ArrayList<>();
        for (int i = 0; i < numberOfCards; i++) {
            dealtCards.add(cards.remove(0));
        }
        return dealtCards;
    }

    public enum Suit {
        Clubs, Diamonds, Hearts, Spades
    }

    public class Card {
        private Suit suit;
        private int rank;

        public Card(Suit suit, int rank) {
            this.suit = suit;
            this.rank = rank;
        }

        public Suit getSuit() {
            return suit;
        }

        public int getRank() {
            return rank;
        }

        @Override
        public String toString() {
            return String.format("%s %d", suit.toString(), rank);
        }
    }
}
