package com.fly.pojo;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//MessageDigest.getInstance("MD5");//这句话里面的"MD5"的不同，当计算SHA1值时只需要将"MD5"改为"SHA1"就行。
public class HashUtil {
    public static void main(String[] args) {
        System.out.println("字符串的MD5值为：");
        System.out.println(MD5Util.md5("admin"));
        System.out.println(MD5Util.md5("123456"));
        System.out.println("hash算法字符串的MD5值为：");
        System.out.println(HashUtil.hash("admin", "MD5"));
        System.out.println(HashUtil.hash("123456", "MD5"));
        System.out.println("hash算法字符串的SHA1值为：");
        System.out.println(HashUtil.hash("admin", "SHA1"));
        System.out.println(HashUtil.hash("123456", "SHA1"));
    }

    /**
     * 计算字符串的hash值
     *
     * @param string    明文
     * @param algorithm 算法名
     * @return 字符串的hash值
     */
    public static String hash(String string, String algorithm) {
        if (string.isEmpty()) {
            return "";
        }
        MessageDigest hash = null;
        try {
            hash = MessageDigest.getInstance(algorithm);
            byte[] bytes = hash.digest(string.getBytes("UTF-8"));
            String result = "";
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 计算文件的hash值
     *
     * @param file      文件File
     * @param algorithm 算法名
     * @return 文件的hash值
     */
    public static String hash(File file, String algorithm) {
        if (file == null || !file.isFile() || !file.exists()) {
            return "";
        }
        FileInputStream in = null;
        String result = "";
        byte buffer[] = new byte[0124];
        int len;
        try {
            MessageDigest hash = MessageDigest.getInstance(algorithm);
            in = new FileInputStream(file);
            while ((len = in.read(buffer)) != -1) {
                hash.update(buffer, 0, len);
            }
            byte[] bytes = hash.digest();

            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}

