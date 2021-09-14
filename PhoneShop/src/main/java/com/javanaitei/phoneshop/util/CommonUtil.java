package com.javanaitei.phoneshop.util;

import java.util.List;

public class CommonUtil {

    public static boolean isEmpty(List<?> list) {
        return list == null || list.size() == 0;
    }
}
