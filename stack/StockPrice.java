package test.algorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * 주식 가격
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 */
public class StockPrice {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        
        int index = prices.length-1;
        while (index >= 0) {
            Integer originPrice = prices[index];

            int count = 0;
            for (int i=stack.size()-1; i>=0; i--) {
                Integer price = stack.get(i);
                count++;
                if(originPrice > price) {
                    break;
                }
            }
            stack.push(originPrice);

            answer[index] = count;
            index--;
        }

        return answer;
    }

    public static void main(String[] args){
        assertThat(new int[]{1,2,3,2,3} , new int[]{4,3,1,1,0});

    }

    public static void assertThat(int[] prices, int[] answer) {

        StockPrice stockPrice = new StockPrice();
        int[] actualAnswer = stockPrice.solution(prices);
        if(!Arrays.equals(answer, actualAnswer)) {
            throw new RuntimeException("Failed test. prices: " + Arrays.toString(prices)
                    + " ,answer: " + Arrays.toString(answer)
                    + " ,actualAnswer: " + Arrays.toString(actualAnswer));
        }

        System.out.println("Passed test. prices: " + Arrays.toString(prices)
                + " ,answer: " + Arrays.toString(answer));
    }

}

