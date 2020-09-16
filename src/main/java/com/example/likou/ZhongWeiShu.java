package com.example.likou;

import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @version V1.0
 * @Description
 * @Author sunpeng93
 * @Date 2020/9/16
 */
public class ZhongWeiShu {
    public static void main(String[] args) {
        Integer[] a = {1,3,5};
        Integer[] b = {2,4,7};
        getNumber(a,b);
    }

    private static double getNumber(Integer[] arr1, Integer[] arr2){
        double medianNumber = 0;
        List<Integer> num1 = new ArrayList(Arrays.asList(arr1));
        num1.addAll(Arrays.asList(arr2));
        //排序
        num1.stream().sorted(Comparator.comparing(Integer::intValue));

        int listSize = num1.size();
        if(listSize/2 == (listSize-1)/2){
            medianNumber = (double)num1.get(listSize/2);
        }else{
            int a = num1.get(listSize/2);
            System.out.println(listSize/2);
            System.out.println(num1.get(listSize/2));
            int b = num1.get((listSize-1)/2);
            medianNumber = new BigDecimal((a + b)/2).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
        }
        System.out.println(medianNumber);
        return medianNumber;
    }
}
