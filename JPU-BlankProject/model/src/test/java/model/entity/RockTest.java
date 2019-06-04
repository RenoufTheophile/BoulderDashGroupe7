package model.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class RockTest {

    private Rock test;

    @Test
    public void existing() throws Exception{
        final boolean exception=true;
        assertEquals(exception,test.existing);
    }

    @Test
    public void falling() throws Exception{
        final boolean exception=false;
        assertEquals(exception,test.existing);
    }

}