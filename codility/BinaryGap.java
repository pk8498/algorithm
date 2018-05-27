package test.algorithm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hyeyoung on 2018. 5. 27..
 */
public class BinaryGap {

    public int solution(int N) {
        String binaryStr = Integer.toBinaryString(N);

        Pattern pattern = Pattern.compile("[0]+1");
        Matcher matcher = pattern.matcher(binaryStr);

        int maxLength = 0;
        while(matcher.find()) {
            int length = matcher.group().length();
            if (length > maxLength) {
                maxLength = length;
            }
        }

        if(maxLength == 0) {
            return maxLength;
        }

        return maxLength-1;
    }

    public static void main(String[] args){

        assertThat(2, 0);
        assertThat(1041, 5);
        assertThat(1, 0);
        assertThat(468, 1);
        assertThat(529,4);
    }

    public static void assertThat(int n, int expectedResult) {

        BinaryGap binaryGap = new BinaryGap();
        int actualResult = binaryGap.solution(n);
        if (actualResult != expectedResult) {
            throw new RuntimeException("failed test. actualResult: " + actualResult + ", expectedResult: " + expectedResult + ", n: " + n);
        }

        System.out.println("passed test. n: " + n + ", actualResult: " + actualResult + ", expectedResult: " + expectedResult);

    }

}
