package model.entity;

/**
 * @author Théophile Renouf
 * Do you want to be the hero
 */
public class Hero {
    public boolean existing=true;


    public boolean playing = true;

    public boolean isAlive = true;

    public int x;
    public int y;
    public int score=0;


    public String etat = new String("/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/attente.gif");

    /**
     * instantiation of hero position
     * @param x
     * @param y
     */
    public Hero(int x,int y) {
        this.x=y;
        this.y=x;
    }


    /**
     * Define the sprite of waiting
     */
    public void attente() {
        etat = new String("/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/attente.gif");
    }
}
