import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Card {
    private CardRank cardRank;
    public String toString(){
        String s = null;
        if (cardRank == CardRank.R2) s = "2";
        else if (cardRank == CardRank.R3) s = "3";
        else if (cardRank == CardRank.R4) s = "4";
        else if (cardRank == CardRank.R5) s = "5";
        else if (cardRank == CardRank.R6) s = "6";
        else if (cardRank == CardRank.R7) s = "7";
        else if (cardRank == CardRank.R8) s = "8";
        else if (cardRank == CardRank.R9) s = "9";
        else if (cardRank == CardRank.R10) s = "10";
        else if (cardRank == CardRank.RJ) s = "J";
        else if (cardRank == CardRank.RQ) s = "Q";
        else if (cardRank == CardRank.RK) s = "K";
        else if (cardRank == CardRank.RA) s = "A";
        s = s + " ";
        return s;
    }
    public int getScore() {
        int score = 0;
        if      (cardRank == CardRank.R2) score = 2;
        else if (cardRank == CardRank.R3) score = 3;
        else if (cardRank == CardRank.R4) score = 4;
        else if (cardRank == CardRank.R5) score = 5;
        else if (cardRank == CardRank.R6) score = 6;
        else if (cardRank == CardRank.R7) score = 7;
        else if (cardRank == CardRank.R8) score = 8;
        else if (cardRank == CardRank.R9) score = 9;
        else if (cardRank == CardRank.R10) score = 10;
        else if (cardRank == CardRank.RJ) score = 10;
        else if (cardRank == CardRank.RQ) score = 10;
        else if (cardRank == CardRank.RK) score = 10;
        else if (cardRank == CardRank.RA) score = 11;
        return score;
    }
};