
import java.util.LinkedList;
public class Player {
    private String name;
    private LinkedList<Card> cards;

    public Player(String name) {
        this.name = name;
        cards = new LinkedList<>();
    }

    public void receiveCard(Card card) {
        cards.add(card);
    }

    public void sortCards() {
        cards.sort((o1, o2) -> o1.getRank() - o2.getRank());
    }

    public String getName() {
        return name;
    }

    public LinkedList<Card> getCards() {
        return cards;
    }
}
