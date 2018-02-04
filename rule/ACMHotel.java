package algorithm;

import java.util.Scanner;

/**
 * Created by hyeyoung on 2018. 2. 4..
 */
public class ACMHotel {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int arr[][] = new int[t][3];

        for(int i=0; i<t; i++) {
            for(int j=0; j<3; j++) {
                arr[i][j] = sc.nextInt();
            }
            int h = arr[i][0];
            int customer = arr[i][2];

            int wNum = customer/h;
            int hNum = customer%h;

            if(wNum == 0) {
                hNum = customer;
                wNum++;
            } else if(hNum == 0) {
                hNum = h;
            } else {
                wNum++;
            }

            System.out.println(hNum + String.format("%02d", wNum));
        }
    }
}
