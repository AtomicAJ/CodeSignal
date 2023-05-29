package com.codesignal.test;

import java.util.HashMap;
import java.util.Map;

public class PalindromeCheck {

    public boolean test()
    {
        String inputString ="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabc";
        Map<Character,Integer> map = new HashMap<>();
        for(char c:inputString.toCharArray())
        {
            if(!map.containsKey(c))
            {
                map.put(c, 1);
            }
            else
            {
                map.put(c,map.get(c)+1);
            }
        }
        int falseCount=0;
        for(Character c:map.keySet())
        {
            if(falseCount>1)
                return false;
            if(map.get(c)%2!=0)
            {
                falseCount++;
            }
        }
        if(falseCount>1)
            return false;
        return true;
    }
}
