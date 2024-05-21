package com.iamjunhyeok.bulletinboardsystem.utils;

import lombok.extern.log4j.Log4j2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Log4j2
public class SHA256Util {

    private static final String ENCRYPTION_KEY = "SHA-256";

    public static String encryptSHA256(String str, String salt) {
        String SHA = null;
        MessageDigest md;
        try {
            // 1. SHA256 알고리즘 객체 생성
            md = MessageDigest.getInstance(ENCRYPTION_KEY);

            // 2. 비밀번호와 salt 합친 문자열에 SHA-256 적용
            md.update((str + salt).getBytes());
            byte[] byteData = md.digest();

            // 3. byte To String (10진수의 문자열로 변경)
            StringBuffer sb = new StringBuffer();
            for (byte byteDatum : byteData) {
                sb.append(String.format("%02x", byteDatum));
            }
            SHA = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            log.error("encryptSHA256 ERROR : {}", e.getMessage());
        }
        return SHA;
    }

    public static String getSalt() {
        // 1. Random, byte 객체 생성
        SecureRandom r = new SecureRandom();
        byte[] salt = new byte[20];

        // 2. 난수 생성
        r.nextBytes(salt);

        // 3. byte To String (10진수의 문자열로 변경)
        StringBuffer sb = new StringBuffer();
        for (byte b : salt) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
