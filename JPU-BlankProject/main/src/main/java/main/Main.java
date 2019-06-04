package main;

import java.util.concurrent.TimeUnit;

import controller.Controller;

import java.sql.SQLException;

import model.entity.*;
import view.GameFrame;

import static model.BDD.MapLoad.readMap;

/**
 * @author Batiste Lubrano Luvadera,Théophile Renouf,Achille Brossier,Marc-Adrien Pointel
 * One for All and All for One
 */
public class Main {

    /**
     *Execution of the game
     * @param args
     * @throws InterruptedException
     * @throws SQLException
     */
    public static void main(String[] args) throws InterruptedException, SQLException	{
        int maps[][];
        maps=readMap(3);
        long timer=0;
        long timer1=0;
        long timer2=0;
        long nanoTimer=System.nanoTime();


        Hero myHero = new Hero(1,1);


        int nbRock=0;
        Rock[] myRock = new Rock[924];
        for(int y = 0;y<41;y++){
            for(int x = 0;x<21;x++){
                if(maps[x][y]==4) {
                    myRock[nbRock] = new Rock(x,y);
                    nbRock++;
                }
            }
        }

        int nbrDiamands=0;
        Diamand[] myDiamands = new Diamand[924];
        for(int y = 0;y<41;y++){
            for(int x = 0;x<21;x++){
                if(maps[x][y]==3) {
                    myDiamands[nbrDiamands] = new Diamand(x,y);
                    nbrDiamands++;
                }
            }
        }

        int nbrMonster=0;
        Monster[]  myMonster= new Monster[924];
        for (int y=0;y<41;y++){
            for (int x=0;x<21;x++){
                if ((maps[x][y]==6) || (maps[x][y]==7)){
                    myMonster[nbrMonster]= new Monster(x,y);
                    nbrMonster++;
                }
            }
        }


        GameFrame maGameFrame = new GameFrame();		//creation de la fenetre de jeux
        Controller myController = new Controller();

        while ((myHero.playing)) {                            //boucle principale du programme

            TimeUnit.MILLISECONDS.sleep(80);    //delais entre chaque tour de boucle
            maGameFrame.display(maps, myHero);    //display du tableau dans la fenetre
            if (!myHero.isAlive){
                int lose[][] =
                {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,1,1,1,3,1,1,1,1,1,3,3,3,3,3,1,1,3,3,3,3,3,1,1,3,3,3,3,3,1,1,3,3,3,3,3,1,1,1,1,1,1},
                    {1,1,1,1,3,1,1,1,1,1,3,1,1,1,3,1,1,1,1,1,1,3,1,1,3,1,1,1,1,1,1,3,1,1,1,3,1,1,1,1,1,1},
                    {1,1,1,1,3,1,1,1,1,1,3,1,1,1,3,1,1,1,1,1,3,1,1,1,3,1,1,1,1,1,1,3,1,1,1,3,1,1,1,1,1,1},
                    {1,1,1,1,3,1,1,1,1,1,3,1,1,1,3,1,1,1,1,1,3,1,1,1,3,1,1,1,1,1,1,3,1,1,1,3,1,1,1,1,1,1},
                    {1,1,1,1,3,1,1,1,1,1,3,1,1,1,3,1,1,1,1,3,1,1,1,1,3,3,3,3,3,1,1,3,1,1,3,1,1,1,1,1,1,1},
                    {1,1,1,1,3,1,1,1,1,1,3,1,1,1,3,1,1,1,1,3,1,1,1,1,3,1,1,1,1,1,1,3,3,3,1,1,1,1,1,1,1,1},
                    {1,1,1,1,3,1,1,1,1,1,3,1,1,1,3,1,1,1,3,1,1,1,1,1,3,1,1,1,1,1,1,3,1,3,1,1,1,1,1,1,1,1},
                    {1,1,1,1,3,1,1,1,1,1,3,1,1,1,3,1,1,1,3,1,1,1,1,1,3,1,1,1,1,1,1,3,1,1,3,1,1,1,1,1,1,1},
                    {1,1,1,1,3,3,3,3,1,1,3,3,3,3,3,1,1,3,3,3,3,3,1,1,3,3,3,3,3,1,1,3,1,1,1,3,1,1,1,1,1,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};

                maGameFrame.setTitle("You Lose");
                maGameFrame.display(lose,myHero);	//display du tableau dans la fenetre

            }else{

            switch (maGameFrame.keyPressed) {    //controller
                case 'D':
                    myController.dpD(myHero, maps, myController.findDiamand(myDiamands, nbrDiamands, myHero.x + 1, myHero.y));

                    break;
                case 'G':
                    myController.dpG(myHero, maps, myController.findDiamand(myDiamands, nbrDiamands, myHero.x - 1, myHero.y));
                    break;
                case 'H':
                    myController.dpH(myHero, maps, myController.findDiamand(myDiamands, nbrDiamands, myHero.x, myHero.y - 1));
                    break;
                case 'B':
                    myController.dpB(myHero, maps, myController.findDiamand(myDiamands, nbrDiamands, myHero.x, myHero.y + 1));
                    break;
                case 'A':
                    myHero.attente();
                    break;
            }

            for (int n = 0; n < nbRock; n++) {
                    if (myRock[n].existing) {
                        myController.fall(maps, myRock[n],myHero,myDiamands[n]);
                    }

            }

            for (int n = 0; n < nbrDiamands; n++) {
                    if (myDiamands[n].existing) {
                        myController.fall(maps, myDiamands[n]);
                    }

            }
            for (int n = 0; n < nbrMonster; n++) {
                    if (myMonster[n].existing) {
                        myController.moving(maps, myMonster[n],myHero);

                    }


            }

            maGameFrame.setTitle("SCORE: " + myHero.score);


        }}
        int victoire[][] =
                       {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,1,1,1,3,1,1,1,3,1,3,1,1,3,3,1,1,3,3,3,1,1,3,3,1,1,3,1,3,3,3,1,1,3,3,3,1,1,1,1,1,1},
                        {1,1,1,1,3,1,1,1,3,1,3,1,3,1,1,3,1,1,3,1,1,3,1,1,3,1,3,1,3,1,1,3,1,3,1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,3,1,3,1,1,3,1,3,1,1,1,1,1,3,1,1,3,1,1,3,1,3,1,3,3,3,1,1,3,3,3,1,1,1,1,1,1},
                        {1,1,1,1,1,3,1,3,1,1,3,1,3,1,1,3,1,1,3,1,1,3,1,1,3,1,3,1,3,1,3,1,1,3,1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,3,1,1,1,3,1,1,3,3,1,1,1,3,1,1,1,3,3,1,1,3,1,3,1,1,3,1,3,3,3,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};

            maGameFrame.setTitle("VICTOIRE!!!!!!");
                    maGameFrame.display(victoire,myHero);	//display du tableau dans la fenetre



        }


    }



