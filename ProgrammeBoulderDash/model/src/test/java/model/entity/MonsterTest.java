package model.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MonsterTest {

    private Monster1 test;
    @Before
    public void setUp()  {
        test=new Monster1(1,2);

    }

    @After
    public void tearDown()  {
    }

    @Test
    public void existing() throws  Exception{
        final boolean expected=true;
        assertEquals(expected,test.getExisting());
    }

}