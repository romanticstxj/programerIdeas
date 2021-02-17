package com.disney.wdpro.service.mockpis.config;

import com.disney.wdpro.service.mockpis.entity.FractionNumber;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author tengx009
 * @className GameConfig
 * @description
 * @date 2/16/21 3:30 PM
 */
@Configuration
public class GameConfig {

    @Bean
    public Map<String, BiFunction<FractionNumber, FractionNumber, FractionNumber>> operationMap(){
        Map<String, BiFunction<FractionNumber, FractionNumber, FractionNumber>> operations = new HashMap<>();
        BiFunction<FractionNumber, FractionNumber, FractionNumber> addFunc = (f1, f2) -> f1.add(f2);
        BiFunction<FractionNumber, FractionNumber, FractionNumber> subtractFunc = (f1, f2) -> f1.subtract(f2);
        BiFunction<FractionNumber, FractionNumber, FractionNumber> multiplyFunc = (f1, f2) -> f1.multiply(f2);
        BiFunction<FractionNumber, FractionNumber, FractionNumber> divideFunc = (f1, f2) -> f1.divide(f2);
        operations.put("add", addFunc);
        operations.put("+", addFunc);
        operations.put("sub", subtractFunc);
        operations.put("-", subtractFunc);
        operations.put("mul", multiplyFunc);
        operations.put("*", multiplyFunc);
        operations.put("div", divideFunc);
        operations.put("/", divideFunc);

        return operations;
    }

}
