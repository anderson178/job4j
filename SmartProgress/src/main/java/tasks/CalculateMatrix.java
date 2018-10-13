package tasks;

/**
 * @author Denis Mironenko
 * @version $Id$
 * @since 19.08.2018
 */
public class CalculateMatrix {
    /**
     * Метод перемножения матрицы на вектор
     * @param matrix - входящий двухмерный массив
     * @param vector - входящий вектор
     * @return - результат перемножения матрицы на веторк
     */
    public int[] calculateMatrixOnVector(int[][] matrix, int[] vector) {
        int[] result = new int[vector.length];
        int temp = 0;
        if (matrix.length == vector.length) {
            for (int i = 0; i < vector.length; i++) {
                for (int j = 0; j < vector.length; j++) {
                    temp += matrix[i][j] * vector[j];
                }
                result[i] = temp;
                temp = 0;
            }
        }
        return result;
    }
}
