package com.st.w4y.util;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * Created by ruantianbo on 2017/11/9.
 */
public class SecurityUtil {

    public static String eccryptMD5(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            return base64en.encode(md5.digest(str.getBytes("utf-8")));
        }catch (NoSuchAlgorithmException ex){
            ex.printStackTrace();
            return str;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }


}
