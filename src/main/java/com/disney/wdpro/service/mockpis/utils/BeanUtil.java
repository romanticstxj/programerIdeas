package com.disney.wdpro.service.mockpis.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.FatalBeanException;

import java.util.List;

/**
 * @author tengx009
 * @className BeanUtils
 * @description This class wraps spring BeanUtils to elegantly do bean copy
 * @date 10/30/20 5:56 PM
 */
public class BeanUtil {

    private BeanUtil() {}
	
	/**
     * To avoid inclusion of springframework package
     *
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target) {
        if (source != null && target != null) {
            org.springframework.beans.BeanUtils.copyProperties(source, target);
        }

    }

    public static <T> T convertObjectByCopyProperties(Object source, Class<T> cls)  {
        if (cls == null) {
            throw new IllegalArgumentException("Class param cannot be null");
        }
        T convertedObject;
        try{
            if (source == null){
                return cls.newInstance();
            }
            convertedObject = cls.newInstance();
            BeanUtils.copyProperties(source,convertedObject);
        }catch (IllegalAccessException | InstantiationException e ){
            throw new RuntimeException("convert object exception", e);
        }
        return convertedObject;
    }

    public static void copyProperties(Object source, Object target, String... ignoreProperties) {
        if (source != null && target != null) {
            org.springframework.beans.BeanUtils.copyProperties(source, target, ignoreProperties);
        }
    }
    
    /**
     * copy list
     * Using for instead of foreach
     */
    public static <T, E> void copyList(List<T> source, List<E> target, Class<E> targetClass) {
        copyList(source,target,targetClass,(String[]) null);
    }

    public static <T, E> void copyList(List<T> source, List<E> target, Class<E> targetClass,String... ignoreProperties) {
        if (source != null && target != null) {
            for (int i = 0; i < source.size(); i++) {
                Object object = source.get(i);
                try {
                    if (object != null) {
                        E instance = targetClass.newInstance();
                        org.springframework.beans.BeanUtils.copyProperties(object,instance,ignoreProperties);
                        target.add(instance);
                    }
                } catch (Exception e) {
                    throw new FatalBeanException("Could not copy property from source to target", e);
                }
            }
        }
    }
}
