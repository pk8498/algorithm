package test.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 다리위를 지나는 트럭
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */
public class BridgeTruck {

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        if (truck_weights.length == 1) {
            return bridge_length + 1;
        }

        int time = 0;

        // 다리의 길이만큼 0을 넣는다.
        Queue<Integer> trucks = new LinkedList<>();
        for (int i=0; i<bridge_length; i++) {
            trucks.offer(0);
        }

        int totalWeight = 0;
        int idx = 0;
        while(idx < truck_weights.length) {
            time++;
            totalWeight -= trucks.poll();

            if(totalWeight + truck_weights[idx] > weight) {
                trucks.offer(0);
                continue;
            }

            trucks.offer(truck_weights[idx]);
            totalWeight += truck_weights[idx];
            idx++;
        }

        time += bridge_length;


        return time;
    }


    public static void main(String[] args) {
        assertThat(2, 10, new int[]{7,4,5,6}, 8);
        assertThat(100, 100, new int[]{10}, 101);
        assertThat(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}, 110);
        assertThat(3, 10, new int[]{3,4,5,6}, 10);

    }

    public static void assertThat(int bridge_length, int weight, int[] truck_weights, int answer) {

        BridgeTruck bridgeTruck = new BridgeTruck();
        int actualAnswer = bridgeTruck.solution(bridge_length, weight, truck_weights);
        if(actualAnswer != answer) {
            throw new RuntimeException("Failed test. actualAnswer: " + actualAnswer + ", expectedAnswer: " + answer
                    + ", bridge_length: " + bridge_length + ", weight: " + weight + ", truck_weights: " + Arrays.toString(truck_weights));
        }

        System.out.println("Passed test. actualAnswer: " + actualAnswer + ", expectedAnswer: " + answer
                + ", bridge_length: " + bridge_length + ", weight: " + weight + ", truck_weights: " + Arrays.toString(truck_weights));

    }


}

