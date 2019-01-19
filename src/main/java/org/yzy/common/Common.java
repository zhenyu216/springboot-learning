package org.yzy.common;

import java.util.UUID;

/**
 * @Author: zhenyu
 * @Date: 2019/1/19 12:06
 */
public class Common {
    public static String uuidUtil(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
