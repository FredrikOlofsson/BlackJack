package blackjack;

import playingcards.Deck;
import java.util.Scanner;

public class BlackJack {

    public static void main(String[] args) {
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

                if (bustedCheck(user) == true) {
                    System.out.println("Busted!");
                    System.out.print("Dealer Wins!\n");
                    return;
                }
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

                if (bustedCheck(dealer) == true) {
                    System.out.println("Busted!");
                    System.out.print("User Wins!");
                    return;
                }
                while (dealer.getValue() < user.getValue()
                        && bustedCheck(user) == false
                        && bustedCheck(dealer) == false) {
                    dealer.Draw(deck);
                    System.out.println("Dealer Draws!");
                    printDealerHand(dealer, true);
                }

                if (dealer.getValue() > user.getValue() && dealer.getValue() > 21) {
                    System.out.println("PLAYER WINS!");
                } else {
                    System.out.println("DEALER WINS!");
                }

            }
            case 2:
                break;
        }

////////////////////////////////////////////////////////////////////////////////
    }

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
        return obj.getValue() >= 21;
    }

}
