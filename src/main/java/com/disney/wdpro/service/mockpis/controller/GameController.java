package com.disney.wdpro.service.mockpis.controller;

import com.disney.wdpro.service.mockpis.dto.NumberDto;
import com.disney.wdpro.service.mockpis.entity.FractionNumber;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author tengx009
 * @className GameController
 * @description
 * @date 2/15/21 4:16 PM
 */
@RestController
@RequestMapping("/game")
public class GameController {

    @Resource(name = "operationMap")
    private Map<String, BiFunction<FractionNumber, FractionNumber, FractionNumber>> operationMap;

    @PostMapping("/number")
    public FractionNumber number(@RequestBody NumberDto numberDto){
        System.out.println(numberDto);
        FractionNumber fractionNumber1 = new FractionNumber().setNumerator(numberDto.getNumerator1())
                .setDenominator(numberDto.getDenominator1());
        FractionNumber fractionNumber2 = new FractionNumber().setNumerator(numberDto.getNumerator2())
                .setDenominator(numberDto.getDenominator2());
        String operation = numberDto.getOperation();
        BiFunction<FractionNumber, FractionNumber, FractionNumber> oprtFunc = operationMap.get(operation.toLowerCase().trim());
        FractionNumber fractionNumber3 = oprtFunc.apply(fractionNumber1, fractionNumber2);
        return fractionNumber3;
    }
}
