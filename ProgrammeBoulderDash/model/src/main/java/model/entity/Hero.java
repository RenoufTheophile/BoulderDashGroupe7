package model.entity;

import contract.Entity.IHero;
import contract.Entity.IObject;

/**
 * @author Théophile Renouf
 * Do you want to be the hero
 */

public class Hero implements IHero, IObject {

    private boolean existing=true;
    private boolean playing = true;
    private boolean isAlive = true;

    private int x;
    private int y;
    private int score=0;

    private String etat;

    /**
     * instantiation of hero position
     * @param x
     * @param y
     */
    
    public Hero(int y,int x) {
        this.x=x;
        this.y=y;
        etat =("/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/attente.gif");
    }


    /**
     * Define the sprite of waiting
     */
    @Override
    public void attente() {
        etat =("/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/attente.gif");
    }

    @Override
    public String getEtat() {
        return etat; }

    @Override
    public boolean getPlaying() {
        return playing; }

    @Override
    public boolean getIsAlive() {
        return isAlive;
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
    public int getScore() {
        return score;
    }

    @Override
    public boolean getExisting() {
        return existing;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void setPlaying(boolean playing) {
        this.playing= playing;
    }

    @Override
    public void setIsAlive(boolean isAlive) {
        this.isAlive= isAlive;
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
    public void setEtat(String etat) {
        this.etat=etat;
    }
}
