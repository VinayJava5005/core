package problems;

/**
 * Created by pradeep on 5/6/17.
 */
public class PermMissingElem {

    public static int solution(int[] A) {

        int n = A.length + 1;

        int sumOfN = (n * (n + 1)) / 2;

        int sum = 0;
        for (int index = 0; index < A.length; index++) {
            sum += A[index];
        }

        return sumOfN - sum;

    }


    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 3, 1, 5}));
    }
}
