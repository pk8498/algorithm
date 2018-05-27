package test.algorithm;

import java.util.Arrays;

/**
 * Created by hyeyoung on 2018. 5. 27..
 */
public class MaxCounter {

    public int[] solution(int N, int[] A) {

        int[] countArray = new int[N];

        int max = 0;
        int tempMax = 0;

        for (int i=0; i<A.length; i++) {
            int X = A[i];

            if(1 <= X && X <= N) {
                if (countArray[X-1] < max) {
                    countArray[X-1] = max;
                }

                ++countArray[X-1];

                tempMax = Math.max(tempMax, countArray[X-1]);
            } else if (X == (N + 1)) {
                max = tempMax;
            }

        }

        for (int n=0; n<N; n++) {
            if(countArray[n] < max) {
                countArray[n] = max;
            }
        }


        return countArray;
    }

    public static void main(String[] args){

        assertThat(5, new int[]{3,4,4,6,1,4,4}, new int[]{3,2,2,4,2});
        assertThat(2, new int[]{1,3}, new int[]{1,1});
        assertThat(5, new int[]{6,6,6,6,6,6,6}, new int[]{0,0,0,0,0});
    }

    public static void assertThat(int N, int[] A, int[] expectedArray) {

        MaxCounter maxCounter = new MaxCounter();
        int[] actualArray = maxCounter.solution(N, A);
        if (!Arrays.equals(actualArray, expectedArray)) {
            throw new RuntimeException("failed test. actualArray: " + Arrays.toString(actualArray) + ", expectedArray: " + Arrays.toString(expectedArray) + ", N: " + N + ", A: " + Arrays.toString(A));
        }

        System.out.println("passed test. actualArray: " + Arrays.toString(actualArray) + ", expectedArray: " + Arrays.toString(expectedArray) + ", N: " + N + ", A: " + Arrays.toString(A));
    }

}
