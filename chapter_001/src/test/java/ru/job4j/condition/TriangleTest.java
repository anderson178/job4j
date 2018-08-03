package ru.job4j.condition;
import static org.hamcrest.number.IsCloseTo.closeTo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Denis Mironenko
 * @version $Id$
 * @since 03.08.2018
 */
public class TriangleTest {
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        Triangle trngl = new Triangle(a, b, c);
        // Вычисляем площадь.
        double result = trngl.area();
        double expected = 2D;
        assertThat(result, closeTo(expected, 0.1));


    }
}
