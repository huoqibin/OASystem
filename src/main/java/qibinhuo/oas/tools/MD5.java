package qibinhuo.oas.tools;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * create by huoqibin at 2019/1/27
 * MD5加密工具类
 */
public class MD5 {

    public static String encrypt_MD5(String str) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes());
        return new BigInteger(1,md.digest()).toString(16);
    }
}

