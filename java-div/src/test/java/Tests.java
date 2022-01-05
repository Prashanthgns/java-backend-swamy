import maths.Divide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Tests {

    @DisplayName("Test for complete numbers")
    @Test
    void testCompleteNumbers() {
        var dvDr = new Divide();
        var num1 = 10;
        var num2 = 10;
        var expected = 1;
        var actual = dvDr.divideNumbers(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Test for precision point numbers")
    @Test
    void testPrecisionNumbers() {
        var dvDr = new Divide();
        var num1 = 4.2;
        var num2 = 2.2;
        var expected = 1.909090909090909;
        var actual = dvDr.divideNumbers(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Test for Unexpected Numbers")
    @Test
    void testUnexpectedNumbers() {
        var num1 = 4.5;
        var num2 = 0;

        var dvDr = new Divide();
        var expected = 0;
        var actual = dvDr.divideNumbers(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Testing Exceptions")
    @Test
    void testUnexpectedNumbersWithException() {
        var num1 = 4.5;
        var num2 = 0;

        Assertions.assertThrows(RuntimeException.class, () -> {
            var dvDr = new Divide();
            dvDr.divideNumbersException(num1, num2);
        });
    }


}
