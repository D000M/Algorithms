/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaalgorithms;

/**
 *
 * @author DooM
 */

public class JavaAlgorithms {
    
    private static void evklidNonRecursive(int m, int n) {
        while(true) {
            if(m < n) {
                int temp = m;
                m = n;
                n = temp;
            }
            m = m % n;
            if(m == 0) {
                break;
            }
        }
        System.out.println("NOD = " + n);
    }
    
    private static void digitsOfNumber(int n) {
        int digits = 0;
        for( ; n > 0; n /= 10, digits++);
        System.out.println("Broq cifrin na chisloto e: " + digits);
    }
    
    private static int sum(int n) {
        return (n*(n + 1)) / 2;
    }
    
    private static double power(int x, int y) {
        double res = x;
        for(int i = 1; i < y; i++) {
            res *= x;
        }
        return res;
    }
    private static long factoriel(int n) {
        long res = 1;
        for(int i = 1; i <= n; i++ ) {
            res *= i;
        }
        return res;
    }
    
    private static long recursiveFactoriel(int n) {
        if(n == 0) {
            return 1;
        }
        return n * recursiveFactoriel(n - 1);
    }
    
    private static long recursivePower(int x, int y) {
        if(y == 0) {
            return 1;
        }
        return x * recursivePower(x, y - 1);
    }
    
    private static int recursiveNOD(int m, int n) {
        if(m % n == 0) {
            return n;
        }
        if(m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        return recursiveNOD(m %= n, n);
    }
    
    private static void fillMatrix(int a[][], int n) {
        
        int maxN = (a.length * a.length) - a.length;
        
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length; j++) {
                if(i == j) {
                     a[j][i] = 0;
                }
                else if(j > i) {
                    a[j][i] = n++;
                }
                else if(j < i) {
                    a[j][i] = maxN--;
                }
            }
        }
    }
    
    private static void printArray(int arr[][]) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int arr[][] = new int[10][10];
        fillMatrix(arr, 1);
        printArray(arr);
    }
    
}
