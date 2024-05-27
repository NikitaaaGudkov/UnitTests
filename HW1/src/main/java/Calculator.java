import static org.assertj.core.api.Assertions.*;

public class Calculator {
    public static double calculateDiscount(double sum, double discount) {
        if(sum <= 0 || discount < 0 || discount > 100) {
            throw new ArithmeticException();
        }
        return sum * (1 - discount / 100);
    }

    public static void main(String[] args) {
        assertThat(Calculator.calculateDiscount(100, 10)).isEqualTo(90);
        assertThatThrownBy(() -> Calculator.calculateDiscount(0, 5)).isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() -> Calculator.calculateDiscount(10, -5)).isInstanceOf(ArithmeticException.class);
        assertThatThrownBy(() -> Calculator.calculateDiscount(10, 101)).isInstanceOf(ArithmeticException.class);
    }
}
