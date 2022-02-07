package lt.codeacademy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CalculatorTests {

  private Calculator calculator;

  @BeforeEach
  private void setup() {
    calculator = new Calculator(4, 2);
  }

  @ParameterizedTest
  @MethodSource("parameterProvider")
  void additionTest(int a, int b) {
    assertEquals(a + b, new Calculator(a, b).addition());
  }

  static Stream<Arguments> parameterProvider() {
    return Stream.of(arguments(1, 2), arguments(3, 4));
  }

  @Test
  void subtractionTest() {
    assertEquals(2, calculator.subtraction());
  }

  @Test
  void multiplicationTest() {
    assertEquals(8, calculator.multiplication());
  }

  @Test
  void divisionTest() {
    assertEquals(2, calculator.division());
  }

  @Test
  void divisionByZeroTest() {
    assertThrows(ArithmeticException.class, () -> new Calculator(3, 0).division());
  }
}
