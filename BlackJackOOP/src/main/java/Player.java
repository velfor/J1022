import java.util.Scanner;

public class Player extends Hand {
    private String name;

    Player(String name){
        this.name = name;
    }

    @Override
    public void play(Deck deck) {
        Scanner input = new Scanner(System.in);
        char choice = 'y';
        while(choice == 'y'){
            System.out.println(hand.toString());
            System.out.println("Your score " + this.getScore());
            this.takeCard(deck);
            System.out.println("Do you want another card? (y/n) ");
            choice = input.nextLine().charAt(0);
        }
    }
}
