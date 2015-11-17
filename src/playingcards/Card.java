package playingcards;

public class Card {
    private int suit; //Clubs, Diamonds, Hearts, Spades
    private int rank; //1- 13 (ACE = 1)
    
    public Card(){
        this.suit = 0;
        this.rank = 0;
    }            
    /** 
     * Creates a card from integer (1-52)
     * @param cardNum 
     */
    public Card(int cardNum){
        this.suit = cardNum % 13;
        this.rank = (cardNum/13) % 4;
    }
    /**
     * Creates a playing card!
     * @param suit Clubs = 0, Diamond = 1, Hearts = 2, Spades = 3
     * @param rank ACE = 1, TWO = 2, THREE = 3 etc..
     */
    public Card(int suit, int rank){
        this.suit = suit;
        this.rank = rank;
    }

////////////////////////////////////////////////////////////////////////////////
    /**
     * Get the rank of the card
     * @return 
     */
    public int rank() { return this.rank; }
    /** 
     * Get the suit of the card
     * @return
     */
    public int suit() { return this.suit; }
    /**
     * Compare if the SUITS match each other.
     * @param c The card to compare to this card
     * @return 'true' if the suits match
     */
    public boolean sameSuit(Card c){ return (this.suit == c.suit); }
    /**
     * Compare if the RANKs match each other.
     * @param c The card to compare to this card
     * @return 'true' if the ranks match
     */
    public boolean sameRank(Card c){ return (this.rank == c.rank); }
    /**
     * Compare if the CARDS match each other.
     * @param c The card to compare to this card
     * @return 'true' if both the suits and the ranks match
     */
    public boolean sameCard(Card c) {
        return ((this.rank == c.rank) && (this.suit == c.suit));
    }

    
    @Override
    public String toString() {
        return "Card{" + "suit=" + Suits.NAME[this.suit] + ", rank=" + Ranks.NAME[this.rank] + '}';
    }
    
    
    
    
    
}