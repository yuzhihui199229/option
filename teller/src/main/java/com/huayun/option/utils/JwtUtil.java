package com.huayun.option.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = "huayun";

    /**
     * 过期时间为15分钟
     */
    private static final long EXPIRE_TIME = 15 * 60 * 1000;

    public static String sign(String userName) {
        //过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        //私钥及加密算法
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        //设置头部信息
        Map<String,Object> header=new HashMap<>(2);
        header.put("type", "JWT");
        header.put("algorithm","HMAC256");
        //生成签名
        return JWT.create()
                .withHeader(header)
                .withClaim("userName",userName)
                .withExpiresAt(date)
                .sign(algorithm);
    }

    /**
     * 校验token是否正确
     * @param token
     * @return
     */
    public static boolean verify(String token) {
        try {
            //私钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //token解密
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            jwtVerifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
