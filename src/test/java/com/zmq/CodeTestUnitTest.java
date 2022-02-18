package com.zmq;


import org.junit.Test;
import static org.junit.Assert.*;
public class CodeTestUnitTest {

    @Test
    public void testSolution1(){

        String str1 = CodeTest.solution1(null);
        String str2 = CodeTest.solution1("aa");
        String str3 = CodeTest.solution1("aaa");
        String str4 = CodeTest.solution1("aaaabc");
        String str5 = CodeTest.solution1("aabbbbb");
        String str6 = CodeTest.solution1("aabbbaccddee");
        assertEquals(str1,null);
        assertEquals(str2,"aa");
        assertEquals(str3,"");
        assertEquals(str4,"bc");
        assertEquals(str5,"aa");
        assertEquals(str6,"ccddee");

    }

    @Test
    public void testSolution2(){

        String str1 = CodeTest.solution2(null);
        String str2 = CodeTest.solution2("aa");
        String str3 = CodeTest.solution2("aaa");
        String str4 = CodeTest.solution2("aaaabc");
        String str5 = CodeTest.solution2("aabbbbb");
        String str6 = CodeTest.solution2("aabbbaccddee");
        assertEquals(str1,null);
        assertEquals(str2,"aa");
        assertEquals(str3,"");
        assertEquals(str4,"bc");
        assertEquals(str5,"");
        assertEquals(str6,"ccddee");
    }
}
