/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaalgorithms;

import glava1.Permutations;

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
    
    private static int recursiveSum(int n) {
        if( n == 0 ) {
            return 0;
        }
        return n + recursiveSum(n - 1);
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
        if(n < 2) {
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
        if(n == 0) {
            return m;
        }
        return recursiveNOD(n, m % n);
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
    
    private static boolean isPrime(int n) {
        int i = 2;
        if(n == 2) {
            return true;
        }
        while(i <= Math.sqrt(n)) {
            if(n % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }
    
    private static void checkGladbahOne(int n) {
        if(n % 2 != 0) {
            System.out.println("Chisloto ne e chetno, ne moje da se proveri algorituma");
            return;
        }
        
        int a = 0;
        int b = 0;
        int sum = 0;
        for(int i = 1; i < n; i++) {
            if(isPrime(i)) {
                a = i;
            }
            for(int j = 1; j < n; j++) {
                
                if(isPrime(j)) {
                    b = j;
                }
                sum = a + b;
                if(sum == n) {
                    System.out.println("a = " + a + ", b = " + b);
                    break;
                }
            }
        }
    }
    
    private static void checkGladbahTwo(int n) {
        
        if(n < 17) {
            System.out.println("Chisloto ne e po malko ot 17");
            return;
        }

        int a = 0;
        int b = 0;
        int c = 0;
        int sum = 0;
        for(int i = 1; i < n; i++) {
            if(isPrime(i)) {
                a = i;
            }
            for(int j = 1; j < n; j++) {

                if(isPrime(j)) {
                    b = j;
                }
                for(int k = 1; k < n; k++) {
                    if(isPrime(k)) {
                        c = k;
                    }
                    sum = a + b + c;
                    if(sum == n) {
                        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
                        break;
                    }
                }
            }
        }
    }
    
    private static void eratosthenSieve(int n) {
        
        int sieve[] = new int[n];
        
        for(int i = 0; i < n; i++) {
            sieve[i] = 0;
        }
        
        int j, i = 2;
        int count = 1;
        while(i < n) {
            if(sieve[i] == 0) {
                System.out.print(i + " ");
                count++;
                if(count % 20 == 0){
                    System.out.println();
                }
                j = i * i;
                while(j < n) {
                    if(j >= n) {
                        break;
                    }
                    sieve[j] = 1;
                    j += i;
                }
            }
            i++;
        }
        
    }

    //Perfect Numbers
    static int mersinPrimes[] = {
        2, 3, 5, 7, 13, 17, 19, 31, 61, 89  
    };
    static int k;
    static int number[] = new int[200];
    
    private static void doubleN() {
        
        int carry = 0;
        int temp;
        for(int i = 0; i < k; i++) {
            temp = number[i] * 2 + carry;
            number[i] = temp % 10;
            carry = temp / 10;
        }
        if(carry > 0) {
            number[k++] = carry;
        }
    }
    private static void print() {
        
        for(int i = k; i > 0; i--) {
            System.out.print(number[i-1]);
        }
        System.out.println();
    }
    
    private static void perfect(int s, int m) {
        k = 1; number[0] = 1;
        for(int i = 0; i < m; i++) {
            doubleN();  //Deliteli ot vida 2 ^ i;
        }
        number[0]--;    //Poslednata cifra sus sigurnost e izmejdu {2, 4, 6, 8}
        for(int i = 0; i < m - 1; i++) {
            doubleN();
        }
        System.out.print(s + "-то съвършено число е = ");
        print();
    }
    private static void testPerfect() {
        for (int i = 1; i <= 1; i++) {
            perfect(i, mersinPrimes[i - 1]);
        }
    }
    //End Of Perfect Numbers.
    
    //Losh algorithm za Recursia. Chislata na fibonaci
    private static int recursiveFib(int n) { 
        if(n < 2) {
            return 1;
        }

        return recursiveFib(n - 1) + recursiveFib(n - 2);
    }
    
    private static int nextFibNumber(int n) {
        return (int)((1 / Math.sqrt(5)) * (  (Math.pow(((1 + Math.sqrt(5)) / 2), n)) - (Math.pow(((1 - Math.sqrt(5)) / 2), n))));
    }
    
    
    private static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
    private static int lcm(int arr[], int n) {
        
        if(n == 2) {
            return(arr[0] * arr[1] / (gcd(arr[0], arr[1])));
        }
        int b = lcm(arr, n - 1);///<-------------
        
        return (arr[n - 1] * b) / gcd(arr[n - 1], b);
    }
    private static void testLCM() {
        int arr[] = {
           10, 8, 5, 3, 2  
        };
        System.out.println(lcm(arr, arr.length));
    }
    
    private static void printN(int n) {
//        System.out.println(n);
        
        if( n >= 10) {
            printN(n / 10);
        }
        System.out.print((n % 10) + " ");
    }
    
    static int i = 10;
    private static long recFactGlobVar() {
        if(i == 1) {
            return 1;
        }
        i--;
        return i * recFactGlobVar();
    }
    
    static int n = 5;
    private static void printRed(int k, long result) {
        System.out.print(result + " ");
        if(k < n) {
            printRed(k + 1, result * 10);
        }

        System.out.print(result + " "); 
    }
    
    private static void testPermuations() {
        for(int i = 0; i < Permutations.NUMBERS; i++) {
            Permutations.used[i] = false;
        }
        Permutations.permute(0);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        testPermuations();
        
    }
    
}
