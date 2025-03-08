/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191249_v05;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author trilt
 */
public class Casino {

    private String choice;
    private String number;
    private int body;
    private static final int earn = 1000;
    private int allIn;
    private int k;
    private int cost;
    private int cash;
    private int chip;
    private int change;
    private boolean loop = true;
    private boolean miniLoop = true;
    private Scanner sc = new Scanner(System.in);
    private Player player = new Player();
    private Random rand = new Random();

    public void menu() {
        System.out.println("-------------Main Menu-------------");
        System.out.println("Welcome to the Casino. Here are your choice:");
        System.out.println("1) Buy chips");
        System.out.println("2) Sell chips");
        System.out.println("3) Play Craps");
        System.out.println("4) Play Arup's Game of Dice");
        System.out.println("5) Status Report");
        System.out.println("6) Quit");

    }

    public void choiceAction() {
        player.setKidney(2);
        cash = 1000;
        player.setCash(cash);
        loop = true;
        while (loop) {
            menu();
            choice = sc.nextLine().trim();

            if (choice.isEmpty()) {
                System.out.println("Choice can't be empty. please Enter again.");
                continue;
            } else if (checkInput(choice, "Choice can be only enter by number 1-6.", "[1-6]")) {
                continue;
            }
            switch (choice) {
                case "1":

                    selectTypeBuy();
                    loop = true;
                    break;
                case "2":

                    selectTypeSell();
                    loop = true;
                    break;
                case "3":
                    selectAllInCrap();
                    loop = true;
                    checkMoney();
                    break;
                case "4":
                    selectAllInArup();
                    loop = true;
                    checkMoney();
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

    public void selectTypeBuy() {
        if (cash < 11) {
            System.out.println("You have not enough money to spend for chip.");
            return;
        }
        while (loop) {

            System.out.println("-----Menu Buy-----");
            System.out.println("1) Buy each number");
            System.out.println("2) Buy All");
            System.out.println("3) Quit");
            choice = sc.nextLine().trim();

            if (choice.isEmpty()) {
                System.out.println("Choice can't be empty. please Enter again.");
                continue;
            } else if (checkInput(choice, "Choice can be only enter by number 1-3.", "[1-3]")) {
                continue;
            }

            switch (choice) {
                case "1":

                    buyChip();
                    return;

                case "2":

                    buyAllChip();
                    return;
                case "3":
                    System.out.println("Out of the purchase hall completed.");
                    loop = false;
                    break;

            }
        }
    }

    public void buyAllChip() {
        System.out.println("-----------------------------------");
        cost = cash;

        do {
            chip = cost / 11;
            change = cost % 11;
            cost -= change;
            cash = player.getCash() - cash + change;
            player.setChip(chip);
            player.setCash(cash);
        } while (player.getCash() > 10);
        System.out.printf("You used all the money you have to buy the chip. -$%d the money, the number of chips you have now is %d\n", cost, player.getChip());
    }

    public void buyChip() {
        System.out.println("-----------------------------------");
        while (miniLoop) {

            System.out.println("How much cash do you want to spend for chips?");
            number = sc.nextLine().trim();
            if (number.isEmpty()) {
                System.out.println("Sorry, can't be empty.");
                continue;
            }
            if (number.length() > 5) {
                System.out.println("Sorry, max number length you can enter are 5");
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
            cash = player.getCash() - Integer.parseInt(number) + change;
            player.setChip(chip);
            player.setCash(cash);
            miniLoop = false;

        }
    }

    public void selectTypeSell() {
        if (player.getChip() < 1) {
            System.out.println("You have no chip to sell.");
            return;
        }

        while (loop) {

            System.out.println("-----Menu Buy-----");
            System.out.println("1) Sell each number");
            System.out.println("2) Sold All");
            System.out.println("3) Quit");
            choice = sc.nextLine().trim();

            if (choice.isEmpty()) {
                System.out.println("Choice can't be empty. please Enter again.");
                continue;
            } else if (checkInput(choice, "Choice can be only enter by number 1-3.", "[1-3]")) {
                continue;
            }

            switch (choice) {
                case "1":

                    sellChips();
                    return;

                case "2":

                    sellAllChips();
                    return;
                case "3":
                    System.out.println("Out of the sold hall completed.");
                    loop = false;
                    break;

            }
        }
    }

    public void sellAllChips() {
        System.out.println("-----------------------------------");
        cash += player.getChip() * 10;
        chip = chip - player.getChip();
        player.setChip(chip);
        player.setCash(cash);
        System.out.printf("After selling all your chips, you have $%d\n", player.getCash());
    }

    public void sellChips() {
        System.out.println("-----------------------------------");
        miniLoop = true;

        while (miniLoop) {
            System.out.println("How many chips do you want to sell?");
            number = sc.nextLine().trim();

            if (number.isEmpty()) {
                System.out.println("Sorry, can't be empty.");
                continue;
            }
            if (number.length() > 5) {
                System.out.println("Sorry, max number length you can enter are 5");
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

    public void selectAllInCrap() {
        if (player.getChip() < 1) {
            System.out.println("You have no chip to bet.");
            return;
        }

        while (loop) {

            System.out.println("-----Play Craps-----");
            System.out.println("1) Bet each number");
            System.out.println("2) All In");
            System.out.println("3) Quit");
            choice = sc.nextLine().trim();

            if (choice.isEmpty()) {
                System.out.println("Choice can't be empty. please Enter again.");
                continue;
            } else if (checkInput(choice, "Choice can be only enter by number 1-3.", "[1-3]")) {
                continue;
            }

            switch (choice) {
                case "1":

                    playCraps();
                    return;

                case "2":

                    allInCrap();
                    return;
                case "3":
                    System.out.println("See you soon.");
                    loop = false;
                    break;

            }
        }
    }

    public void playCraps() {
        System.out.println("-----------------------------------");
        miniLoop = true;

        while (miniLoop) {
            System.out.println("How many chips would you like to bet?");
            number = sc.nextLine().trim();
            if (number.isEmpty()) {
                System.out.println("Sorry, can't be empty.");
                continue;
            }
            if (number.length() > 5) {
                System.out.println("Sorry, max number length you can enter are 5");
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

    public void selectAllInArup() {
        if (player.getChip() < 1) {
            System.out.println("You have no chip to bet.");
            return;
        }

        while (loop) {

            System.out.println("-----Play Arup's Game of Dice-----");
            System.out.println("1) Bet each number");
            System.out.println("2) All In");
            System.out.println("3) Quit");
            choice = sc.nextLine().trim();

            if (choice.isEmpty()) {
                System.out.println("Choice can't be empty. please Enter again.");
                continue;
            } else if (checkInput(choice, "Choice can be only enter by number 1-3.", "[1-3]")) {
                continue;
            }

            switch (choice) {
                case "1":

                    playArup();
                    return;

                case "2":

                    playAllInArup();
                    return;
                case "3":
                    System.out.println("See you soon.");
                    loop = false;
                    break;

            }
        }
    }

    public void playAllInArup() {
        miniLoop = true;
        allIn = player.getChip();
        chip -= player.getChip();
        player.setChip(chip);
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
            int randNumber1 = rand.nextInt(6) + 1;

            int randNumber2 = rand.nextInt(6) + 1;

            int randNumber = randNumber1 + randNumber2;

            System.out.println(randNumber);
            if (randNumber == 12 || randNumber == 11) {
                System.out.println("You win!");
                chip += allIn * 2;
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
                    chip += allIn * 2;
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

    public void playArup() {
        System.out.println("-----------------------------------");
        miniLoop = true;
        while (miniLoop) {
            System.out.println("How many chips would you like to bet?");
            number = sc.nextLine().trim();
            if (number.isEmpty()) {
                System.out.println("Sorry, can't be empty.");
                continue;
            }

            if (number.length() > 5) {
                System.out.println("Sorry, max number length you can enter are 5");
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

    public void allInCrap() {
        miniLoop = true;
        System.out.println("-----------------------------------");
            allIn = player.getChip();
            chip -= player.getChip();
            player.setChip(chip);
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
                int randNumber1 = rand.nextInt(6) + 1;

                int randNumber2 = rand.nextInt(6) + 1;

                int randNumber = randNumber1 + randNumber2;

                System.out.println(randNumber);
                if (randNumber == 7 || randNumber == 11) {
                    System.out.println("You win!");
                    chip += allIn * 2;
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
                        chip += allIn * 2;
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

    public void soldKidney() {
        body = player.getKidney() - 1;
        player.setKidney(body);
        cash = player.getCash() + earn;
        player.setCash(cash);

        System.out.printf("You have beenn sold your kidney. Cash +$%d", earn);
    }

    public void checkMoney() {
        loop = true;
        if (player.getCash() < 11 && player.getChip() < 1) {
            if (player.getKidney() < 2) {
                System.out.println("You have run out of money.");
                System.out.println("See you again.");
                loop = false;
                return;
            }

            while (loop) {

                System.out.println("You have run out of money.");
                System.out.println("Now you have 2 choice:");
                System.out.println("1) Exit.");
                System.out.println("2) Sell ​​kidney to continue playing...");
                choice = sc.nextLine().trim();

                if (choice.isEmpty()) {
                    System.out.println("Choice can't be empty. please Enter again.");
                    continue;
                } else if (checkInput(choice, "Choice can be only enter by number 1-3.", "[1-3]")) {
                    continue;
                }

                switch (choice) {
                    case "1":

                        System.out.println("See you again.");
                        loop = false;
                        break;
                    case "2":

                        soldKidney();
                        return;
                }
            }
        }
    }
}
