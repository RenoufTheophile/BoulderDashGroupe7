package controller;

import model.entity.Hero;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerTest {
    private Hero test;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findRock() throws Exception{
    }

    @Test
    public void findDiamand() throws Exception{
    }

    @Test
    public void findMonster() throws Exception{
    }

    @Test
    public void fall() throws Exception{
    }

    @Test
    public void fall1() throws Exception{
    }

    @Test
    public void moving() throws Exception{
    }

    @Test
    public void michaelBay() throws Exception{
    }

    @Test
    public void dpH() throws Exception{
        String expected ="/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/dpH.gif";
        assertEquals(expected,test.etat);
    }

    @Test
    public void dpD() throws Exception{
        String expected ="/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/dpD.gif";
        assertEquals(expected,test.etat);
    }

    @Test
    public void dpB() throws Exception{
        String expected ="/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/dpB.gif";
        assertEquals(expected,test.etat);
    }

    @Test
    public void dpG() throws Exception{
        String expected ="/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/dpG.gif";
        assertEquals(expected,test.etat);
    }
}