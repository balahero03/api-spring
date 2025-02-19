package com.NammaEvent.NammaEvent.security;

import com.NammaEvent.NammaEvent.repository.CustomerRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtSecurityFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    private final CustomerRepository customerRepository;

    @Autowired
    public JwtSecurityFilter(JwtTokenProvider jwtTokenProvider, CustomerRepository customerRepository) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.customerRepository = customerRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String Token = request.getHeader("Authorization");

        if (Token != null && Token.startsWith("Bearer ")) {
            Token = Token.substring(7);
            String username = jwtTokenProvider.extractUsername(Token);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = customerRepository.loadUserByUsername(username);

                if (jwtTokenProvider.validateToken(token)) {
                    SecurityContextHolder.getContext().setAuthentication(
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities())
                    );
                }
            }
        }

        chain.doFilter(request, response);
    }

}
