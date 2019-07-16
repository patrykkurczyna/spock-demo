package com.kurczyna;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2, 3, 5}, {3, 11, 14}, {21, 0, 21}
        });
    }

    private int a;
    private int b;
    private int result;

    public ParameterizedTest(int a, int b, int result) {
        this.a = a;
        this.b = b;
        this.result = result;
    }

    @Test
    public void shouldAddTwoNumbers() {
        assertEquals(result, a + b);
    }
}