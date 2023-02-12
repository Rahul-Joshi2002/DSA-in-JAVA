import java.util.Arrays; // greedy algorithm
import java.util.Scanner;

class dataHolder implements Comparable<dataHolder> {
    int val;
    int wt;
    double ratio;

    dataHolder(int val, int wt, double ratio) {
        this.val = val;
        this.wt = wt;
        this.ratio = ratio;
    }

    public int compareTo(dataHolder d) {
        if (this.ratio >= d.ratio) {
            return 1;
        } else {
            return -1;
        }
    }
}

// class Item implements Comparable<Item> {
// int wt;
// int val;
// double vwratio;

// public int compareTo(Item o) {
// if (this.vwratio == o.vwratio) {
// return 0;
// } else if (this.vwratio > o.vwratio) {
// return +1;
// } else {
// return -1;
// }
// }
// }

public class fractionalKnapsack {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] val = new int[n];
        int[] wt = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            wt[i] = scn.nextInt();
        }
        int cap = scn.nextInt();
        scn.close();

        dataHolder[] data = new dataHolder[n];

        for (int i = 0; i < n; i++) {
            double ratio = val[i] * 1.0 / wt[i];
            data[i] = new dataHolder(val[i], wt[i], ratio);
        }
        Arrays.sort(data);

        // Item[] items = new Item[n];
        // for (int i = 0; i < n; i++) {
        // items[i] = new Item();
        // items[i].wt = wts[i];
        // items[i].val = values[i];
        // items[i].vwratio = items[i].val * 1.0 / items[i].wt;
        // }

        for (dataHolder d : data) {
            System.out.println(d.wt + " " + d.val + " " + d.ratio);
        }
        double maxVal = 0;
        int i = n - 1;

        while (i >= 0 && cap != 0) {
            if (data[i].wt > cap) {
                // System.out.println(i + " before " + cap + " " + maxVal);
                maxVal += data[i].ratio * cap;
                cap -= cap;
                // System.out.println(i + " after " + cap + " " + maxVal);
            } else {
                // System.out.println(i + " before " + cap + " " + maxVal);
                maxVal += data[i].val;
                cap -= data[i].wt;
                // System.out.println(i + " after " + cap + " " + maxVal);
            }
            i--;
        }

        System.out.println(maxVal);
    }
}

// 20
// 1 43 22 25 10 7 17 16 7 2 12 11 37 40 48 35 1 35 3 25
// 8 5 5 2 7 3 2 4 5 6 10 3 9 6 10 4 7 7 10 3
// 4
// ---------------------------------------------------------------------------------------------

// import java.io.*;
// import java.util.*;

// public class Main {

// public static void main(String[] args) throws Exception {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// int n = Integer.parseInt(br.readLine());

// int[] values = new int[n];
// String str1 = br.readLine();
// for (int i = 0; i < n; i++) {
// values[i] = Integer.parseInt(str1.split(" ")[i]);
// }

// int[] wts = new int[n];
// String str2 = br.readLine();
// for (int i = 0; i < n; i++) {
// wts[i] = Integer.parseInt(str2.split(" ")[i]);
// }

// int cap = Integer.parseInt(br.readLine());

// Item[] items = new Item[n];
// for(int i = 0; i < n; i++){
// items[i] = new Item();
// items[i].wt = wts[i];
// items[i].val = values[i];
// items[i].vwratio = items[i].val * 1.0 / items[i].wt;
// }

// Arrays.sort(items);
// double vib = 0;
// int rc = cap;

// int i = items.length - 1;
// while(i >= 0){
// if(items[i].wt <= rc){
// vib += items[i].val;
// rc -= items[i].wt;
// } else {
// vib += items[i].val* 1.0 * rc / items[i].wt;
// rc = 0;
// break;
// }

// i--;
// }

// System.out.println(vib);
// }

// public static class Item implements Comparable<Item> {
// int wt;
// int val;
// double vwratio;

// public int compareTo(Item o){
// if(this.vwratio == o.vwratio){
// return 0;
// } else if(this.vwratio > o.vwratio){
// return +1;
// } else {
// return -1;
// }
// }
// }
// }