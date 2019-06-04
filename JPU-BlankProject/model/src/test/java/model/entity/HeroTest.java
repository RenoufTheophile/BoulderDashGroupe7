package model.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

        private Hero test;
        @Test
        public void attente() throws Exception {
            String expected ="/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/attente.gif";
            assertEquals(expected,test.etat);
        }


        @Test
        public void playing () throws Exception {
            final boolean expected = true;
            assertEquals(expected, test.playing);
        }

        @Test
    public void isAlive() throws  Exception{
            final boolean expected=true;
            assertEquals(expected,test.isAlive);
        }


}