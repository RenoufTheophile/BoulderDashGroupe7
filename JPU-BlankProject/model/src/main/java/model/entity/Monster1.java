package model.entity;

import contract.Entity.IMonster;
import contract.Entity.IObject;

/**
 * @author Théophile Renouf
 * Monster Killer
 */

public class Monster1 implements IObject , IMonster {

    public char sensDp ='B';
    public boolean existing=true;
    public int x;
    public int y;

    /**
     * instantiation the position of Monster
     * @param x
     * @param y
     */

    public Monster1(int x,int y) {
        this.x=y;
        this.y=x;
    }


    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }


    @Override
    public boolean getExisting() {
        return existing;
    }

    @Override
    public char getSensDp() {
        return sensDp;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void setExisting(boolean existing) {
        this.existing=existing;
    }

    @Override
    public void setSensDp(char sensDp) {
        this.sensDp=sensDp;
    }
}
