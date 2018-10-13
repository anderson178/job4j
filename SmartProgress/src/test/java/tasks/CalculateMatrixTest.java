package tasks;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Denis Mironenko
 * @version $Id$
 * @since 19.08.2018
 */
public class CalculateMatrixTest {
    @Test
    public void calculateMatrixOnVectorTest() {
        CalculateMatrix calculate = new CalculateMatrix();
        int[][] matrix = {
                {2, 4, 0},
                {-2, 1, 3},
                {-1, 0, 1}
        };
        int[] vector = {1, 2, -1};
        int[] expect = {10, -3, -2};
        int[] result = calculate.calculateMatrixOnVector(matrix, vector);
        assertThat(result, is(expect));
    }
}
