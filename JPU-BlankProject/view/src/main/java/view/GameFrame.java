package view;

import model.BDD.MapLoad;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.entity.Hero;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;

/**
 * @author Baptiste Lubrano Lavadera
 * This is beautiful
 */
public class GameFrame extends JFrame implements  KeyListener {

    JLabel[] tableau ;
    public char keyPressed;

    /**
     *Constructor of the GameFrame
     */
    public GameFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("BOULDER DASH");
        this.setSize(700, 400);
        this.setLocationRelativeTo(null);
        addKeyListener(this);
    }

    /**
     *display of the map
     * @param map
     * @param myHero
     */
    public void display(int[][] map, Hero myHero){
        this.getContentPane().removeAll();
        this.setLayout(new GridLayout(22, 42,0,0));
        int n=-1;
        tableau = new JLabel[924];
        for(int y=0; y<=21; y++) {
            for(int x=-0; x<=41; x++) {
                n++;
                switch(map[y][x]) {
                    case 1:
                        tableau[n] = new JLabel(new ImageIcon("/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/terre.png"));
                        break;
                    case 0:
                        tableau[n] = new JLabel(new ImageIcon("/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/murs.png"));
                        break;
                    case 2:
                        tableau[n] = new JLabel(new ImageIcon("/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/vide.png"));
                        break;
                    case 3:
                        tableau[n] = new JLabel(new ImageIcon("/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/diamand.gif"));
                        break;
                    case 4:
                        tableau[n] = new JLabel(new ImageIcon("/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/pierre.gif"));
                        break;
                    case 5:
                        tableau[n] = new JLabel(new ImageIcon(myHero.etat));
                        break;
                    case 6:
                        tableau[n] = new JLabel(new ImageIcon("/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/monstre2.gif"));
                        break;
                    case 7:
                        tableau[n] = new JLabel(new ImageIcon("/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/monstre1.gif"));
                        break;
                    case 8:
                        tableau[n] = new JLabel(new ImageIcon("/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/explosion.gif"));
                        map[y][x]=2;
                        break;
                    case 9:
                        tableau[n] = new JLabel(new ImageIcon("/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/porte.png"));
                        break;
                }
                this.getContentPane().add(tableau[n]);
            }
        }
        this.setVisible(true);//Affiche la fenetre
    }

    /**
     *Defind the keyevent
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {}

    /**
     *Detection of pressed fingerboard
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.keyPressed='D';
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.keyPressed='G';
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.keyPressed='H';
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.keyPressed='B';
        }else {
            this.keyPressed='A';
        }
    }

    /**
     *Detection of released fingerboard
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.keyPressed='A';
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.keyPressed='A';
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.keyPressed='A';
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.keyPressed='A';
        }
    }
}