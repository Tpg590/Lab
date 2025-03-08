/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191249_v05;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import jdk.nashorn.internal.ir.ContinueNode;

/**
 *
 * @author trilt
 */
public class Casino {

    private String choice;
    private String number;
    private int k;
    private int cash;
    private int chip;
    private int change;
    private boolean loop = true;
    private boolean miniLoop = true;
    private Scanner sc = new Scanner(System.in);
    private Player player = new Player();
    private Random rand = new Random();

    public void menu() {
        System.out.println("Welcome to the Casino. Here are your choice:");
        System.out.println("1) Buy chips");
        System.out.println("2) Sell chips");
        System.out.println("3) Play Craps");
        System.out.println("4) Play Arup's Game of Dice");
        System.out.println("5) Status Report");
        System.out.println("6) Quit");
    }

    public void choiceAction() {
        cash = 1000;
        player.setCash(cash);
        while (loop) {
            menu();
            choice = sc.nextLine().trim();

            if (choice.isEmpty()) {
                System.out.println("Choice can't be empty. please Enter again.");
                continue;
            } else if (checkInput(choice, "Choice can be only enter by number 1-6.", "[1-6]")) {
                continue;
            } else {
                switch (choice) {
                    case "1":

                        buyChip();
                        break;
                    case "2":

                        sellChips();
                        break;
                    case "3":
                        playCraps();
                        break;
                    case "4":
                        playArup();
                        break;
                    case "5":
                        System.out.println(player.getReport());
                        break;
                    case "6":
                        System.out.println(player.getQuit());
                        loop = false;
                        break;
                }

            }
        }
    }

    public boolean checkInput(String input, String msg, String keyWord) {

        try {

            // Checking if there is a special character in the input string.
            if (!input.matches(keyWord)) {

                // If there is a special character in the input string then throw a exception.
                throw new Exception(msg);
            }

            // Return false if the input does not contain any special character.
            return false;
        } catch (Exception e) {

            // Print out the error.
            System.out.println(e.getMessage());

            // Return true if the input contain a special character.
            return true;
        }
    }

    public void buyChip() {
        miniLoop = true;
        if (cash < 11) {
            System.out.println("You have not enough money to spend for chip.");
            return;
        }
        while (miniLoop) {

            System.out.println("How much cash do you want to spend for chips?");
            number = sc.nextLine().trim();
            if (number.isEmpty()) {
                System.out.println("Sorry, can't be empty.");
                continue;
            }
            if (number.length() > 5) {
                System.out.println("Sorry, max number you can spend once times are 99999");
                continue;
            }
            if (checkInput(number, "Sorry, can't be enter special character", "[0-9a-zA-Z ]+")) {
                continue;
            }
            if (checkInput(number, "Sorry, can't be enter word", "[0-9 ]+")) {
                continue;
            }

            if (checkInput(number, "Sorry, can't be enter space", "[0-9]+")) {
                continue;
            }
            if (Integer.parseInt(number) < 11) {
                System.out.println("Sorry, Lowest option you can spend are 11");
                continue;
            }
            if (cash < Integer.parseInt(number) || (cash - Integer.parseInt(number)) < 10) {
                System.out.println("Sorry, you do not have that much money. No chips bought.");
                continue;
            }

            chip = Integer.parseInt(number) / 11;
            change = Integer.parseInt(number) % 11;
            cash -= Integer.parseInt(number) + change;
            player.setChip(chip);
            player.setCash(cash);
            miniLoop = false;

        }
    }

    public void sellChips() {
        miniLoop = true;
        if (player.getChip() < 1) {
            System.out.println("You have no chip to sell.");
            return;
        }

        while (miniLoop) {

            System.out.println("How many chips do you want to sell?");
            number = sc.nextLine().trim();

            if (number.isEmpty()) {
                System.out.println("Sorry, can't be empty.");
                continue;
            }
            if (number.length() > 5) {
                System.out.println("Sorry, max chips you can sold once times are 99999");
                continue;
            }

            if (checkInput(number, "Sorry, can't be enter special character", "[0-9a-zA-Z ]+")) {
                continue;
            }
            if (checkInput(number, "Sorry, can't be enter word", "[0-9 ]+")) {
                continue;
            }

            if (checkInput(number, "Sorry, can't be enter space", "[0-9]+")) {
                continue;
            }

            if (Integer.parseInt(number) < 1) {
                System.out.println("Sorry, Lowest option you can sell are 1");
                continue;
            }
            if (player.getChip() < Integer.parseInt(number)) {
                System.out.println("Sorry, you do not have that much chip. No chips sold.");
                continue;
            }

            cash += Integer.parseInt(number) * 10;
            chip = chip - Integer.parseInt(number);
            player.setChip(chip);
            player.setCash(cash);
            miniLoop = false;

        }
    }

    public void playCraps() {
        miniLoop = true;
        if (player.getChip() < 1) {
            System.out.println("You have no chip to bet.");
            return;
        }

        while (miniLoop) {

            System.out.println("How many chips would you like to bet?");
            number = sc.nextLine().trim();
            if (number.isEmpty()) {
                System.out.println("Sorry, can't be empty.");
                continue;
            }
            if (number.length() > 5) {
                System.out.println("Sorry, max chips you can bet once times are 99999");
                continue;
            }

            if (checkInput(number, "Sorry, can't be enter special character", "[0-9a-zA-Z ]+")) {
                continue;
            }
            if (checkInput(number, "Sorry, can't be enter word", "[0-9 ]+")) {
                continue;
            }

            if (checkInput(number, "Sorry, can't be enter space", "[0-9]+")) {
                continue;
            }

            if (Integer.parseInt(number) < 1) {
                System.out.println("Sorry, Lowest option you can bet are 1");
                continue;
            }
            if (Integer.parseInt(number) > player.getChip()) {
                System.out.println("Sorry, you do not have that many chips to bet. No game played");
                continue;
            }
            if (Integer.parseInt(number) < 1) {
                System.out.println("Sorry, you can't bet lower than 1.");
                continue;
            }

            chip -= Integer.parseInt(number);
            player.setChip(chip);
            while (miniLoop) {
                {
                    System.out.println("Press 'r' and hit enter for your first roll.");
                    choice = sc.nextLine().trim().toLowerCase();
                    if (choice.isEmpty()) {
                        System.out.println("Sorry, can't be empty.");
                        continue;
                    }

                    if (checkInput(choice, "Sorry, can't be enter special character", "[0-9a-zA-Z ]+")) {
                        continue;
                    }
                    if (checkInput(choice, "Sorry, can't be enter number", "[a-zA-Z ]+")) {
                        continue;
                    }

                    if (checkInput(choice, "Sorry, can't be enter space", "[a-zA-Z]+")) {
                        continue;
                    }

                    if (checkInput(choice, "Please enter r", "[r]")) {
                        continue;
                    }
                    int randNumber1 = rand.nextInt(6) + 1;

                    int randNumber2 = rand.nextInt(6) + 1;

                    int randNumber = randNumber1 + randNumber2;

                    System.out.println(randNumber);
                    if (randNumber == 7 || randNumber == 11) {
                        System.out.println("You win!");
                        chip += Integer.parseInt(number) * 2;
                        player.setChip(chip);
                        miniLoop = false;
                        continue;
                    }
                    if (randNumber == 2 || randNumber == 3 || randNumber == 12) {
                        System.out.println("Sorry, you have lost.");
                        miniLoop = false;
                        continue;
                    }
                    k = randNumber;
                    while (miniLoop) {
                        System.out.println("Press 'r' and hit enter for your first roll.");
                        choice = sc.nextLine().trim().toLowerCase();
                        if (choice.isEmpty()) {
                            System.out.println("Sorry, can't be empty.");
                            continue;
                        }

                        if (checkInput(choice, "Sorry, can't be enter special character", "[0-9a-zA-Z ]+")) {
                            continue;
                        }
                        if (checkInput(choice, "Sorry, can't be enter number", "[a-zA-Z ]+")) {
                            continue;
                        }

                        if (checkInput(choice, "Sorry, can't be enter space", "[a-zA-Z]+")) {
                            continue;
                        }

                        if (checkInput(choice, "Please enter r", "[r]")) {
                            continue;
                        }

                        randNumber1 = rand.nextInt(6) + 1;

                        randNumber2 = rand.nextInt(6) + 1;

                        randNumber = randNumber1 + randNumber2;
                        System.out.println(randNumber);
                        if (randNumber == k) {
                            System.out.println("You win!");
                            chip += Integer.parseInt(number) * 2;
                            player.setChip(chip);
                            miniLoop = false;
                            continue;
                        }
                        if (randNumber == 7) {
                            System.out.println("Sorry, you have lost.");
                            miniLoop = false;
                            continue;

                        }

                    }
                }

            }
        }
    }

    public void playArup() {
        miniLoop = true;
        if (player.getChip() < 1) {
            System.out.println("You have no chip to bet.");
            return;
        }

        while (miniLoop) {

            System.out.println("How many chips would you like to bet?");
            number = sc.nextLine().trim();
            if (number.isEmpty()) {
                System.out.println("Sorry, can't be empty.");
                continue;
            }

            if (number.length() > 5) {
                System.out.println("Sorry, max chips you can bet once times are 99999");
                continue;
            }

            if (checkInput(number, "Sorry, can't be enter special character", "[0-9a-zA-Z ]+")) {
                continue;
            }
            if (checkInput(number, "Sorry, can't be enter word", "[0-9 ]+")) {
                continue;
            }

            if (checkInput(number, "Sorry, can't be enter space", "[0-9]+")) {
                continue;
            }

            if (Integer.parseInt(number) < 1) {
                System.out.println("Sorry, Lowest option you can bet are 1");
                continue;
            }
            if (Integer.parseInt(number) > player.getChip()) {
                System.out.println("Sorry, you do not have that many chips to bet. No game played");
                continue;
            }
            if (Integer.parseInt(number) < 1) {
                System.out.println("Sorry, you can't bet lower than 1.");
                continue;
            }

            chip -= Integer.parseInt(number);
            player.setChip(chip);
            while (miniLoop) {
                {
                    System.out.println("Press 'r' and hit enter for your first roll.");
                    choice = sc.nextLine().trim().toLowerCase();
                    if (choice.isEmpty()) {
                        System.out.println("Sorry, can't be empty.");
                        continue;
                    }

                    if (checkInput(choice, "Sorry, can't be enter special character", "[0-9a-zA-Z ]+")) {
                        continue;
                    }
                    if (checkInput(choice, "Sorry, can't be enter number", "[a-zA-Z ]+")) {
                        continue;
                    }

                    if (checkInput(choice, "Sorry, can't be enter space", "[a-zA-Z]+")) {
                        continue;
                    }

                    if (checkInput(choice, "Please enter r", "[r]")) {
                        continue;
                    }
                    int randNumber1 = rand.nextInt(6) + 1;

                    int randNumber2 = rand.nextInt(6) + 1;

                    int randNumber = randNumber1 + randNumber2;

                    System.out.println(randNumber);
                    if (randNumber == 12 || randNumber == 11) {
                        System.out.println("You win!");
                        chip += Integer.parseInt(number) * 2;
                        player.setChip(chip);
                        miniLoop = false;
                        continue;
                    }
                    if (randNumber == 2) {
                        System.out.println("Sorry, you have lost.");
                        miniLoop = false;
                        continue;
                    }
                    k = randNumber;
                    while (miniLoop) {
                        System.out.println("Press 'r' and hit enter for your first roll.");
                        choice = sc.nextLine().trim().toLowerCase();
                        if (choice.isEmpty()) {
                            System.out.println("Sorry, can't be empty.");
                            continue;
                        }

                        if (checkInput(choice, "Sorry, can't be enter special character", "[0-9a-zA-Z ]+")) {
                            continue;
                        }
                        if (checkInput(choice, "Sorry, can't be enter number", "[a-zA-Z ]+")) {
                            continue;
                        }

                        if (checkInput(choice, "Sorry, can't be enter space", "[a-zA-Z]+")) {
                            continue;
                        }

                        if (checkInput(choice, "Please enter r", "[r]")) {
                            continue;
                        }

                        randNumber1 = rand.nextInt(6) + 1;

                        randNumber2 = rand.nextInt(6) + 1;

                        randNumber = randNumber1 + randNumber2;
                        System.out.println(randNumber);
                        if (randNumber > k) {
                            System.out.println("You win!");
                            chip += Integer.parseInt(number) * 2;
                            player.setChip(chip);
                            miniLoop = false;
                            continue;
                        }
                        if (randNumber <= k) {
                            System.out.println("Sorry, you have lost.");
                            miniLoop = false;
                            continue;

                        }

                    }
                }

            }
        }
    }
}
