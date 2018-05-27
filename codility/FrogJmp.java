package test.algorithm;

/**
 * Created by hyeyoung on 2018. 5. 27..
 */
public class FrogJmp {

    public int solution(int X, int Y, int D) {

        int A = Y - X;
        if (A == 0) {
            return 0;
        }

        int jumpCnt = A / D;
        if (A % D == 0) {
            return jumpCnt;
        }

        return jumpCnt + 1;
    }

    public static void main(String[] args){

        assertThat(10, 85, 30, 3);
        assertThat(10, 150, 70, 2);
        assertThat(140, 140, 80, 0);
    }

    public static void assertThat(int X, int Y, int D, int expectedResult) {

        FrogJmp frogJmp = new FrogJmp();
        int actualResult = frogJmp.solution(X,Y,D);
        if (actualResult != expectedResult) {
            throw new RuntimeException("failed test. actualResult: " + actualResult + ", expectedResult: " + expectedResult + ", X: " + X + ", Y: " + Y + ", D: " + D);
        }

        System.out.println("passed test. actualResult: " + actualResult + ", expectedResult: " + expectedResult + ", X: " + X + ", Y: " + Y + ", D: " + D);

    }

}
