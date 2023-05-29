package com.codesignal.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CheckArrayIsIdentical {

    boolean checkIfTrue()
    {
        // int[] a = {1 , 2 , 1 , 2};
        // int[] b = {2 , 2 , 1 , 1};

        int[] a = {1 , 1 , 4};
        int[] b = {1 , 2 , 3};
        if (Arrays.equals(a , b)) return true;
        List<Integer> aList = Arrays.stream(a).mapToObj(Integer::valueOf).collect(Collectors.toList());
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) continue;
            else {
                int bloc = aList.indexOf(b[i]);
                int temp = aList.get(i);
                aList.set(i , b[i]);
                aList.set(bloc , temp);
                int[] primitive = aList.stream().mapToInt(Integer::intValue).toArray();
                if (Arrays.equals(primitive , b)) return true;
                else {
                    aList = Arrays.stream(a).mapToObj(Integer::valueOf).collect(Collectors.toList());
                    continue;
                }

            }

        }
        return false;

    }


    public boolean checkIfTrueOptimized()
    {
        int[] a = {1 , 2 , 1 , 2 , 2 , 1};
        int[] b = {2 , 2 , 1 , 1 , 2 , 1};
        if (Arrays.equals(a , b)) return true;
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) continue;
            else {
                int matchValue = b[i];
                int bLocation = IntStream.range(0 , a.length)
                        .filter(j -> matchValue == a[j])
                        .findFirst() // first occurrence
                        .orElse(-1);
                if (bLocation == -1) {
                    return false;
                }
                int bloc = a[bLocation];
                int temp = c[i];
                c[i] = b[i];
                c[bloc] = temp;
                if (Arrays.equals(c , b)) return true;
                else {
                    int temp1 = c[i];
                    c[i] = c[bloc];
                    c[bloc] = temp1;
                    continue;
                }

            }

        }
        return false;
    }


    public boolean SimpleSolution()
    {
        int[] a = {1 , 2 , 2};
        int[] b = {2 , 1 , 1};
        if (Arrays.equals(a , b))
            return true;
        int differenceCount = 0;
        int[] diffArray = new int[2];
        for (int i = 0; i < a.length; i++) {
            if (differenceCount == 2)
                return false;
            if (a[i] == b[i]) continue;
            else {
                diffArray[differenceCount] = i;
                differenceCount++;
            }
        }
        return (a[diffArray[0]] == b[diffArray[1]]) && (a[diffArray[1]] == b[diffArray[0]]);
    }
}
