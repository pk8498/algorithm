package algorithm;

import java.util.Scanner;

/**
 * Created by hyeyeong on 2018. 1. 27..
 */
public class Honeycomb {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int distance = 1;
        int lastNum = 1;

        while(num > lastNum) {
            lastNum = (6 * distance) + lastNum;
            distance++;
        }

        System.out.println(distance);
        sc.close();
    }
}
