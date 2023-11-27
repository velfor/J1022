public class Dealer extends Hand{
    @Override
    public void play(Deck deck) {
        do{
            this.takeCard(deck);
            System.out.println(hand.toString());
            System.out.println("Dealer score " + this.getScore());
        }while(this.getScore() < 17);
    }
}
