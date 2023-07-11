package mockito;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

// CalculatorTest.java
public class CalculatorTest {
    @Test
    public void testAddNumbers() {
        // Erzeugen eines Mock-Objekts für MathUtil
        MathUtil mathUtil = mock(MathUtil.class);

        // Definieren des Verhaltens des Mock-Objekts
        when(mathUtil.add(2, 3)).thenReturn(5);
        when(mathUtil.subtract(10, 5)).thenReturn(5);

        // Erzeugen einer Instanz von Calculator mit dem Mock-Objekt
        Calculator calculator = new Calculator(mathUtil);

        // Aufruf der Methode addNumbers()
        int result = calculator.addNumbers(2, 3);
        calculator.subtractNumbers(10, 5);

        // Überprüfen des Ergebnisses
        assertEquals(5, result);

        // Überprüfen, ob die Methode add() des Mock-Objekts mit den erwarteten Argumenten aufgerufen wurde
        verify(mathUtil).add(2, 3);

        // Überprüfen, ob die Methode subtract() des Mock-Objekts niemals aufgerufen wurde
//        verify(mathUtil, never()).subtract(anyInt(), anyInt());

        // Überprüfen, ob die Methode subtract() des Mock-Objekts genau einmal mit den Argumenten 5 und 2 aufgerufen wurde
        verify(mathUtil, times(1)).subtract(10, 5);

        // Überprüfen, ob die Methode add() des Mock-Objekts genau einmal mit den Argumenten 2 und 3 aufgerufen wurde
        verify(mathUtil, times(1)).add(2, 3);

        // Überprüfen, ob die Methode add() des Mock-Objekts mindestens einmal mit einem beliebigen int-Argument aufgerufen wurde
        verify(mathUtil, atLeastOnce()).add(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt());
    }
}
