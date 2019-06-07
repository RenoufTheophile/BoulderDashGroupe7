package model.BDD;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapLoadTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void readMap() throws Exception{
        int excepted [][] =
                {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,5,2,2,0,0,0,1,4,4,4,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,4,4,4,3,1},
                        {1,2,2,2,0,0,0,1,4,4,4,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,4,4,4,1},
                        {1,2,2,2,0,0,0,0,1,3,1,0,0,0,0,0,0,0,0,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,4,4,1},
                        {1,0,0,2,2,2,2,2,2,4,1,0,0,0,0,0,0,0,0,0,3,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,4,1},
                        {1,0,0,2,2,1,1,1,0,1,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,0,1},
                        {1,0,0,2,2,0,0,0,1,0,0,0,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1,2,1},
                        {1,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,1},
                        {1,3,3,3,3,3,3,3,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,0,0,2,2,2,2,2,2,2,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,2,2,2,2,2,2,2,2,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,1,1},
                        {1,0,0,0,1,1,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,1,1},
                        {1,0,0,1,3,2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,1,1,1,1},
                        {1,0,0,0,1,4,2,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1},
                        {1,0,0,0,0,1,4,2,1,0,4,4,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,1},
                        {1,0,0,0,0,0,1,4,1,0,1,1,4,0,0,0,0,0,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,0,0,0,0,1,4,1,0,1,0,0,0,0,0,0,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,2,2,2,2,2,0,0,0,0,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,2,2,2,2,2,0,0,0,9,1},
                        {1,2,2,2,0,0,0,2,0,0,0,0,2,2,0,0,0,0,0,2,2,2,2,0,0,0,0,0,0,0,0,0,2,2,2,2,0,0,0,0,0,1},
                        {1,2,2,2,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,1},
                        {1,0,2,3,2,2,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};

        int maps[][]=MapLoad.readMap(2);
       assertEquals(excepted,maps);

    }
}