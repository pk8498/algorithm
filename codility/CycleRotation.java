package test.algorithm;

import java.util.Arrays;

/**
 * Created by hyeyoung on 2018. 5. 27..
 */
public class CycleRotation {


    public int[] solution(int[] A, int K) {

        int length =  A.length;
        if(length == 0) {
            return A;
        }

        int remainder = K % length;
        if(remainder == 0) {
            return A;
        }

        int[] array = new int[length];


        for (int i=0; i<length; i++) {
            int index = i + remainder;
            if(index >= length) {
                index -= length;
            }

            array[index] = A[i];
        }

        return array;
    }

    public static void main(String[] args){

        assertThat(new int[]{0,0,0}, 1, new int[]{0,0,0});
        assertThat(new int[]{3,8,9,7,6}, 3, new int[]{9,7,6,3,8});
        assertThat(new int[]{1,2,3,4}, 4, new int[]{1,2,3,4});
        assertThat(new int[]{}, 4, new int[]{});
    }

    public static void assertThat(int[] A, int K, int[] expectedArray) {
        CycleRotation cycleRotation = new CycleRotation();
        int[] actualArray = cycleRotation.solution(A, K);

        if (!Arrays.equals(actualArray, expectedArray)) {
            new RuntimeException("failed test. actualArray: " + Arrays.toString(actualArray)
                    + ", expectedArray: " + Arrays.toString(expectedArray) + ", A: "
                    + Arrays.toString(A) + ", K: " + K);
        }

        System.out.println("passed test. actualArray: " + Arrays.toString(actualArray)
                + ", expectedArray: " + Arrays.toString(expectedArray)
                + ", A: " + Arrays.toString(A) + ", K: " + K);
    }

}
