package jk.uz.pdp;

import jk.uz.pdp.domain.exception.DataNotFoundException;
import jk.uz.pdp.domain.exception.EPAMPaymentSecurityException;
import jk.uz.pdp.domain.exception.EPAMPaymentValidationException;
import jk.uz.pdp.domain.model.Card;
import jk.uz.pdp.domain.model.User;
import jk.uz.pdp.domain.service.CardService;
import jk.uz.pdp.domain.service.UserService;

import java.util.*;

public class Main {
    static Scanner scanInt = new Scanner(System.in);
    static Scanner scanStr = new Scanner(System.in);

    static UserService userService = new UserService();
    static CardService cardService = new CardService();

    public static void main(String[] args) {
        int cmd = -1;

        while(cmd != 0) {
            System.out.println("1. Login\t2. Register\t0. Exit");
            try {
                cmd = scanInt.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please choose only from menu\n");
                scanInt.nextLine();
            }

            switch (cmd) {
                case 1 -> {
                    User currentUser = login();
                }
                case 2 -> {
                    register();
                }
                case -1, 0 -> {

                }
                default -> {
                    System.out.println("Wrong input");
                }
            }
        }


    }

    public static User login() {
        System.out.print("Enter phone number: ");
        String phoneNumber = scanStr.nextLine();

        System.out.print("Enter password: ");
        String password = scanStr.nextLine();

        try {
            return userService.signIn(phoneNumber, password);
        } catch (DataNotFoundException | EPAMPaymentSecurityException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void register() {
        System.out.print("Enter first name: ");
        String firstName = scanStr.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanStr.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanStr.nextLine();

        System.out.print("Enter password: ");
        String password = scanStr.nextLine();

        User user = new User(firstName, lastName, phoneNumber, password);

        try {
            userService.register(user);
        } catch (EPAMPaymentValidationException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void userOperations(User currentUser) {
        int cmd = -1;

        while(cmd != 0) {
            System.out.println("1. Card\t2. Profile\t3. Wallet\t0. Exit");
            try {
                cmd = scanInt.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please choose only from menu\n");
                scanInt.nextLine();
            }

            switch (cmd) {
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {

                }
                case -1, 0 -> {

                }
                default -> {
                    System.out.println("Wrong input");
                }
            }
        }
    }

    public static void card(User currentUser) {
        int cmd = -1;

        // Peer to peer
        while(cmd != 0) {
            System.out.println("1. Add\t2. Show\t3. Edit\t4. Delete\t5. P2P\t0. Exit");
            try {
                cmd = scanInt.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please choose only from menu\n");
                scanInt.nextLine();
            }

            switch (cmd) {
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {

                }
                case 5 -> {

                }
                case -1, 0 -> {

                }
                default -> {
                    System.out.println("Wrong input");
                }
            }
        }
    }

    public static List<Card> showCards(UUID userId) {
        List<Card> cards = new ArrayList<>();
        try {
            cards = cardService.getCardsByOwnerId(userId);
        } catch (DataNotFoundException e) {
            System.out.println("User has no cards");
            return cards;
        }

        int i = 1;
        for (Card card:cards) {
            System.out.println(i++ + ". " + card.toString());
        }

        return cards;
    }

    public static void transferP2P(UUID userId) {
        List<Card> cards = showCards(userId);

        if(cards.isEmpty()) {
            return;
        }



    }

}