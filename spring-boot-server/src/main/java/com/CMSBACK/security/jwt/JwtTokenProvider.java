package com.CMSBACK.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class JwtTokenProvider
{
    public static String generateToken(String userName) throws Exception
    {
        Instant now = Instant.now();
        String jwtToken = Jwts.builder()
                .claim("name", userName).setSubject(userName)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(now))
                .setExpiration(new Date((new Date()).getTime() + 840000000))
                .signWith(SignatureAlgorithm.HS512, "bezKoderSecretKey")
                .compact();

        return jwtToken;
    }

    private static Key getPrivateKey() throws Exception
    {
        ClassLoader classLoader = JwtTokenProvider.class.getClassLoader();
        File file = new File(classLoader.getResource("private.key").getFile());
        byte[] rsaPrivateKeyArr = FileUtils.readFileToByteArray(file);
        String rsaPrivateKey = new String(rsaPrivateKeyArr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getMimeDecoder().decode(rsaPrivateKey));
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(keySpec);

    }

}
