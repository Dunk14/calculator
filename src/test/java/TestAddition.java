import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestAddition {
    private Calculator calc;

    @Before()
    public void init() {
        calc = new Calculator();
    }

    @Test
    public void testsAddition() {
        // Simple positive+positive addition
        System.out.println("Simple positive+positive addition");
        Float a1 = calc.addition(5F, 5F);
        assertEquals(a1, 10F, 0.01F);

        // Simple positive+negative addition
        System.out.println("Simple positive+negative addition");
        Float a2 = calc.addition(5F, -10F);
        assertEquals(a2, -5F, 0F);

        // Simple negative+positive addition
        System.out.println("Simple negative+positive addition");
        Float a3 = calc.addition(-5F, 10F);
        assertEquals(a3, 5F, 0F);

        // Simple negative+negative addition
        System.out.println("Simple negative+negative addition");
        Float a4 = calc.addition(-5F, -10F);
        assertEquals(a4, -15F, 0F);

        // Complex positive+(positive+positive) addition
        System.out.println("Simple positive+(positive+positive) addition");
        Float a5 = calc.addition(20F, calc.addition(10F, 10F));
        assertEquals(a5, 40F, 0F);

        // Loop of 10 additions
        System.out.println("Loop of 10 additions");
        Float a6 = 0F;
        for (int i = 0; i < 10; i++) {
            a6 = calc.addition(a6, 10F);
        }
        assertEquals(a6, 100F, 0F);
    }
}
