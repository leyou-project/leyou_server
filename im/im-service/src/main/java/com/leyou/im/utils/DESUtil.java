/**
 * 作者：刘时明
 * 时间：2019/11/7-18:22
 * 作用：
 */
package com.leyou.im.utils;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class DESUtil
{
    /**
     * CFB
     */
    public static final String CFB = "CFB";

    /**
     * OFB
     */
    public static final String OFB = "OFB";

    /**
     * CBC
     */
    public static final String CBC = "CBC";

    /**
     * iv向量
     */
    private static final byte[] DESIV = {(byte) 0xCE, (byte) 0x35, (byte) 0x5,
            (byte) 0xD, (byte) 0x98, (byte) 0x91, (byte) 0x8, (byte) 0xA};

    /**
     * AlgorithmParameterSpec
     */
    private static AlgorithmParameterSpec IV = null;

    /**
     * SHA1PRNG
     */
    private static final String SHA1PRNG = "SHA1PRNG";

    /**
     * DES默认模式
     */
    private static final String DES = "DES";

    /**
     * CBC加密模式
     */
    private static final String DES_CBC_PKCS5PADDING = "DES/CBC/PKCS5Padding";

    /**
     * OFB加密模式
     */
    private static final String DES_OFB_PKCS5PADDING = "DES/OFB/PKCS5Padding";

    /**
     * CFB加密模式
     */
    private static final String DES_CFB_PKCS5_PADDING = "DES/CFB/PKCS5Padding";

    /**
     * 加密模式
     */
    private static final int ENCRYPT_MODE = 1;

    /**
     * 解密模式
     */
    private static final int DECRYPT_MODE = 2;


    /**
     * 字符串des加密
     *
     * @param data        需要加密的字符串
     * @param encryptType 加密模式 (ECB/CBC/OFB/CFB)
     * @return 加密结果
     * @throws Exception 异常
     * @author sucb
     * @date 2017年3月2日下午7:47:37
     */
    public static String encrypt(String data, String encryptType, String key) throws Exception
    {
        Cipher cipher = getPattern(encryptType, ENCRYPT_MODE, getKey(key));
        byte[] pasByte = cipher.doFinal(data.getBytes("UTF-8"));
        return Base64.encodeBase64String(pasByte);
    }

    /**
     * 字符串des解密
     *
     * @param data        需要解密的字符串
     * @param decryptType 解密模式 (ECB/CBC/OFB/CFB)
     * @return 解密结果
     * @throws Exception 异常
     * @author sucb
     * @date 2017年3月2日下午7:48:21
     */
    public static String decrypt(String data, String decryptType, String key) throws Exception
    {
        Cipher cipher = getPattern(decryptType, DECRYPT_MODE, getKey(key));
        byte[] pasByte = cipher.doFinal(Base64.decodeBase64(data));
        return new String(pasByte, "UTF-8");
    }

    /**
     * 初始化cipher
     *
     * @param type       加密/解密模式 (ECB/CBC/OFB/CFB)
     * @param cipherMode cipher工作模式 1：加密； 2：解密
     * @return cipher
     * @throws Exception 异常
     * @author sucb
     * @date 2017年3月2日下午7:49:16
     */
    private static Cipher getPattern(String type, int cipherMode, Key key) throws Exception
    {
        Cipher cipher;
        switch (type)
        {
            case CBC:
                cipher = Cipher.getInstance(DES_CBC_PKCS5PADDING);
                cipher.init(cipherMode, key, IV);
                break;
            case OFB:
                cipher = Cipher.getInstance(DES_OFB_PKCS5PADDING);
                cipher.init(cipherMode, key, IV);
                break;
            case CFB:
                cipher = Cipher.getInstance(DES_CFB_PKCS5_PADDING);
                cipher.init(cipherMode, key, IV);
                break;
            default:
                cipher = Cipher.getInstance(DES);
                cipher.init(cipherMode, key);
                break;
        }
        return cipher;
    }

    private static Key getKey(String secretKey)
    {
        try
        {
            SecureRandom secureRandom = SecureRandom.getInstance(SHA1PRNG);
            secureRandom.setSeed(secretKey.getBytes());
            KeyGenerator generator = null;
            try
            {
                generator = KeyGenerator.getInstance(DES);
            } catch (NoSuchAlgorithmException e)
            {
            }
            generator.init(secureRandom);
            IV = new IvParameterSpec(DESIV);
            return generator.generateKey();
        } catch (Exception e)
        {
            throw new RuntimeException("Error in getKey(String secretKey), Cause: " + e);
        }
    }
}
