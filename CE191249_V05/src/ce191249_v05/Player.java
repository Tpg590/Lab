/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce191249_v05;

/**
 *
 * @author trilt
 */
public class Player {
    private int cash;
    private int cost;
    private int bet;
    private int chip;

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getCost() {
        return cost = cash - 11 * chip;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public int getChip() {
        return chip;
    }

    public void setChip(int chip) {
        this.chip = chip;
    }

    
    public String getReport(){
     return String.format("You currently have $%d left and %d chips.", cash, chip);
    }
    
    
    public String getQuit(){
        return String.format("After selling your chips, you have $%d. Thanks for playing!", cash);
    }
}
