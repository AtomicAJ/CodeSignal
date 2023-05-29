package com.codesignal.test;

public class IpV4Address {

    public boolean test()
    {
        String inputString= "172.16.254.1";
        String[] spiltStrings= inputString.split("\\.");
        if(spiltStrings.length!=4)
        {
            return false;
        }
        for(String s:spiltStrings)
        {
            int n=Integer.valueOf(s);
            if(n<0 || n>255)
            {
                return false;
            }
        }
        return true;
    }
}
