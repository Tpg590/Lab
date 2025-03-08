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
    private int chip;
    private int kidney;

    public int getKidney() {
        return kidney;
    }

    public void setKidney(int kidney) {
        this.kidney = kidney;
    }

    
    
    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
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
        return String.format("After selling your chips, you have $%d. Thanks for playing!", cash + chip * 10);
    }
}
