package com.hikvision.utils;

import java.util.Formatter;

/**
 * Created by xiongyou on 2018/8/14.
 */
public class Byte2Hex {
    /**
     *
     * 字节转换为 16 进制字符串
     *
     * @param b
     *            字节
     * @return
     */
    public static String byte2Hex(byte b) {

        String hex = Integer.toHexString(b);
        if (hex.length() > 2) {
            hex = hex.substring(hex.length() - 2);
        }
        while (hex.length() < 2) {
            hex = "0" + hex;
        }
        return hex;
    }

    /**
     *
     * 字节数组转换为 16 进制字符串
     *
     * @param bytes
     *            字节数组
     * @return
     */
    public static String byte2Hex(byte[] bytes) {

        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x" , b);
        }
        String hash = formatter.toString();
        formatter.close();
        return hash;
    }
}
