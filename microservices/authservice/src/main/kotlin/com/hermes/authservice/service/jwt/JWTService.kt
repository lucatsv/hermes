package com.hermes.authservice.service.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.io.Serializable
import java.util.*
import java.util.function.Function


@Component
class JWTService : Serializable  {

    @Value("\${jwt.secret}")
    private lateinit var secret : String;

    @Value("\${jwt.expirationInMinutes}")
    private lateinit var expirationInMinutesStr : String;
    fun expirationTimeInMiliseconds(): Long {
       return expirationInMinutesStr.toLong() * 60 * 1000;
    }

    //retrieve username from jwt token
    fun getUsernameFromToken(token: String?): String {
        return getClaimFromToken(token, Function<Claims, String> { obj: Claims -> obj.getSubject() })
    }

    //retrieve expiration date from jwt token
    fun getExpirationDateFromToken(token: String?): Date {
        return getClaimFromToken(token,
            Function<Claims, Date> { obj: Claims -> obj.getExpiration() })
    }

    fun <T> getClaimFromToken(token: String?, claimsResolver: Function<Claims, T>): T {
        val claims: Claims = getAllClaimsFromToken(token)
        return claimsResolver.apply(claims)
    }

    //for retrieveing any information from token we will need the secret key
    private fun getAllClaimsFromToken(token: String?): Claims {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody()
    }

    //check if the token has expired
    private fun isTokenExpired(token: String?): Boolean {
        val expiration = getExpirationDateFromToken(token)
        return expiration.before(Date())
    }

    //generate token for user
    fun generateToken(userDetails: UserDetails): String {
        val claims: Map<String, Any> = HashMap()
        return doGenerateToken(claims, userDetails.getUsername())
    }

    private fun doGenerateToken(claims: Map<String, Any>, subject: String): String {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + expirationTimeInMiliseconds()))
            .signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, secret).compact()
    }

    //validate token
    fun validateToken(token: String?, userDetails: UserDetails): Boolean {
        val username = getUsernameFromToken(token)
        return username == userDetails.getUsername() && !isTokenExpired(token)
    }


}