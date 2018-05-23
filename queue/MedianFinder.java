package algorithm.study;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * {3,1,5,4,2} 수열이 있을 때 중간에 오는 3을 중간값이라고 한다.
 * 단, 짝수일 경우 가운데 있는 두 값 중 보다 작은 것을 수열의 중간 값이라 한다.
 * 한 수열의 중간 값은 수열에 새로운 수가 추가될 때 마다 바뀔 수 있다.
 * 각 수가 추가될 때마다 중간 값을 계산하는 프로그램을 작성하라.
 * 예를 들어 3,1,5,4,2 순서대로 숫자가 추가 될 경우 수열의 중간 값은 3,1,3,3,3 순서로 변화한다.
 * Input: 입력의 크기가 큰 관계로, 수열을 입력받는 대신 다음과 같은 식을 통해 프로그램 내에서 직접 생성한다.
 *        A[0] = 1983
 *        A[i] = (A[i-1]xa+b) mod 20090711
 *        a와 b는 입력에 주어지는 상수이다.
 *        첫 줄 : 테스트 케이스의 수 C(1<=C<=20)
 *        후 : C줄에 각 세개의 정수로 수열의 길이 N(1<=N<=200,000), 수열을 생성하는데 필요한 정수 a,b(0<=a,b<=10000) 가 주어진다.
 * Output: 각 테스트 케이스마다 한 줄에 N 개의 중간 값의 합을 20090711로 나눈 나머지를 출력한다.
 */

/* ex)
 *    Input: 3
 *           10  1  0
 *           10  1  1
 *           10000 1273 4936
 *    Output: 19830
 *            19850
 *            2448920
 */
public class MedianFinder {

    private static long FIRST_VALUE = 1983;
    private static int DIVISOR = 20090711; // 제수

    private static PriorityQueue<Long> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Long> minQueue = new PriorityQueue<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int caseCnt = sc.nextInt();

        for (int c=0; c<caseCnt; c++) {
            maxQueue.clear(); minQueue.clear();

            int size = 3;
            int arr[][] = new int[caseCnt][size];
            for (int j=0; j<size; j++) {
                arr[c][j] = sc.nextInt();
            }

            int arraySize = arr[c][0];
            int a = arr[c][1];
            int b = arr[c][2];

            maxQueue.add(FIRST_VALUE);

            long totalMedian = FIRST_VALUE;
            long lastValue = FIRST_VALUE;
            for (int i=1; i<arraySize; i++) {
                lastValue = (lastValue * a + b) % DIVISOR;
                pushQueue(lastValue);
                long median = maxQueue.peek();
                totalMedian += median;
            }
            System.out.println(totalMedian % DIVISOR);
        }

    }

    public static void pushQueue(Long value) {
        if(maxQueue.size() == minQueue.size()) {
            maxQueue.add(value);
        } else {
            minQueue.add(value);
        }

        if (!maxQueue.isEmpty() && !minQueue.isEmpty() && !(maxQueue.peek() <= minQueue.peek())) {
            long a = maxQueue.peek();
            long b = minQueue.peek();

            maxQueue.remove(a);
            minQueue.remove(b);

            maxQueue.add(b);
            minQueue.add(a);
        }
    }


}
