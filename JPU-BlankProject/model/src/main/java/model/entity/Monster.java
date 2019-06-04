package model.entity;

/**
 * @author Théophile Renouf
 * Monster Killer
 */

public class Monster {

    public char sensDp ='B';
    public boolean existing=true;
    public int x;
    public int y;

    public boolean moving;

    /**
     * instantiation the position of Monster
     * @param x
     * @param y
     */

    public Monster(int x,int y) {
        this.x=y;
        this.y=x;
    }
}
