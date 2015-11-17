package blackjack;
import playingcards.Card;
import playingcards.Deck;
import java.util.ArrayList;

public class Player {
    int index;
    ArrayList<Card> cards = new ArrayList<>();
    int totalValue;
    
    //Draw
    //Stay
    //Split 
    // Cards
    // CardValue
    
    private void Player(){
        this.index = 1;
    }
    ////////////////////////////////////////////////
    
    private void calcValue(){
        this.totalValue = 0;
        for (Card i : cards) {
            totalValue += i.rank();
        }
    } 
    
    public int getRank(int cardNum){
    return cards.get(cardNum).rank();
    }
    public int getValue(){
        calcValue();
        return totalValue;
    }
    public int getSize(){
        return this.cards.size();
    }
  
    public Deck Draw(Deck d){
        cards.add(d.getCard());
        d.removeCard(1);
        calcValue();
        this.index++;
        return d;
    }

    public boolean hasAce(){
        boolean t = false;
        for (int i=0; i<this.cards.size(); i++)
                if (this.getRank(i) == 1 || this.getRank(i) == 11){
                    System.out.println("yup");
                    t = true;
                }
        return t;
    }
    
     @Override
    public String toString() {
        return "Cards on hand: " + cards.size() + " Total Value: " + totalValue +" \n";
    }   
}
