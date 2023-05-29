package com.codesignal.test;

import java.util.*;

public class LevelFive {


    //After becoming famous, the CodeBots decided to move into a new building together. Each of the rooms has a different cost, and some of them are free, but there's a rumour that all the free rooms are haunted! Since the CodeBots are quite superstitious, they refuse to stay in any of the free rooms, or any of the rooms below any of the free rooms.
    //
    //Given matrix, a rectangular matrix of integers, where each value represents the cost of the room, your task is to return the total sum of all rooms that are suitable for the CodeBots (ie: add up all the values that don't appear below a 0).
    //
    //Example
    //
    //For
    //
    //matrix = [[0, 1, 1, 2],
    //          [0, 5, 0, 0],
    //          [2, 0, 3, 3]]
    //the output should be
    //solution(matrix) = 9.
    //ALso not any floor above should not have 0
    int MatrixSumGhost(int[][] matrix) {
        int sum=0;
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;
        Set<Integer> skipColumns = new HashSet<Integer>();
        for(int i=0;i<rowSize;i++)
        {
            for(int j=0;j<columnSize;j++)
            {
                if(matrix[i][j]==0)
                {
                    skipColumns.add(j);
                }
                if(i==0)
                {
                    sum = sum+matrix[i][j];
                }
                else if(!skipColumns.contains(j))
                {
                    sum = sum+matrix[i][j];
                }

            }
        }
        return sum;
    }



    //For s1 = "aabcc" and s2 = "adcaa", the output should be
    //solution(s1, s2) = 3.
    //
    //Strings have 3 common characters - 2 "a"s and 1 "c".

    int commonString(String s1, String s2) {

        Map<Character,Integer> firstStringMap = new HashMap<>();
        Map<Character,Integer> secondStringMap = new HashMap<>();
        int count=0;
        for(char c:s1.toCharArray())
        {
            if(!firstStringMap.containsKey(c))
            {
                firstStringMap.put(c, 1);
            }
            else
            {
                firstStringMap.put(c, firstStringMap.get(c)+1);
            }
        }

        for(char c:s2.toCharArray())
        {
            if(!secondStringMap.containsKey(c))
            {
                secondStringMap.put(c, 1);
            }
            else
            {
                secondStringMap.put(c, secondStringMap.get(c)+1);
            }
        }

        for(Character c:firstStringMap.keySet())
        {
            if(firstStringMap.get(c)>0 &&  Objects.nonNull(secondStringMap.get(c)) && secondStringMap.get(c)>0)
            {
                count=count+Math.min(firstStringMap.get(c), secondStringMap.get(c));
            }
        }
        return count;

    }



    //Ticket numbers usually consist of an even number of digits. A ticket number is considered lucky if the sum of the first half of the digits is equal to the sum of the second half.
    //
    //Given a ticket number n, determine if it's lucky or not.
    //
    //Example
    //
    //For n = 1230, the output should be
    //solution(n) = true;
    //For n = 239017, the output should be
    //solution(n) = false.

    boolean isLucky(int n) {

        String temp = Integer.toString(n);
        List<Integer> tempList = new ArrayList<>();
        for(char c:temp.toCharArray())
        {
            tempList.add(Character.getNumericValue(c));
        }
        int firstSum=0;
        int secondSum=0;
        for(int i=0;i<tempList.size();i++)
        {
            if(i<tempList.size()/2)
            {
                firstSum=firstSum+tempList.get(i);
            }
            else
            {
                secondSum=secondSum+tempList.get(i);
            }
        }

        if(firstSum==secondSum)
            return true;
        return false;

    }



//Some people are standing in a row in a park. There are trees between them which cannot be moved. Your task is to rearrange the people by their heights in a non-descending order without moving the trees. People can be very tall!
//
//Example
//
//For a = [-1, 150, 190, 170, -1, -1, 160, 180], the output should be
//solution(a) = [-1, 150, 160, 170, -1, -1, 180, 190].

    int[] solution(int[] a) {
        List<Integer> sortedPeople = new ArrayList<>();

        for(int n:a)
        {
            if(n==-1)
            {
                continue;
            }
            sortedPeople.add(n);
        }
        Collections.sort(sortedPeople);
        int counter=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==-1)
            {
                continue;
            }
            a[i]=sortedPeople.get(counter);
            counter++;
        }
        return a;
    }




}
