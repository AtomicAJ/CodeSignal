package com.codesignal.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MinimimalJumps {

    int solution(int[] inputArray) {
        inputArray = new int[]{5 , 3 , 6 , 7 , 9};
        List<Integer> list = new ArrayList<>();
        List<Integer> inputList = Arrays.stream(inputArray).mapToObj(Integer::valueOf).collect(Collectors.toList());
        for (int i : inputArray) {
            int n = 2;
            while (n < i) {
                if (list.contains(i)) {
                    list.remove(Integer.valueOf(i));
                }
                if (!list.contains(n) && i % n != 0 && !inputList.contains(n)) {
                    list.add(n);
                } else if (list.contains(n) && i % n == 0) {
                    list.remove(Integer.valueOf(n));
                } n++;
            }
        } Collections.sort(list);
        return list.get(0);

    }
}
