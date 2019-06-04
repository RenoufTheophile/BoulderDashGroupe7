package controller;

import model.entity.*;

/**
 * @author Batiste Lubrano Luvadera,Théophile Renouf,Achille Brossier,Marc-Adrien Pointel
 * I'm a WatchClass
 */

public class Controller {
	
	public Controller() {
		
	}
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
			if((myRock[n].x == x) && (myRock[n].y == y)) {
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
			if((myDiamands[n].x == x) && (myDiamands[n].y == y)) {
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
	public Monster findMonster(Monster[] myMonster, int nbrMonstre, int x, int y){
		int n=0;
		while (n<nbrMonstre){
			if((myMonster[n].x==x) && (myMonster[n].y==y)){
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

		if(myRock.existing) {
			if(maps[myRock.y+1][myRock.x]==2) {
				maps[myRock.y][myRock.x]=2;
				myRock.y++;
				maps[myRock.y][myRock.x]=4;
				if(!myRock.falling) {
					myRock.falling=true;
				}else if (maps[myRock.y+1][myRock.x]!=2){
					michaelBay(maps,myRock.x,myRock.y,myHero,myRock,myDiamand);
				}
			}else if((maps[myRock.y][myRock.x+1]==2) && (maps[myRock.y+1][myRock.x+1]==2)){
				maps[myRock.y][myRock.x]=2;
				myRock.x++;
				maps[myRock.y][myRock.x]=4;
			}else if((maps[myRock.y][myRock.x-1]==2) && (maps[myRock.y+1][myRock.x-1]==2)){
				maps[myRock.y][myRock.x]=2;
				myRock.x--;
				maps[myRock.y][myRock.x]=4;


			}else if ((maps[myRock.y][myRock.x+1]==2)&&(maps[myRock.y][myRock.x]==5)){

					maps[myRock.y][myRock.x] = 5;
					myRock.x++;
					maps[myRock.y][myRock.x] = 4;




			}else if((maps[myRock.y][myRock.x-1]==2)&&(maps[myRock.y][myRock.x]==5)) {

					maps[myRock.y][myRock.x] = 5;
					myRock.x--;
					maps[myRock.y][myRock.x] = 4;


			}
		}
	}

	/**
	 *Method who describe and applied the behavior of the falling Diamonds
	 * @param maps
	 * @param myDiamand
	 */


	public void fall(int[][] maps,Diamand myDiamand) {
		if(myDiamand.existing) {
			if(maps[myDiamand.y+1][myDiamand.x]==2) {
				maps[myDiamand.y][myDiamand.x]=2;
				myDiamand.y++;
				maps[myDiamand.y][myDiamand.x]=3;
			}else if((maps[myDiamand.y][myDiamand.x+1]==2) && (maps[myDiamand.y+1][myDiamand.x+1]==2)){

				maps[myDiamand.y][myDiamand.x]=2;
				myDiamand.x++;
				maps[myDiamand.y][myDiamand.x]=3;
			}else if((maps[myDiamand.y][myDiamand.x-1]==2) && (maps[myDiamand.y+1][myDiamand.x-1]==2)){
				maps[myDiamand.y][myDiamand.x]=2;
				myDiamand.x--;
				maps[myDiamand.y][myDiamand.x]=3;
			}
		}
	}

	/**
	 *Method who describe and applied the behavior of the Monster move and the the action of killing
	 * @param maps
	 * @param myMonster
	 * @param myHero
	 */
	public void moving(int[][] maps, Monster myMonster, Hero myHero){

				if(myMonster.existing) {
					switch(myMonster.sensDp){

						case 'H':
							if ((maps[myMonster.y][myMonster.x+1 ] == 2)||(maps[myMonster.y][myMonster.x+1]==5))  {
								if (maps[myMonster.y][myMonster.x+1]==5){
									myHero.isAlive=false;

								}
								maps[myMonster.y][myMonster.x] = 2;
								myMonster.x++;
								maps[myMonster.y][myMonster.x] = 7;
								myMonster.sensDp='D';
								System.out.println(myMonster.x);
							} else if ((maps[myMonster.y-1][myMonster.x ] == 2)||(maps[myMonster.y-1][myMonster.x]==5)) {
								if (maps[myMonster.y-1][myMonster.x]==5){
								myHero.isAlive=false;


							}
								maps[myMonster.y][myMonster.x] = 2;
								myMonster.y--;
								maps[myMonster.y][myMonster.x] = 7;
								myMonster.sensDp='H';
								System.out.println(myMonster.y);
							} else if ((maps[myMonster.y][myMonster.x - 1] == 2)||(maps[myMonster.y][myMonster.x-1]==5))  {
								if (maps[myMonster.y][myMonster.x-1]==5){
									myHero.isAlive=false;


								}
								maps[myMonster.y][myMonster.x] = 2;
								myMonster.x--;
								maps[myMonster.y][myMonster.x] = 7;
								myMonster.sensDp='G';
								System.out.println(myMonster.x);
							}else if ((maps[myMonster.y+1][myMonster.x ] == 2)||(maps[myMonster.y+1][myMonster.x]==5)) {
								if (maps[myMonster.y+1][myMonster.x]==5){
									myHero.isAlive=false;


								}
								maps[myMonster.y][myMonster.x] = 2;
								myMonster.y ++;
								maps[myMonster.y][myMonster.x] = 7;
								myMonster.sensDp='B';
								System.out.println(myMonster.y);
							}

							break;
						case 'D':

							if ((maps[myMonster.y+1][myMonster.x ] == 2)||(maps[myMonster.y+1][myMonster.x]==5))  {
								if (maps[myMonster.y+1][myMonster.x]==5){
									myHero.isAlive=false;


								}
								maps[myMonster.y][myMonster.x] = 2;
								myMonster.y ++;
								maps[myMonster.y][myMonster.x] = 7;
								myMonster.sensDp='B';
								System.out.println(myMonster.y);
							} else if ((maps[myMonster.y][myMonster.x + 1] == 2)||(maps[myMonster.y][myMonster.x+1]==5))  {
								if (maps[myMonster.y][myMonster.x+1]==5){
									myHero.isAlive=false;

								}
								maps[myMonster.y][myMonster.x] = 2;
								myMonster.x++;
								maps[myMonster.y][myMonster.x] = 7;
								myMonster.sensDp='D';
								System.out.println(myMonster.x);
							} else if ((maps[myMonster.y-1][myMonster.x ] == 2)||(maps[myMonster.y-1][myMonster.x]==5))  {
								if (maps[myMonster.y-1][myMonster.x]==5){
									myHero.isAlive=false;

								}
								maps[myMonster.y][myMonster.x] = 2;
								myMonster.y--;
								maps[myMonster.y][myMonster.x] = 7;
								myMonster.sensDp='H';
								System.out.println(myMonster.y);
							} else if ((maps[myMonster.y][myMonster.x - 1] == 2)||(maps[myMonster.y][myMonster.x-1]==5)) {
								if (maps[myMonster.y][myMonster.x-1]==5){
								myHero.isAlive=false;

							}

								maps[myMonster.y][myMonster.x] = 2;
								myMonster.x--;
								maps[myMonster.y][myMonster.x] = 7;
								myMonster.sensDp='G';
								System.out.println(myMonster.x);
							}
							break;
						case 'B':
							if ((maps[myMonster.y][myMonster.x - 1] == 2)||(maps[myMonster.y][myMonster.x-1]==5)) {
								if (maps[myMonster.y][myMonster.x-1]==5){
									myHero.isAlive=false;


								}
								maps[myMonster.y][myMonster.x] = 2;
								myMonster.x--;
								maps[myMonster.y][myMonster.x] = 7;
								myMonster.sensDp='G';
								System.out.println(myMonster.x);
							}else if ((maps[myMonster.y + 1][myMonster.x] == 2)||(maps[myMonster.y+1][myMonster.x]==5)) {
								if (maps[myMonster.y+1][myMonster.x]==5){
									myHero.isAlive=false;


								}
								maps[myMonster.y][myMonster.x] = 2;
								myMonster.y ++;
								maps[myMonster.y][myMonster.x] = 7;
								myMonster.sensDp='B';
								System.out.println(myMonster.y);
							} else if ((maps[myMonster.y][myMonster.x + 1] == 2)||(maps[myMonster.y][myMonster.x+1]==5)) {
								if (maps[myMonster.y][myMonster.x+1]==5){
									myHero.isAlive=false;


								}
								maps[myMonster.y][myMonster.x] = 2;
								myMonster.x++;
								maps[myMonster.y][myMonster.x] = 7;
								myMonster.sensDp='D';
								System.out.println(myMonster.x);
							} else if ((maps[myMonster.y - 1][myMonster.x] == 2)||(maps[myMonster.y-1][myMonster.x]==5)) {
								if (maps[myMonster.y-1][myMonster.x]==5){
									myHero.isAlive=false;


								}
								maps[myMonster.y][myMonster.x] = 2;
								myMonster.y--;
								maps[myMonster.y][myMonster.x] = 7;
								myMonster.sensDp='H';
								System.out.println(myMonster.y);
							}
								break;
						case 'G':
							if ((maps[myMonster.y-1][myMonster.x ] == 2)||(maps[myMonster.y-1][myMonster.x]==5))  {
								if (maps[myMonster.y-1][myMonster.x]==5){
									myHero.isAlive=false;


								}
								maps[myMonster.y][myMonster.x] = 2;
								myMonster.y--;
								maps[myMonster.y][myMonster.x] = 7;
								myMonster.sensDp='H';
								System.out.println(myMonster.y);
							} else if ((maps[myMonster.y][myMonster.x - 1] == 2)||(maps[myMonster.y][myMonster.x-1]==5))  {
								if (maps[myMonster.y][myMonster.x-1]==5){
									myHero.isAlive=false;


								}
								maps[myMonster.y][myMonster.x] = 2;
								myMonster.x--;
								maps[myMonster.y][myMonster.x] = 7;
								myMonster.sensDp='G';
								System.out.println(myMonster.x);
							}
							else if ((maps[myMonster.y+1][myMonster.x ] == 2)||(maps[myMonster.y+1][myMonster.x]==5))  {
								if (maps[myMonster.y+1][myMonster.x]==5){
									myHero.isAlive=false;


								}
								maps[myMonster.y][myMonster.x] = 2;
								myMonster.y ++;
								maps[myMonster.y][myMonster.x] = 7;
								myMonster.sensDp='B';
								System.out.println(myMonster.y);
							} else if ((maps[myMonster.y][myMonster.x +1] == 2)||(maps[myMonster.y][myMonster.x+1]==5))  {
								if (maps[myMonster.y][myMonster.x+1]==5){
									myHero.isAlive=false;


								}
								maps[myMonster.y][myMonster.x] = 2;
								myMonster.x++;
								maps[myMonster.y][myMonster.x] = 7;
								myMonster.sensDp='D';
								System.out.println(myMonster.x);
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
		myRock.existing=false;
		for(int y = cy-1;y<=cy+1;y++){
			for(int x = cx-1;x<=cx+1;x++){
				if( (maps[y][x]==0) || (maps[y][x]==1) ||(maps[y][x]==2)  || (maps[y][x]==4) ) {

					maps[y][x] = 8;


				}else if((maps[y][x]==6)||maps[y][x]==7){
					maps[y][x]=8;
				}
				else if (maps[y][x]==5)	{
					maps[y][x]=8;
					myHero.isAlive=false;
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

		if ((maps[monHero.y-1][monHero.x]==1)||(maps[monHero.y-1][monHero.x]==2)||(maps[monHero.y-1][monHero.x]==3)) {
			maps[monHero.y][monHero.x]=2;
			monHero.y--;
			if(maps[monHero.y][monHero.x]==3 && myDiamand.existing){
				myDiamand.existing=false;
				monHero.score++;
			}
			maps[monHero.y][monHero.x]=5;
		}else if(maps[monHero.y-1][monHero.x]==9 && monHero.score>6){
			monHero.playing=false;
			maps[monHero.y][monHero.x]=2;
			monHero.y--;
			maps[monHero.y][monHero.x]=5;
		}
		monHero.etat = new String("/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/dpH.gif");
	}

	/**
	 *Method who describe and applied the behavior of Right hero move
	 * @param myHero
	 * @param maps
	 * @param myDiamand
	 */
	public void dpD(Hero myHero,int[][] maps,Diamand myDiamand) {
		myHero.etat = new String("/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites//dpD.gif");
		if ((maps[myHero.y][myHero.x+1]==1)||(maps[myHero.y][myHero.x+1]==2)||(maps[myHero.y][myHero.x+1]==3)) {
			maps[myHero.y][myHero.x]=2;
			myHero.x++;
			if(maps[myHero.y][myHero.x]==3 && myDiamand.existing){
				myDiamand.existing=false;
				myHero.score++;
			}

			maps[myHero.y][myHero.x]=5;
		}else if(maps[myHero.y][myHero.x+1]==9 && myHero.score>6){
			myHero.playing=false;
			maps[myHero.y][myHero.x]=2;
			myHero.x++;
			maps[myHero.y][myHero.x]=5;
		}else if((maps[myHero.y][myHero.x+1]==4)&&(maps[myHero.y][myHero.x+2]!=0)&&(maps[myHero.y][myHero.x+2]!=9)&&(maps[myHero.y][myHero.x+2]!=1)&&(maps[myHero.y][myHero.x+2]!=3)){
			maps[myHero.y][myHero.x]=2;
			myHero.x++;
			maps[myHero.y][myHero.x]=5;


		}


	}

	/**
	 *Method who describe and applied the behavior of Down hero move
	 * @param myHero
	 * @param maps
	 * @param myDiamand
	 */
	
	public void dpB(Hero myHero,int[][] maps,Diamand myDiamand) {
		if ((maps[myHero.y+1][myHero.x]==1)||(maps[myHero.y+1][myHero.x]==2)||(maps[myHero.y+1][myHero.x]==3)) {
			maps[myHero.y][myHero.x]=2;
			myHero.y++;
			if(maps[myHero.y][myHero.x]==3 && myDiamand.existing){
				myDiamand.existing=false;
				myHero.score++;
			}
			maps[myHero.y][myHero.x]=5;
		}else if(maps[myHero.y+1][myHero.x]==9 && myHero.score>6){
			myHero.playing=false;
			maps[myHero.y][myHero.x]=2;
			myHero.y++;
			maps[myHero.y][myHero.x]=5;
		}
		myHero.etat = new String("/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/dpB.gif");
	}

	/**
	 *Method who describe and applied the behavior of Left hero move
	 * @param myHero
	 * @param maps
	 * @param myDiamand
	 */
	public void dpG(Hero myHero,int[][] maps,Diamand myDiamand) {
		myHero.etat = new String("/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/dpG.gif");
		if ((maps[myHero.y][myHero.x-1]==1)||(maps[myHero.y][myHero.x-1]==2)||(maps[myHero.y][myHero.x-1]==3)) {
			maps[myHero.y][myHero.x]=2;
			myHero.x--;
			if(maps[myHero.y][myHero.x]==3 && myDiamand.existing){
				myDiamand.existing=false;
				myHero.score++;
			}
			maps[myHero.y][myHero.x]=5;
		}else if(maps[myHero.y][myHero.x-1]==9 && myHero.score>6){
			myHero.playing=false;
			maps[myHero.y][myHero.x]=2;
			myHero.x--;
			maps[myHero.y][myHero.x]=5;
		}else if((maps[myHero.y][myHero.x-1]==4)&&(maps[myHero.y][myHero.x-2]!=0)&&(maps[myHero.y][myHero.x-2]!=9)&&(maps[myHero.y][myHero.x-2]!=1)&&(maps[myHero.y][myHero.x-2]!=3)){
			maps[myHero.y][myHero.x]=2;
			myHero.x--;
			maps[myHero.y][myHero.x]=5;


		}

	}

	
	
}
