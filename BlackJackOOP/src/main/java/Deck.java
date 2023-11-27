import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> deck;

    public Deck(){
        deck = new ArrayList<>(52);
        CardRank[] cardRanks = CardRank.values();
        for(CardRank rank: cardRanks) {
            for (int i = 0; i < 4; i++) {
                deck.add(new Card(rank));
            }
        }
        Collections.shuffle(deck);
    }

    Card giveCard(){
        Card card = deck.get(deck.size()-1);
        deck.remove(deck.size()-1);
        return card;
    }
}
