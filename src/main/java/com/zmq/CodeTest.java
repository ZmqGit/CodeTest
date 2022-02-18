package com.zmq;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeTest {

    /**
     * @param str
     * @return newstr
     * For a given string that only contains alphabet characters a-z, if 3 or more consecutive
     * characters are identical, remove them from the string. Repeat this process until
     * there is no more than 3 identical characters sitting besides each other.
     * <p>
     * Example:
     * Input: aabcccbbad
     * Output:
     * -> aabbbad
     * -> aaad
     * -> d
     */
    public static String solution1(String str) {
        if (str == null || str.length() < 3) {
            return str;
        }
        StringBuilder resultBuilder = new StringBuilder(str + " ");
        int length = resultBuilder.length();
        C current = new C();
        for (int i = 0; i < length; i++) {
            Character c = resultBuilder.charAt(i);
            if (current.c == c) {
                current.num += 1;
            } else {
                if (current.num >= 3) {
                    resultBuilder.delete(i - current.num, i);
                    if (resultBuilder.length() > 3) {
                        //重置上下文
                        i = -1;
                        length = resultBuilder.length();
                        current.c = null;
                        current.num = 0;
                    } else {
                        return resultBuilder.toString().trim();
                    }
                } else {
                    current.c = c;
                    current.num = 1;
                }
            }
        }
        return resultBuilder.toString().trim();
    }

    /**
     * @param str
     * @return newstr
     * Instead of removing the consecutively identical characters, replace them with a
     * single character that comes before it alphabetically.
     * Example:
     * ccc -> b
     * bbb -> a
     * Input: abcccbad
     * Output:
     * -> abbbad, ccc is replaced by b
     * -> aaad, bbb is replaced by a
     * -> d
     */
    public static String solution2(String str) {
        if (str == null || str.length() < 3){
            return str;
        }
        StringBuilder resultBuilder = new StringBuilder(str+" ");
        int length = resultBuilder.length();
        C current = new C();
        for (int i=0; i<length; i++){
            Character c = resultBuilder.charAt(i);
            if (current.c == c){
                current.num += 1;
            }
            else{
                if (current.num>=3){
                    if (current.c == 'a') {
                        resultBuilder.delete(i - current.num, i);
                    }else {
                        resultBuilder.replace(i - current.num, i ,Character.toString((char)(current.c-1)));
                    }
                    if (resultBuilder.length()>3) {
                        //重置上下文
                        i = -1;
                        length = resultBuilder.length();
                        current.c = null;
                        current.num = 0;
                    }else {
                        return resultBuilder.toString().trim();
                    }
                }else {
                    current.c = c;
                    current.num = 1;
                }
            }
        }
        return resultBuilder.toString().trim();
    }
}
