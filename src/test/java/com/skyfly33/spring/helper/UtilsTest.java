package com.skyfly33.spring.helper;

import org.apache.http.util.EncodingUtils;

/**
 * Created by donghoon on 15. 9. 3..
 */
public class UtilsTest {

    public static void main(String[] args) {
        String example = "byte test";
        byte[] bytes = example.getBytes();
        byte[] encoded = EncodingUtils.getBytes(example, "utf-8");

        System.out.println("Text: " + example);
        System.out.println("Text byte Format: " + bytes);
        System.out.println("Text byte Format: " + bytes.toString());
        System.out.println("Text byte encoding Format: " + encoded.toString());

        String fromBytes = new String(bytes);
        System.out.println("fromBytes: " + fromBytes);
    }
}
