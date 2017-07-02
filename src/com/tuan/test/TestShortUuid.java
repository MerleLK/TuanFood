package com.tuan.test;

import com.tuan.comonMethod.GenerateShortUuid;

/** 测试UUID生成
 * Created by Administrator on 2017/7/2.
 */
public class TestShortUuid {
    public static void main(String[] args){
        GenerateShortUuid generateShortUuid = new GenerateShortUuid();
        String s = generateShortUuid.generateShortUuid();
        System.out.println(s);
    }

}
