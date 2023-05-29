package com.codesignal.test;

public class MinimalMoves {

    public int test()
    {
        int a[] = {-1000, 0, -2, 0};
        int temp = a[0];
        int count = 0;
        for(int i=0;i<a.length;i++)
        {
            if(i<a.length-1)
            {
                if(temp>a[i+1])
                {
                    int diff=temp-a[i+1]+1;
                    temp=a[i+1]+diff;
                    count=count+diff;
                }
                else
                {
                    temp=a[i+1];
                }
            }
        }
        return count;
    }
}
