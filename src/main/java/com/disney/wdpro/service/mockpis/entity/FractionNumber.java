package com.disney.wdpro.service.mockpis.entity;

import com.disney.wdpro.service.mockpis.algorithm.GCD;
import com.disney.wdpro.service.mockpis.algorithm.LCM;
import com.disney.wdpro.service.mockpis.utils.BeanUtil;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author tengx009
 * @className fraction
 * @description
 * @date 2/16/21 2:05 PM
 */
@Data
@Accessors(chain = true)
public class FractionNumber {

    private long numerator;

    private long denominator;

    private BigDecimal decimal;

    public FractionNumber add(FractionNumber other){
        long lcm = LCM.lcm1(this.denominator, other.denominator);
        long addedDenominator = lcm;
        long addedNumerator = this.numerator*(lcm/this.denominator) + other.numerator*(lcm/other.denominator);
        FractionNumber fractionNumber = new FractionNumber().setNumerator(addedNumerator).setDenominator(addedDenominator);
        return normalizeFraction(fractionNumber);
    }

    public FractionNumber subtract(FractionNumber other){
        long lcm = LCM.lcm1(this.denominator, other.denominator);
        long subtractedNumerator = this.numerator*(lcm/this.denominator) - other.numerator*(lcm/other.denominator);
        long subtractedDenominator = lcm;
        FractionNumber fractionNumber = new FractionNumber().setNumerator(subtractedNumerator)
                .setDenominator(subtractedDenominator);
        return normalizeFraction(fractionNumber);
    }

    /**
     * 先相乘，再除以最大公约数
     * @param other
     * @return
     */
    public FractionNumber multiply(FractionNumber other){
        FractionNumber fractionNumber = new FractionNumber().setNumerator(this.numerator * other.numerator)
                .setDenominator(this.denominator * other.denominator);
        return normalizeFraction(fractionNumber);
    }

    /**
     * a除以b = a乘以b的倒数
     * @param other
     * @return
     */
    public FractionNumber divide(FractionNumber other){
        FractionNumber fractionNumber = multiply(reciprocal(other));
        return normalizeFraction(fractionNumber);
    }

    /**
     * 求分数的倒数
     * @param original
     * @return
     */
    public FractionNumber reciprocal(FractionNumber original){
        return new FractionNumber().setDenominator(original.getNumerator())
                .setNumerator(original.getDenominator());
    }

    /**
     * 规范化分数：
     * 1）分子分母有最大公约数
     * 2）分子为0
     * @param fractionNumber
     * @return
     */
    private FractionNumber normalizeFraction(FractionNumber fractionNumber) {
        long gcd = GCD.gcd1(fractionNumber.denominator, fractionNumber.numerator);
        FractionNumber normalizedFractionNumber = fractionNumber.clone();
        if (gcd == 0) {
            return normalizedFractionNumber.setDecimal(new BigDecimal(0));
        }
        if(gcd != 1){
            normalizedFractionNumber.setNumerator(fractionNumber.numerator / gcd)
                    .setDenominator(fractionNumber.denominator / gcd);
        }
        return normalizedFractionNumber;
    }

    public void calcDecimal(){
        BigDecimal decimal = new BigDecimal(this.numerator)
                .divide(new BigDecimal(this.denominator), 2 , BigDecimal.ROUND_HALF_UP);
        this.setDecimal(decimal);
    }

    @Override
    public FractionNumber clone(){
        return BeanUtil.convertObjectByCopyProperties(this, FractionNumber.class);
    }

}
