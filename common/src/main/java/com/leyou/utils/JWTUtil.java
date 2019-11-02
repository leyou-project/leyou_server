/**
 * 作者：刘时明
 * 时间：2019/11/2-16:19
 * 作用：
 */
package com.leyou.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JWTUtil
{
    private static final String secret = "com.leyou.project.20191102454545454545454545454545454545";
    private static final long outMillis = 2 * 60 * 60 * 1000;

    /**
     * 根据uid获取token
     *
     * @param uid
     * @return
     */
    public static String createJWT(Integer uid)
    {
        // 指定签名的时候使用的签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        // 生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        // payload
        Map<String, Object> claims = new HashMap<>();
        claims.put("uid", uid);

        // secret私钥
        String key = secret;

        // 签发人
        String subject = secret;

        // body
        JwtBuilder builder = Jwts.builder()
                // claims
                .setClaims(claims)
                // uuid避免重放攻击。
                .setId(UUID.randomUUID().toString())
                // jwt的签发时间
                .setIssuedAt(now)
                // 签发人
                .setSubject(subject)
                // 设置签名使用的签名算法和签名使用的秘钥
                .signWith(signatureAlgorithm, key);
        long expMillis = nowMillis + outMillis;
        Date exp = new Date(expMillis);
        //设置过期时间
        builder.setExpiration(exp);
        return builder.compact();
    }

    public static Claims parseJWT(String token)
    {
        // 签名秘钥，和生成的签名的秘钥一模一样
        String key = secret;
        // 得到DefaultJwtParser
        Claims claims = Jwts.parser()
                //设置签名的秘钥
                .setSigningKey(key)
                //设置需要解析的jwt
                .parseClaimsJws(token).getBody();
        return claims;
    }
}
