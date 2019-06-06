package model.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MonsterTest {

    private Monster1 test;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void existing() throws  Exception{
        final boolean expected=true;
        assertEquals(expected,test.getExisting());
    }

}