package blackjack;

public class Messages {

    public static void BlackJack() {
        System.out.println(",-----.  ,--.              ,--.        ,--.              ,--.               ");
        System.out.println("|  |) /_ |  | ,--,--. ,---.|  |,-.     |  | ,--,--. ,---.|  |,-.            ");
        System.out.println("|  .-.  \\|  |' ,-.  || .--'|     /,--. |  |' ,-.  || .--'|     /           ");
        System.out.println("|  '--' /|  |\\ '-'  |\\ `--.|  \\  \\|  '-'  /\\ '-'  |\\ `--.|  \\  \\    ");
        System.out.println("`------' `--' `--`--' `---'`--'`--'`-----'  `--`--' `---'`--'`--'  \n       ");
    }

    public static void NewGame() {
        System.out.println("    _   __             ______                   ");
        System.out.println("   / | / /__ _      __/ ____/___ _____ ___  ___ ");
        System.out.println("  /  |/ / _ \\ | /| / / / __/ __ `/ __ `__ \\/ _ \\");
        System.out.println(" / /|  /  __/ |/ |/ / /_/ / /_/ / / / / / /  __/");
        System.out.println("/_/ |_/\\___/|__/|__/\\____/\\__,_/_/ /_/ /_/\\___/ \n\n");
    }

    public static void ClearScreen() {
        System.out.println("                                                ");
        System.out.println("                                                ");
        System.out.println("                                                ");
        System.out.println("                                                ");
        System.out.println("                                                ");
        System.out.println("                                                ");
        System.out.println("                                                ");
        System.out.println("                                                ");
        System.out.println("                                                ");
        System.out.println("                                                ");
        System.out.println("                                                ");
        System.out.println("                                                ");
        System.out.println("                                                ");
        System.out.println("                                                ");
        System.out.println("                                                ");
    }

    public static void printUserLost() {
        System.out.println("Busted!");
        System.out.print("Dealer Wins!\n");
    }

    public static void printDealerLost() {
        System.out.println("Busted!");
        System.out.print("User Wins!\n");
    }

    public static void Menu_1() {
        System.out.println("Welcome!");
        System.out.println("1. New Game");
        System.out.println("2. Exit");
    }

    public static void Menu_2() {
        System.out.println("1. Hit");
        System.out.println("2. Stay");
    }

}
