package model.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

        private Hero test;
        @Before
        public void setUp()  {
            test=new Hero(1,1);

        }

        @After
        public void tearDown()  {
        }
        @Test
        public void attente() throws Exception {
            String expected ="/run/media/renouf/Mori Jin/boulderMaven(1)/JPU-BlankProject/model/src/main/resources/sprites/attente.gif";
            assertEquals(expected,test.getEtat());
        }
        @Test
        public void playing () throws Exception {
            final boolean expected = true;
            assertEquals(expected, test.getPlaying());
        }
        @Test
        public void isAlive() throws  Exception{
            final boolean expected=true;
            assertEquals(expected,test.getIsAlive());
        }
}