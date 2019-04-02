import Exceptions.ExceptionMaxValueReached;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TestCalculator {
    private Calculator calc;

    @Before()
    public void init() {
        calc = new Calculator();
    }

    @Test()
    public void testsAddition() throws ExceptionMaxValueReached {
        // Class needs to exist
        Class<Calculator> klass = Calculator.class;
        assertNotNull(klass);

        // Method needs to exists
        assertNotNull(Arrays.stream(klass.getMethods()).filter(m -> m.getName().toLowerCase().equals("addition")));

        // Simple positive+positive addition
        assertEquals(10f, calc.addition(5f, 5f), 0.0);

        // Simple positive+negative addition
        assertEquals(calc.addition(5f, -10f), -5f, 0.0);

        // Simple negative+positive addition
        assertEquals(5f, calc.addition(-5f, 10f), 0.0);

        // Simple negative+negative addition
        assertEquals(calc.addition(-5f, -10f), -15f, 0.0);

        // Complex positive+(positive+positive) addition
        assertEquals(40f, calc.addition(20f, calc.addition(10f, 10f)), 0.0);

        // Loop of 10 additions
        Float a1 = 0f;
        for (int i = 0; i < 10; i++) {
            a1 = calc.addition(a1, 10f);
        }
        assertEquals(a1, 100f, 0f);

        // Simple 0+positive addition
        assertEquals(5f, calc.addition(0f, 5f), 0.0);

        // Simple 0+negative addition
        assertEquals(calc.addition(0f, -5f), -5f, 0.0);
    }

    @Test(expected = ExceptionMaxValueReached.class)
    public void testExceptionMaxValue() throws ExceptionMaxValueReached {
        calc.addition(Float.MAX_VALUE, 5f);
    }
}
