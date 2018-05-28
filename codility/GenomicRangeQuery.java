package test.algorithm;

import java.util.Arrays;

/**
 * Created by hyeyoung on 2018. 5. 28..
 */
// TODO score 100/0...
public class GenomicRangeQuery {

    public enum GenomicType {
        A(1),C(2),G(3),T(4);

        private int value;

        private GenomicType(int value) {
            this.value = value;
        }
    };

    public int[] solution(String S, int[] P, int[] Q) {

        int M = P.length;

        int[] res = new int[M];
        for (int i=0; i<M; i++) {
            int p = P[i];
            int q = Q[i];

            String subString = S.substring(p, q+1);

            int minValue;
            if(subString.contains(GenomicType.A.name())) {
                minValue = GenomicType.A.value;
            } else if(subString.contains(GenomicType.C.name())) {
                minValue = GenomicType.C.value;
            } else if(subString.contains(GenomicType.G.name())) {
                minValue = GenomicType.G.value;
            } else {
                minValue = GenomicType.T.value;
            }


            res[i] = minValue;
        }

        return res;
    }


    public static void main(String[] args){
        assertThat("CAGCCTA", new int[]{2,5,0}, new int[]{4,5,6}, new int[]{2,4,1});
        assertThat("CGGCTTA", new int[]{1,5,0,0}, new int[]{5,5,6,3}, new int[]{2,4,1,2});
    }

    public static void assertThat(String S, int[] P, int[] Q, int[] expectedArray) {
        GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();
        int[] actualArray = genomicRangeQuery.solution(S, P, Q);
        if(!Arrays.equals(actualArray, expectedArray)) {
            throw new RuntimeException("failed test. actualArray: " + Arrays.toString(actualArray) + ", expectedArray: " + Arrays.toString(expectedArray) + ", S: " + S + ", P: " + Arrays.toString(P) + ", Q: " + Arrays.toString(Q));

        }

        System.out.println("passed test. actualArray: " + Arrays.toString(actualArray) + ", expectedArray: " + Arrays.toString(expectedArray) + ", S: " + S + ", P: " + Arrays.toString(P) + ", Q: " + Arrays.toString(Q));


    }


}
