package com.skyfly33.spring.helper;

import org.springframework.stereotype.Component;

/**
 * Created by donghoon on 15. 8. 31..
 */
@Component
public class Utils {
    public void printTitle(String title) {
        System.out.println("\n\n");
        System.out.println("[" + title + "]");
    }
}
