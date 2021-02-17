package com.disney.wdpro.service.mockpis.algorithm;

/**
 * @author tengx009
 * @className GCD
 * @description 最小公约数
 * @date 2/16/21 1:09 PM
 */
public class GCD {

    /**
     * 辗转相除法
     * @param m
     * @param n
     * @return
     */
    public static long gcd1(long m, long n){
        if (m == 0 || n == 0) {
            return 0;
        }
        long l;
        while ((l=m%n) != 0) {
            m=n;
            n=l;
        }
        long gcd = n;
        return gcd;
    }

    public static void main(String[] args) {
        System.out.println(gcd1(11,33));
    }
}
