/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glava1;

/**
 *
 * @author DooM
 */
public class Permutations {
    
    final static int MAXN = 100;
    public static int NUMBERS = 3;
    static int maxPerm[] = new int[MAXN];
    public static boolean used[] = new boolean[MAXN];
    
    private static void printPermutation() {
        for(int i = 0; i < NUMBERS; i++) {
            int n = maxPerm[i];
            System.out.print(" " + n);
        }
        System.out.println();
    }
    
    public static void permute(int currPerm) {
        if(currPerm >= NUMBERS) {
            printPermutation();
            return;
        }
        for(int k = 0; k < NUMBERS; k++) {
            if(!used[k]) {
                used[k] = true;
                maxPerm[currPerm] = k + 1;
                permute(currPerm + 1);
                used[k] = false;
            }
        }
    }
    
}
