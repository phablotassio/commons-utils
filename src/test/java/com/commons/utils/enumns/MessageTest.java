package com.commons.utils.enumns;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageTest {

    @Test
    public void testDescription() {

        assertEquals("Objects cannot be null", Message.OBJECTS_CANNOT_BE_NULL.getMessage());
        assertEquals("The objects are not of the same class", Message.OBJECTS_SAME_INTANCE.getMessage());

    }
}