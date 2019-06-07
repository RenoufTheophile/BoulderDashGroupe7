package model.entity;

import contract.Entity.IObject;
import contract.Entity.IRock;

/**
 * @author @author Marc-Adrien Pointel
 * Rock and Roll and Michael Bay
 */

public class Rock implements IRock, IObject {

    private boolean existing=true;
    private int x;
    private int y;

    private boolean falling;

    /**
     * Position of Rock
     * @param x
     * @param y
     */
    public Rock(int y, int x) {
        this.x=x;
        this.y=y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getExisting() {
        return existing;
    }

    public void setX(int x) {
        this.x= x;
    }

    public void setY(int y) {
        this.y= y;
    }

    public void setExisting(boolean existing)  {
        this.existing= existing;
    }

    public boolean getFalling() {
        return falling;
    }

    public void setFalling(boolean falling) {
         this.falling=falling;
    }
}
