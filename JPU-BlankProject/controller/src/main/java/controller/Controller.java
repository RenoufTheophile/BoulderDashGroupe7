package controller;

import model.entity.Diamand;
import model.entity.Hero;
import model.entity.Monster1;
import model.entity.Rock;


/**
 * @author Batiste Lubrano Lavadera,Théophile Renouf,Achille Brossier,Marc-Adrien Pointel
 * I'm a WatchClass
 */

public class Controller {

	public Controller() {}

	long timer=0;
	long nanoTimer=System.nanoTime();

	/**
	 *Method for search the Rocks
	 * @param myRock
	 * @param nbrRock
	 * @param x
	 * @param y
	 * @return
	 */
	public Rock findRock(Rock[] myRock, int nbrRock, int x, int y) {
		int n=0;
		while (n<nbrRock) {
			if((myRock[n].getX() == x) && (myRock[n].getY() == y)) {
				return myRock[n];
			}
			n++;

		}
		return null;
	}

	/**
	 *Method for search the Diamonds
	 * @param myDiamands
	 * @param nbrDiamands
	 * @param x
	 * @param y
	 * @return
	 */
	public Diamand findDiamand(Diamand[] myDiamands, int nbrDiamands, int x, int y) {
		int n=0;
		while (n<nbrDiamands) {
			if((myDiamands[n].getX() == x) && (myDiamands[n].getY() == y)) {
				return myDiamands[n];
			}
			n++;

		}
		return null;
	}

	/**
	 * Method for search the monsters
	 * @param myMonster
	 * @param nbrMonstre
	 * @param x
	 * @param y
	 * @return
	 */
	public Monster1 findMonster(Monster1[] myMonster, int nbrMonstre, int x, int y){
		int n=0;
		while (n<nbrMonstre){
			if((myMonster[n].getX()==x) && (myMonster[n].getY()==y)){
				return myMonster[n];
			}
			n++;
		}
		return null;
	}

	/**
	 *Method who describe and applied the behavior of the falling Rocks and roll Rocks
	 * @param maps
	 * @param myRock
	 * @param myHero
	 * @param myDiamand
	 */


	public void fall(int[][] maps, Rock myRock, Hero myHero, Diamand myDiamand)  {

		if(myRock.getExisting()) {
			if(maps[myRock.getY()+1][myRock.getX()]==2) {
				maps[myRock.getY()][myRock.getX()]=2;
				myRock.setY(myRock.getY()+1);
				maps[myRock.getY()][myRock.getX()]=4;
			if(!myRock.getFalling()) {
					myRock.setFalling(true);
			}else if (maps[myRock.getY()+1][myRock.getX()]!=2){
					michaelBay(maps,myRock.getX(),myRock.getY(),myHero,myRock,myDiamand);
				}
			}else if((maps[myRock.getY()][myRock.getX()+1]==2) && (maps[myRock.getY()+1][myRock.getX()+1]==2)){
				maps[myRock.getY()][myRock.getX()]=2;
				myRock.setX(myRock.getX()+1);
				maps[myRock.getY()][myRock.getX()]=4;
			}else if((maps[myRock.getY()][myRock.getX()-1]==2) && (maps[myRock.getY()+1][myRock.getX()-1]==2)){
				maps[myRock.getY()][myRock.getX()]=2;
				myRock.setX(myRock.getX()-1);
				maps[myRock.getY()][myRock.getX()]=4;


			}else if ((maps[myRock.getY()][myRock.getX()+1]==2)&&(maps[myRock.getY()][myRock.getX()]==5)){

				maps[myRock.getY()][myRock.getX()] = 5;
				myRock.setX(myRock.getX()+1);
				maps[myRock.getY()][myRock.getX()] = 4;




			}else if((maps[myRock.getY()][myRock.getX()-1]==2)&&(maps[myRock.getY()][myRock.getX()]==5)) {

				maps[myRock.getY()][myRock.getX()] = 5;
				myRock.setX(myRock.getX()-1);
				maps[myRock.getY()][myRock.getX()] = 4;


			}
		}
	}

	/**
	 *Method who describe and applied the behavior of the falling Diamonds
	 * @param maps
	 * @param myDiamand
	 */


	public void fall(int[][] maps,Diamand myDiamand) {
		if(myDiamand.getExisting()) {
			if(maps[myDiamand.getY()+1][myDiamand.getX()]==2) {
				maps[myDiamand.getY()][myDiamand.getX()]=2;
				myDiamand.setY(myDiamand.getY()+1);
				maps[myDiamand.getY()][myDiamand.getX()]=3;
			}else if((maps[myDiamand.getY()][myDiamand.getX()+1]==2) && (maps[myDiamand.getY()+1][myDiamand.getX()+1]==2)){

				maps[myDiamand.getY()][myDiamand.getX()]=2;
				myDiamand.setX(myDiamand.getX()+1);
				maps[myDiamand.getY()][myDiamand.getX()]=3;
			}else if((maps[myDiamand.getY()][myDiamand.getX()-1]==2) && (maps[myDiamand.getY()+1][myDiamand.getX()-1]==2)){
				maps[myDiamand.getY()][myDiamand.getX()]=2;
				myDiamand.setX(myDiamand.getY()-1);
				maps[myDiamand.getY()][myDiamand.getX()]=3;
			}
		}
	}

	/**
	 *Method who describe and applied the behavior of the Monster move and the the action of killing
	 * @param maps
	 * @param myMonster
	 * @param myHero
	 */
	public void moving(int[][] maps, Monster1 myMonster, Hero myHero){

		if(myMonster.getExisting()) {
			switch(myMonster.getSensDp()){

				case 'H':
					if ((maps[myMonster.getY()][myMonster.getX()+1 ] == 2)||(maps[myMonster.getY()][myMonster.getX()+1]==5))  {
						if (maps[myMonster.getY()][myMonster.getX()+1]==5){
							myHero.setIsAlive(false);

						}
						maps[myMonster.getY()][myMonster.getX()] = 2;
						myMonster.setX(myMonster.getX()+1);
						maps[myMonster.getY()][myMonster.getX()] = 7;
						myMonster.setSensDp('D');
						System.out.println(myMonster.getX());
					} else if ((maps[myMonster.getY()-1][myMonster.getX() ] == 2)||(maps[myMonster.getY()-1][myMonster.getX()]==5)) {
						if (maps[myMonster.getY()-1][myMonster.getX()]==5){
							myHero.setIsAlive(false);


						}
						maps[myMonster.getY()][myMonster.getX()] = 2;
						myMonster.setY(myMonster.getY()-1);
						maps[myMonster.getY()][myMonster.getX()] = 7;
						myMonster.setSensDp('H');
						System.out.println(myMonster.getY());
					} else if ((maps[myMonster.getY()][myMonster.getX() - 1] == 2)||(maps[myMonster.getY()][myMonster.getX()-1]==5))  {
						if (maps[myMonster.getY()][myMonster.getX()-1]==5){
							myHero.setIsAlive(false);


						}
						maps[myMonster.getY()][myMonster.getX()] = 2;
						myMonster.setX(myMonster.getX()-1);
						maps[myMonster.getY()][myMonster.getX()] = 7;
						myMonster.setSensDp('G');
						System.out.println(myMonster.getX());
					}else if ((maps[myMonster.getY()+1][myMonster.getX() ] == 2)||(maps[myMonster.getY()+1][myMonster.getX()]==5)) {
						if (maps[myMonster.getY()+1][myMonster.getX()]==5){
							myHero.setIsAlive(false);


						}
						maps[myMonster.getY()][myMonster.getX()] = 2;
						myMonster.setY(myMonster.getY()+1);
						maps[myMonster.getY()][myMonster.getX()] = 7;
						myMonster.setSensDp('B');
						System.out.println(myMonster.getY());
					}

					break;
				case 'D':

					if ((maps[myMonster.getY()+1][myMonster.getX() ] == 2)||(maps[myMonster.getY()+1][myMonster.getX()]==5))  {
						if (maps[myMonster.getY()+1][myMonster.getX()]==5){
							myHero.setIsAlive(false);


						}
						maps[myMonster.getY()][myMonster.getX()] = 2;
						myMonster.setY(myMonster.getY()+1);
						maps[myMonster.getY()][myMonster.getX()] = 7;
						myMonster.setSensDp('B');
						System.out.println(myMonster.getY());
					} else if ((maps[myMonster.getY()][myMonster.getX() + 1] == 2)||(maps[myMonster.getY()][myMonster.getX()+1]==5))  {
						if (maps[myMonster.getY()][myMonster.getX()+1]==5){
							myHero.setIsAlive(false);

						}
						maps[myMonster.getY()][myMonster.getX()] = 2;
						myMonster.setX(myMonster.getX()+1);
						maps[myMonster.getY()][myMonster.getX()] = 7;
						myMonster.setSensDp('D');
						System.out.println(myMonster.getX());
					} else if ((maps[myMonster.getY()-1][myMonster.getX() ] == 2)||(maps[myMonster.getY()-1][myMonster.getX()]==5))  {
						if (maps[myMonster.getY()-1][myMonster.getX()]==5){
							myHero.setIsAlive(false);

						}
						maps[myMonster.getY()][myMonster.getX()] = 2;
						myMonster.setY(myMonster.getY()-1);
						maps[myMonster.getY()][myMonster.getX()] = 7;
						myMonster.setSensDp('H');
						System.out.println(myMonster.getY());
					} else if ((maps[myMonster.getY()][myMonster.getX() - 1] == 2)||(maps[myMonster.getY()][myMonster.getX()-1]==5)) {
						if (maps[myMonster.getY()][myMonster.getX()-1]==5){
							myHero.setIsAlive(false);

						}

						maps[myMonster.getY()][myMonster.getX()] = 2;
						myMonster.setX(myMonster.getX()-1);
						maps[myMonster.getY()][myMonster.getX()] = 7;
						myMonster.setSensDp('G');
						System.out.println(myMonster.getX());
					}
					break;
				case 'B':
					if ((maps[myMonster.getY()][myMonster.getX() - 1] == 2)||(maps[myMonster.getY()][myMonster.getX()-1]==5)) {
						if (maps[myMonster.getY()][myMonster.getX()-1]==5){
							myHero.setIsAlive(false);


						}
						maps[myMonster.getY()][myMonster.getX()] = 2;
						myMonster.setX(myMonster.getX()-1);
						maps[myMonster.getY()][myMonster.getX()] = 7;
						myMonster.setSensDp('G');
						System.out.println(myMonster.getX());
					}else if ((maps[myMonster.getY() + 1][myMonster.getX()] == 2)||(maps[myMonster.getY()+1][myMonster.getX()]==5)) {
						if (maps[myMonster.getY()+1][myMonster.getX()]==5){
							myHero.setIsAlive(false);


						}
						maps[myMonster.getY()][myMonster.getX()] = 2;
						myMonster.setY(myMonster.getY()+1);
						maps[myMonster.getY()][myMonster.getX()] = 7;
						myMonster.setSensDp('B');
						System.out.println(myMonster.getY());
					} else if ((maps[myMonster.getY()][myMonster.getX() + 1] == 2)||(maps[myMonster.getY()][myMonster.getX()+1]==5)) {
						if (maps[myMonster.getY()][myMonster.getX()+1]==5){
							myHero.setIsAlive(false);


						}
						maps[myMonster.getY()][myMonster.getX()] = 2;
						myMonster.setX(myMonster.getX()+1);
						maps[myMonster.getY()][myMonster.getX()] = 7;
						myMonster.setSensDp('D');
						System.out.println(myMonster.getX());
					} else if ((maps[myMonster.getY() - 1][myMonster.getX()] == 2)||(maps[myMonster.getY()-1][myMonster.getX()]==5)) {
						if (maps[myMonster.getY()-1][myMonster.getX()]==5){
							myHero.setIsAlive(false);


						}
						maps[myMonster.getY()][myMonster.getX()] = 2;
						myMonster.setY(myMonster.getY()-1);
						maps[myMonster.getY()][myMonster.getX()] = 7;
						myMonster.setSensDp('H');
						System.out.println(myMonster.getY());
					}
					break;
				case 'G':
					if ((maps[myMonster.getY()-1][myMonster.getX() ] == 2)||(maps[myMonster.getY()-1][myMonster.getX()]==5))  {
						if (maps[myMonster.getY()-1][myMonster.getX()]==5){
							myHero.setIsAlive(false);


						}
						maps[myMonster.getY()][myMonster.getX()] = 2;
						myMonster.setY(myMonster.getY()-1);
						maps[myMonster.getY()][myMonster.getX()] = 7;
						myMonster.setSensDp('H');
						System.out.println(myMonster.getY());
					} else if ((maps[myMonster.getY()][myMonster.getX() - 1] == 2)||(maps[myMonster.getY()][myMonster.getX()-1]==5))  {
						if (maps[myMonster.getY()][myMonster.getX()-1]==5){
							myHero.setIsAlive(false);


						}
						maps[myMonster.getY()][myMonster.getX()] = 2;
						myMonster.setX(myMonster.getX()-1);
						maps[myMonster.getY()][myMonster.getX()] = 7;
						myMonster.setSensDp('G');
						System.out.println(myMonster.getX());
					}
					else if ((maps[myMonster.getY()+1][myMonster.getX() ] == 2)||(maps[myMonster.getY()+1][myMonster.getX()]==5))  {
						if (maps[myMonster.getY()+1][myMonster.getX()]==5){
							myHero.setIsAlive(false);


						}
						maps[myMonster.getY()][myMonster.getX()] = 2;
						myMonster.setY(myMonster.getY()+1);
						maps[myMonster.getY()][myMonster.getX()] = 7;
						myMonster.setSensDp('B');
						System.out.println(myMonster.getY());
					} else if ((maps[myMonster.getY()][myMonster.getX() +1] == 2)||(maps[myMonster.getY()][myMonster.getX()+1]==5))  {
						if (maps[myMonster.getY()][myMonster.getX()+1]==5){
							myHero.setIsAlive(false);


						}
						maps[myMonster.getY()][myMonster.getX()] = 2;
						myMonster.setX(myMonster.getX()+1);
						maps[myMonster.getY()][myMonster.getX()] = 7;
						myMonster.setSensDp('D');
						System.out.println(myMonster.getX());
					}
					break;





			}
		}
	}



	/**
	 *Method who describe and applied the behavior of the explosion
	 * Sponsoring by Michael Bay
	 * @param maps
	 * @param cx
	 * @param cy
	 * @param myHero
	 * @param myRock
	 * @param myDiamand
	 */
	public void michaelBay(int[][] maps, int cx, int cy, Hero myHero, Rock myRock, Diamand myDiamand)  {
		myRock.setExisting(false);
		for(int y = cy-1;y<=cy+1;y++){
			for(int x = cx-1;x<=cx+1;x++){
				if(  (maps[y][x]==1) ||(maps[y][x]==2)  || (maps[y][x]==4) ) {

					maps[y][x] = 8;


				}else if((maps[y][x]==6)||maps[y][x]==7){
					maps[y][x]=8;
				}
				else if (maps[y][x]==5)	{
					maps[y][x]=8;
					myHero.setIsAlive(false);
				}
			}
		}
	}

	/**
	 *Method who describe and applied the behavior of Up hero move
	 * @param monHero
	 * @param maps
	 * @param myDiamand
	 */

	public void dpH(Hero monHero,int[][] maps,Diamand myDiamand) {

		if ((maps[monHero.getY()-1][monHero.getX()]==1)||(maps[monHero.getY()-1][monHero.getX()]==2)||(maps[monHero.getY()-1][monHero.getX()]==3)) {
			maps[monHero.getY()][monHero.getX()]=2;
			monHero.setY(monHero.getY()-1);
			if(maps[monHero.getY()][monHero.getX()]==3 && myDiamand.getExisting()){
				myDiamand.setExisting(false);
				monHero.setScore(monHero.getScore()+1);
			}
			maps[monHero.getY()][monHero.getX()]=5;
		}else if(maps[monHero.getY()-1][monHero.getX()]==9 && monHero.getScore()>6){
			monHero.setPlaying(false);
			maps[monHero.getY()][monHero.getX()]=2;
			monHero.setY(monHero.getY()-1);
			maps[monHero.getY()][monHero.getX()]=5;
		}
		monHero.setEtat(new String("/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/dpH.gif"));
	}

	/**
	 *Method who describe and applied the behavior of Right hero move
	 * @param myHero
	 * @param maps
	 * @param myDiamand
	 */
	public void dpD(Hero myHero,int[][] maps,Diamand myDiamand) {
		myHero.setEtat(new String("/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites//dpD.gif"));
		if ((maps[myHero.getY()][myHero.getX()+1]==1)||(maps[myHero.getY()][myHero.getX()+1]==2)||(maps[myHero.getY()][myHero.getX()+1]==3)) {
			maps[myHero.getY()][myHero.getX()]=2;
			myHero.setX(myHero.getX()+1);
			if(maps[myHero.getY()][myHero.getX()]==3 && myDiamand.getExisting()){
				myDiamand.setExisting(false);
				myHero.setScore(myHero.getScore()+1);
			}

			maps[myHero.getY()][myHero.getX()]=5;
		}else if(maps[myHero.getY()][myHero.getX()+1]==9 && myHero.getScore()>6){
			myHero.setPlaying(false);
			maps[myHero.getY()][myHero.getX()]=2;
			myHero.setX(myHero.getX()+1);
			maps[myHero.getY()][myHero.getX()]=5;
		}else if((maps[myHero.getY()][myHero.getX()+1]==4)&&(maps[myHero.getY()][myHero.getX()+2]!=0)&&(maps[myHero.getY()][myHero.getX()+2]!=9)&&(maps[myHero.getY()][myHero.getX()+2]!=1)&&(maps[myHero.getY()][myHero.getX()+2]!=3)){
			maps[myHero.getY()][myHero.getX()]=2;
			myHero.setX(myHero.getX()+1);
			maps[myHero.getY()][myHero.getX()]=5;


		}


	}

	/**
	 *Method who describe and applied the behavior of Down hero move
	 * @param myHero
	 * @param maps
	 * @param myDiamand
	 */

	public void dpB(Hero myHero,int[][] maps,Diamand myDiamand) {
		if ((maps[myHero.getY()+1][myHero.getX()]==1)||(maps[myHero.getY()+1][myHero.getX()]==2)||(maps[myHero.getY()+1][myHero.getX()]==3)) {
			maps[myHero.getY()][myHero.getX()]=2;
			myHero.setY(myHero.getY()+1);
			if(maps[myHero.getY()][myHero.getX()]==3 && myDiamand.getExisting()){
				myDiamand.setExisting(false);
				myHero.setScore(myHero.getScore()+1);
			}
			maps[myHero.getY()][myHero.getX()]=5;
		}else if(maps[myHero.getY()+1][myHero.getX()]==9 && myHero.getScore()>6){
			myHero.setPlaying(false);
			maps[myHero.getY()][myHero.getX()]=2;
			myHero.setY(myHero.getY()+1);
			maps[myHero.getY()][myHero.getX()]=5;
		}
		myHero.setEtat(new String("/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/dpB.gif"));
	}

	/**
	 *Method who describe and applied the behavior of Left hero move
	 * @param myHero
	 * @param maps
	 * @param myDiamand
	 */
	public void dpG(Hero myHero,int[][] maps,Diamand myDiamand) {
		myHero.setEtat(new String("/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/dpG.gif"));
		if ((maps[myHero.getY()][myHero.getX()-1]==1)||(maps[myHero.getY()][myHero.getX()-1]==2)||(maps[myHero.getY()][myHero.getX()-1]==3)) {
			maps[myHero.getY()][myHero.getX()]=2;
			myHero.setX(myHero.getX()-1);
			if(maps[myHero.getY()][myHero.getX()]==3 && myDiamand.getExisting()){
				myDiamand.setExisting(false);
				myHero.setScore(myHero.getScore()+1);
			}
			maps[myHero.getY()][myHero.getX()]=5;
		}else if(maps[myHero.getY()][myHero.getX()-1]==9 && myHero.getScore()>6){
			myHero.setPlaying(false);
			maps[myHero.getY()][myHero.getX()]=2;
			myHero.setX(myHero.getX()-1);
			maps[myHero.getY()][myHero.getX()]=5;
		}else if((maps[myHero.getY()][myHero.getX()-1]==4)&&(maps[myHero.getY()][myHero.getX()-2]!=0)&&(maps[myHero.getY()][myHero.getX()-2]!=9)&&(maps[myHero.getY()][myHero.getX()-2]!=1)&&(maps[myHero.getY()][myHero.getX()-2]!=3)){
			maps[myHero.getY()][myHero.getX()]=2;
			myHero.setX(myHero.getX()-1);
			maps[myHero.getY()][myHero.getX()]=5;


		}

	}



}
