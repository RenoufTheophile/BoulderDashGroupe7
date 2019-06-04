package model.entity;

import static org.junit.Assert.*;
import org.junit.Test;

public class MonsterTest {

    private Monster test;

    @Test
    public void existing() throws  Exception{
        final boolean expected=true;
        assertEquals(expected,test.existing);
    }

}