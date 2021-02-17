package com.disney.wdpro.service.mockpis.entity;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author tengx009
 * @className FractionNumberTest
 * @description
 * @date 2/17/21 11:05 AM
 */
public class FractionNumberTest {

    @Test
    public void testAdd(){
        FractionNumber fractionNumber = new FractionNumber().setNumerator(2).setDenominator(4);
        FractionNumber fractionNumber1 = new FractionNumber().setNumerator(3).setDenominator(4);
        FractionNumber fractionNumber2 = fractionNumber.add(fractionNumber1);
        Assert.assertEquals(5, fractionNumber2.getNumerator());
        Assert.assertEquals(4, fractionNumber2.getDenominator());

    }

    @Test
    public void testAddNormalized(){
        FractionNumber fractionNumber = new FractionNumber().setNumerator(1).setDenominator(4);
        FractionNumber fractionNumber1 = new FractionNumber().setNumerator(1).setDenominator(4);
        FractionNumber fractionNumber2 = fractionNumber.add(fractionNumber1);
        Assert.assertEquals(1, fractionNumber2.getNumerator());
        Assert.assertEquals(2, fractionNumber2.getDenominator());
    }

    @Test
    public void testSubNormalized(){
        FractionNumber fractionNumber = new FractionNumber().setNumerator(1).setDenominator(4);
        FractionNumber fractionNumber1 = new FractionNumber().setNumerator(1).setDenominator(4);
        FractionNumber fractionNumber2 = fractionNumber.subtract(fractionNumber1);
        Assert.assertEquals(0, fractionNumber2.getNumerator());
        Assert.assertEquals(4, fractionNumber2.getDenominator());
        Assert.assertEquals(new BigDecimal(0), fractionNumber2.getDecimal());
    }

    @Test
    public void testMulNormalized(){
        FractionNumber fractionNumber = new FractionNumber().setNumerator(2).setDenominator(4);
        FractionNumber fractionNumber1 = new FractionNumber().setNumerator(1).setDenominator(4);
        FractionNumber fractionNumber2 = fractionNumber.multiply(fractionNumber1);
        Assert.assertEquals(1, fractionNumber2.getNumerator());
        Assert.assertEquals(8, fractionNumber2.getDenominator());
    }

    @Test
    public void testDivNormalized(){
        FractionNumber fractionNumber = new FractionNumber().setNumerator(2).setDenominator(8);
        FractionNumber fractionNumber1 = new FractionNumber().setNumerator(4).setDenominator(8);
        FractionNumber fractionNumber2 = fractionNumber.divide(fractionNumber1);
        Assert.assertEquals(1, fractionNumber2.getNumerator());
        Assert.assertEquals(2, fractionNumber2.getDenominator());
    }
}
