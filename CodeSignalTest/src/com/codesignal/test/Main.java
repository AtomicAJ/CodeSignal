package com.codesignal.test;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //LevelSeven levelSeven = new LevelSeven();
       // System.out.println(levelSeven.reverseParentheses("aj(it)h"));
        //System.out.println(solution());
	// write your code here


       // Paranthesis paranthesis = new Paranthesis();
       // System.out.println(paranthesis.reverseParanthesis("foo(barzab)blim"));

       // CheckArrayIsIdentical checkArrayIsIdentical = new CheckArrayIsIdentical();
       // System.out.println(checkArrayIsIdentical.SimpleSolution());

        //MinimalMoves minimalMoves = new MinimalMoves();
        //System.out.println(minimalMoves.test());

        //PalindromeCheck palindromeCheck = new PalindromeCheck();
        //System.out.println(palindromeCheck.test());

        //IpV4Address ipV4Address = new IpV4Address();
        //System.out.println(ipV4Address.test());

        MinimimalJumps minimimalJumps = new MinimimalJumps();
        System.out.println(minimimalJumps.solution(new int[]{}));
    }

    boolean palidrome(String inputString) {

        int left = 0;
        int right = inputString.length() - 1;
        while (left < right) {
            if (inputString.charAt(left) != inputString.charAt(right))
                return false;
            left++;
            right--;

        }
        return true;
    }

    //Given a year, return the century it is in. The first century spans from the year 1 up to and including the year 100, the second - from the year 101 up to and including the year 200, etc.
    //For year = 1905, the output should be
    //solution(year) = 20;
    //For year = 1700, the output should be
    //solution(year) = 17.
    int CenturyOfTheYear(int year) {
        int add = year % 100 > 0?1:0;
        return (year/100)+add ;

    }

    //Input statues = [6, 2, 3, 8]  expected arragement 2,3,4,5,6,7 so additional statues 3 (o/p)
    int StautuesOfSameSize(int[] statues) {

        Arrays.sort(statues);
        int value=0;
        for(int i=0;i<statues.length-1;i++)
        {
            value=value+statues[i+1]-statues[i]-1;
        }
        return value;

    }


    //Given an array of integers, find the pair of adjacent elements that has the largest product and return that product.
   //For inputArray = [3, 6, -2, -5, 7, 3], the output should be
    //solution(inputArray) = 21.
    int largestProduct(int[] inputArray) {

        int max=inputArray[0]*inputArray[1];
        for(int i=1;i<inputArray.length-1;i++)
        {
            int temp=inputArray[i]*inputArray[i+1];
            max = temp>max?temp:max;
        }
        return max;

    }


//Given a sequence of integers as an array, determine whether it is possible to obtain a strictly increasing sequence by removing no more than one element from the array.
//
//Note: sequence a0, a1, ..., an is considered to be a strictly increasing if a0 < a1 < ... < an. Sequence containing only one element is also considered to be strictly increasing.
//
//Example
//
//For sequence = [1, 3, 2, 1], the output should be
//solution(sequence) = false.
//
//There is no one element in this array that can be removed in order to get a strictly increasing sequence.
//
//For sequence = [1, 3, 2], the output should be
//solution(sequence) = true.
//
//You can remove 3 from the array to get the strictly increasing sequence [1, 2]. Alternately, you can remove 2 to get the strictly increasing sequence [1, 3].
    boolean IncresingArrayWithOneRemoval(int[] sequence) {
        if(sequence.length==1)
            return true;
        int n = sequence.length;
        int counter=0;
        int diff=0;
        for(int i=0;i<sequence.length-1;i++)
        {
            if(sequence[i]>=sequence[i+1])
            {
                counter++;
                if(counter>1)
                    return false;
                if(i>0 && i<(n-2) && sequence[i]>=sequence[i+2] && sequence[i-1]>=sequence[i+1])
                    return false;

            }
        }
        return true;

    }



}
