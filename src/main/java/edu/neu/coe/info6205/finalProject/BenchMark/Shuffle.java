package edu.neu.coe.info6205.finalProject.BenchMark;

import java.util.Random;

public class Shuffle {
     private  static Random random = new Random();
     public static String[] shuffle(String[] s){
         int n = s.length;
         for(int i = 0;i < n;i++){
             int r = i + random.nextInt(n - i);
             String temp = s[i];
             s[i] = s[r];
             s[r] = temp;
         }
         return s;
     }
}
