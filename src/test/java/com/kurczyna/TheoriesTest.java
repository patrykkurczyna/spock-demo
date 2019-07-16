package com.kurczyna;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(Theories.class)
public class TheoriesTest {

    @DataPoints("data")
    public static int[][] data =
            {{2, 3, 5}, {3, 11, 14}, {21, 0, 21}};

    @Theory
    public void shouldAddTwoNumbers(@FromDataPoints("data") int[] data) {
        assertEquals(data[2], data[0] + data[1]);
    }
}