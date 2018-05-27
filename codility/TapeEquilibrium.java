package test.algorithm;

import java.util.Arrays;

/**
 * Created by hyeyoung on 2018. 5. 27..
 */
public class TapeEquilibrium {

    public int solution(int[] A) {


        int minValue = Integer.MAX_VALUE;
        int totalSum = 0;
        for (int i=0; i<A.length; i++) {
            totalSum += A[i];
        }

        int frontSum = 0;

        for(int p=1; p<A.length; p++) {

            int value = A[p-1];

            frontSum += value;
            totalSum -= value;

            int absValue = Math.abs(frontSum-totalSum);

            if(absValue == 0) {
                return 0;
            }

            if(absValue < minValue) {
                minValue = absValue;
            }

        }

        return minValue;
    }


    public static void main(String[] args){

        assertThat(new int[]{3,1,2,4,3}, 1);
        assertThat(new int[]{3,8}, 5);
        assertThat(new int[]{1,2,3,4,5,6}, 1);
    }

    public static void assertThat(int[] A, int expectedNum) {
        TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
        int actualNum = tapeEquilibrium.solution(A);

        if(actualNum != expectedNum) {
            throw new RuntimeException("failed test. actualNum: " + actualNum + ", expectedNum: " + expectedNum + ", A: " + Arrays.toString(A));
        }

        System.out.println("passed test. actualNum: " + actualNum + ", expectedNum: " + expectedNum + ", A: " + Arrays.toString(A));
    }
}
