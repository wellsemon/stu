package com;

import com.welleys.stu.basic.java.a04.collection.ArrayMain;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayMainTest {
    @Test
    public void testIntInit(){
        ArrayMain arrayMain = new ArrayMain();
        int[] arr = arrayMain.intInit();

        int[] intarr = new int[]{ 1,2,3,5,7,11,13,17,19,23,27, 29};
        for (int i = 0; i < intarr.length; i++) {
            Assert.assertEquals(arr[i], intarr[i]);
        }
    }
}