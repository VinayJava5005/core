package programs;

/**
 * Created by pradeep on 1/7/16.
 */
public class FindZeroInMatrix {

    private static int countZero(int[][] matrix) {
        int count = 0;

        int row = 0;
        int col = 0;
        while (row < 4 && col < 3) {
            if (matrix[row][col++] == 0) {
                count++;
            } else {
                row++;
                col = 0;
            }

            if (col == 3) {
                row++;
                col = 0;
            }

        }

        return count;
    }

    private static int getZeroCount(int[][] matrix, int row) {

        int count = 0;
        for (int index = 0; index < row; index++) {
            count += countZeroRecursive(matrix[index], 0, matrix[index].length - 1);
        }

        return count;

    }

    private static int countZeroRecursive(int[] matrix, int startIndex, int lastIndex) {
        int count = 0;
        if ((startIndex <= lastIndex) && (startIndex < matrix.length)) {
            int mid = (startIndex + lastIndex) / 2;
            if (matrix[mid] == 0) {
                count += (mid - startIndex + 1);
                count += countZeroRecursive(matrix, mid + 1, lastIndex);
            } else {
                count += countZeroRecursive(matrix, startIndex, mid - 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 1}, {0, 0, 1}, {0, 1, 1}, {0, 1, 1}};
        System.out.println(countZero(matrix));
        System.out.println(getZeroCount(matrix, 4));
    }
}
