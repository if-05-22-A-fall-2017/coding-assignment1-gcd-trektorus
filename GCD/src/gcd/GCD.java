/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcd;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thomas
 */
public class GCD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(gcdPrimeFactors(30, 45));
        System.out.println(gcdEucledian(30, 45));
    }
    
    public static int gcdEucledian(int a, int b) { return b == 0 ? a : gcdEucledian(b, a % b); }
    
    public static int gcdPrimeFactors(int a, int b) {
        int gcd = 1;
        List<Integer> aFactors = getPrimeFactors(a);
        List<Integer> bFactors = getPrimeFactors(b); 
        List<Integer> biggerList;
        List<Integer> smallerList;
        if (aFactors.size() > bFactors.size()) {
            biggerList = aFactors;
            smallerList = bFactors;
        } else {
            biggerList = bFactors;
            smallerList = aFactors;
        }
        for (int i = 0; i < smallerList.size(); i++) {
            for (int j = 0; j < biggerList.size(); j++) {
                if (smallerList.get(i).compareTo(biggerList.get(j)) == 0) {
                    gcd *= smallerList.get(i);
                    biggerList.remove(j);
                    break;
                }
            }
        }
        return gcd;
    }
    
    private static List<Integer> getPrimeFactors(int n) {
        int number = n;
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= number / i; i++) {
            while (number % i == 0) {
                factors.add(i);
                number /= i;
            }
        }
        if (number > 1) {
            factors.add(number);
        }
        return factors;
    }
}
