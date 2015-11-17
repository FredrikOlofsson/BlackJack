package playingcards;

import java.util.Random;

public class Deck {
    private int index;
    private Card[] deck = new Card[52];
    
    
    public Deck(){
        newDeck();
    }
    
    ////////////////////////////////////////////////////////////////////
    private void newDeck(){
        for (int suit = 0; suit <=3; suit ++){
            for (int rank = 1; rank <=13; rank ++){
                this.deck[this.index] = new Card(suit, rank);
                this.index++;
            }
        }
    }
    public Card[] deckArray(){
        return this.deck;
    }
    public Card[] removeCard(int amount){
        int newDeckSize = deck.length-amount;
        Card[] newdeck = new Card[newDeckSize];
        
        for(int i=0; i<newDeckSize ; i++){
            newdeck[i] = deck[i];
        }
        this.deck = newdeck;
        this.index  = this.deck.length-1;
        return this.deck;
    }
    
    public void setIndex(int i){ this.index = i; }
    public int getlenght(){
        return this.deck.length;
    }
    public Card getCard(){
        return this.deck[index-1];        
    }
    public Object takeCard(){
        Object temp = this.deck[1];
        this.removeCard(1);
        return temp;
    }
    
    public Card[] shuffle(){
        scuffleCards(this.deck);
        return this.deck;
    }
    private static void scuffleCards(Card[] array)    {
        int index;
        Card temp;
        Random rng = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = rng.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
    
    
    public void printDeck(){
        for (Object i : deck) {
            System.out.println(i);
        }
    }
    
    
    
    /* TODO:
    public findCard()   - Finds card place in deck
    public void shuffle()
    public deal() (Need to remember what card are left and delete from deck[]
    */
    
   
}
