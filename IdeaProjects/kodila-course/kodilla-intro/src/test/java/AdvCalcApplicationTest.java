import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AdvCalcApplicationTest {

    @Test
    void testRunMethod() {
        // Given
        UserDialogs userDialogs = Mockito.mock(UserDialogs.class);
        when(userDialogs.getUserSelection()).thenReturn("A");
        when(userDialogs.getValue()).thenReturn(5).thenReturn(7);

        AdvCalculator calculator = new AdvCalculator(userDialogs);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        AdvCalcApplication app = new AdvCalcApplication();

        // When
        app.run();

        // Then
        String expectedOutput = "Result: 12.0" + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString(), "Wynik powinien być 'Result: 12.0'.");
    }
}