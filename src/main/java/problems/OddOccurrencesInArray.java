package problems;

/**
 * Created by pradeep on 3/6/17.
 */
public class OddOccurrencesInArray {

    public static int solution(int[] A) {

        int xor = A[0];
        for (int index = 1; index < A.length; index++) {
            xor = xor ^ A[index];
        }

        return xor;
    }

    public static void main(String[] args) {

        int a[] = {
                1, 2, 3, 2, 1, 5, 5,3,8,7,9,9,7
        };

        System.out.println(solution(a));
        ;
    }
}
