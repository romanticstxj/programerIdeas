package com.disney.wdpro.service.mockpis.algorithm;

/**
 * @author tengx009
 * @className LCM
 * @description 最大公倍数
 * @date 2/16/21 1:55 PM
 */
public class LCM {

    /**
     * 最大公倍数是两数乘积，除以他们的最大公约数
     * @param m
     * @param n
     * @return
     */
    public static long lcm1(long m, long n){
        return (m * n) / GCD.gcd1(m, n);
    }

    public static void main(String[] args) {
        System.out.println(lcm1(1,3));
    }
}
