package model.entity;
/**
 * @author @author Marc-Adrien Pointel
 * Rock and Roll and Michael Bay
 */

public class Rock {

    public boolean existing=true;
    public int x;
    public int y;


    public boolean falling;//*******************************************explosion

    /**
     * Position of Rock
     * @param x
     * @param y
     */
    public Rock(int x, int y) {
        this.x=y;
        this.y=x;
    }


}
