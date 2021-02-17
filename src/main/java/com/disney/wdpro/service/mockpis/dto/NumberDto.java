package com.disney.wdpro.service.mockpis.dto;

import com.disney.wdpro.service.mockpis.entity.FractionNumber;
import lombok.Data;

/**
 * @author tengx009
 * @className NumberDto
 * @description
 * @date 2/16/21 2:26 PM
 */
@Data
public class NumberDto {

    private long numerator1;

    private long denominator1;

    private long numerator2;

    private long denominator2;

    private String operation;
}
