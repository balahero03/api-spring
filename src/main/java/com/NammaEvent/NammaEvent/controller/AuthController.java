package com.NammaEvent.NammaEvent.controller;

import com.NammaEvent.NammaEvent.auth.CustomUserDetailsService;
import com.NammaEvent.NammaEvent.auth.JwtUtil;
import com.NammaEvent.NammaEvent.model.AuthResponce;
import com.NammaEvent.NammaEvent.model.RefreshAuth;
import com.NammaEvent.NammaEvent.model.customerAuthBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/customer/login")
    public ResponseEntity<?>  createAuthenticationToken(@RequestBody customerAuthBody customerAuthBody) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customerAuthBody.getcustomeremailid(),customerAuthBody.getcustomerpassword()));
        } catch (Exception e) {
            throw new Exception("INCORRECT USERNAME OR PASSWORD" + e);
        }

        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(customerAuthBody.getcustomeremailid());
        final String accessToken = jwtUtil.GenerateAccessToken(userDetails);
        final String refreshToken = jwtUtil.GenerateRefreshToken(userDetails);

        return ResponseEntity.ok(new AuthResponce(accessToken,refreshToken));
    }

    @PostMapping("customer/refresh")
    public ResponseEntity<?> RefreshAuthenticationToken(@RequestBody RefreshAuth refreshAuth){
        String username = jwtUtil.extractUserName(refreshAuth.getRefreshToken());
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

        if(jwtUtil.validateToken(refreshAuth.getRefreshToken(), userDetails)){
            String accessToken = jwtUtil.GenerateAccessToken(userDetails);
            return ResponseEntity.ok(new AuthResponce(accessToken,refreshAuth.getRefreshToken()));
        }
        else {
            return ResponseEntity.badRequest().body("INVALID REFRESH TOKEN");
        }
    }
}
