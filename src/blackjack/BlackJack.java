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
                System.out.println("DEALER:");
                printDealerHand(dealer);
                System.out.printf("USER:");
                printHand(user);
                System.out.println("---------");
                System.out.println("1. Hit \n2. Stay");
                System.out.println("");
                bustedCheck(user);

                while (user.getValue() < 21) {
                    int cont = input.nextInt();
                    if (cont == 2) {
                        break;
                    }
                    user.Draw(deck);
                    printHand(user);
                    bustedCheck(user);
                }
            }
            case 2:
                break;
        }
    }

    public static void printHand(Player obj) {
        System.out.printf("Value : %d", obj.getValue());
        System.out.print("  |  ");
        System.out.print("Cards: ");
        for (int i = 0; i < obj.getSize(); i++) {
            System.out.print(obj.getRank(i) + " ");
        }
        System.out.println("");
    }

    public static void printDealerHand(Player obj) {
        System.out.printf("Value : %d", obj.getValue());
        System.out.print("  |  ");
        System.out.print("Cards: ");
        for (int i = 0; i < obj.getSize(); i++) {
            if (i == obj.getSize() - 1) {
                System.out.print("X");
            } else {
                System.out.print(obj.getRank(i) + " ");
            }
        }
        System.out.println("");
    }

    public static boolean bustedCheck(Player obj) {
        if (obj.getValue() >= 21) {
            System.out.println("BUSTED!");
            return true;
        } else {
            return false;
        }
    }

}
