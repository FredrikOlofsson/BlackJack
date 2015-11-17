package blackjack;

import playingcards.Deck;
import java.util.Scanner;

public class BlackJack {

    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);
            int menuChoice;

            Messages.BlackJack();
            Messages.Menu_1();
            System.out.print("Choice : ");
            menuChoice = input.nextInt();

            switch (menuChoice) {
                case 1: {
                    Deck deck = new Deck();
                    Player user = new Player();
                    Player dealer = new Player();
                    deck.shuffle();

                    //Give Both User and Dealer hands
                    user.Draw(deck);
                    user.Draw(deck);
                    dealer.Draw(deck);
                    dealer.Draw(deck);

                    Messages.ClearScreen();
                    Messages.NewGame();
                    printDealerHand(dealer, false);
                    printHand(user);
                    
                    //If unlucky and get 21+ first draw
                    if (bustedCheck(user) == true){ 
                        Messages.printUserLost();
                        break;
                    }
                    
                    //Let's the user choose when to stay
                    while (user.getValue() <= 21 && bustedCheck(user) == false) {
                        System.out.println("---------");
                        System.out.println("1. Hit \n2. Stay");
                        int cont = input.nextInt();
                        if (cont == 2) break;       
                        user.Draw(deck);
                        printHand(user);
                    }

                    System.out.println("\n\n\n\n");
                    printDealerHand(dealer, true);
                    //If unlucky and gets 21+ first draw 
                    //wins if player gets buster first
                    if (bustedCheck(dealer) == true
                            && bustedCheck(user) == false){
                            Messages.printDealerLost();
                            break;
                    }
                    
                    //Draws until it either get's over player's hand or get's busted
                    //Does not execute if user has been busted
                    while (dealer.getValue() < user.getValue()
                            && bustedCheck(user) != true
                            && bustedCheck(dealer) == false) {
                        dealer.Draw(deck);
                        System.out.println("Dealer Draws!");
                        printDealerHand(dealer, true);
                    }

                    //Player wins if he either has higher score then the dealer
                    //or is the dealer got busted!
                    if (dealer.getValue() < user.getValue()
                            || bustedCheck(dealer) == true
                            && bustedCheck(user) == false) {
                        Messages.printDealerLost();
                    } else if (dealer.getValue() > user.getValue()
                            || bustedCheck(user) == true
                            && bustedCheck(dealer) == false) {
                        Messages.printUserLost();
                    }
                    
                }
                
                case 2: break;
            }
        }
    }
    

////////////////////////////////////////////////////////////////////////////////

public static void printHand(Player obj) {
        System.out.printf("Player : %d", obj.getValue());
        System.out.print("  |  ");
        System.out.print("Cards: ");
        for (int i = 0; i < obj.getSize(); i++) {
            System.out.print(obj.getRank(i) + " ");
        }
        System.out.println("");
    }

    public static void printDealerHand(Player obj, boolean showHand) {
        if (showHand == true) {
            System.out.printf("Dealer : %d", obj.getValue());
        } else {
            System.out.print("Dealer : ??");
        }
        System.out.print("  |  ");
        System.out.print("Cards: ");
        for (int i = 0; i < obj.getSize(); i++) {
            if (i == obj.getSize() - 1 && showHand == false) {
                System.out.print("X");
            } else {
                System.out.print(obj.getRank(i) + " ");
            }
        }
        System.out.println("");
    }

    public static boolean bustedCheck(Player obj) {
        return obj.getValue() > 21;
    }
}
