package com.perfios.bootcamp.ecomwebsite.configuration;

import com.perfios.bootcamp.ecomwebsite.beans.User;
import com.perfios.bootcamp.ecomwebsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class GoogleOAuth2Config  implements AuthenticationSuccessHandler {

    @Autowired
    UserRepository userRepository;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    /**
     * This method helps to authenticate through Google account if user account exist in the database then it will fetch that account
     * otherwise it will fetch the data from Google account.
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param authentication ==> It will give the principal details
     *
     *                     principal ==> Currently Logged in User
     *
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        String email = token.getPrincipal().getAttributes().get("email").toString();
        if(!userRepository.findByEmailId(email).isPresent()){
            User user = new User();
            user.setUserName(token.getPrincipal().getAttributes().get("given_name").toString());
            user.setEmailId(email);
        //    user.setPassword(token.getPrincipal().getAttributes().get("password").toString());
            user.setRoles("ROLE_USER");
            user.setActive(true);
            userRepository.save(user);
        }
        redirectStrategy.sendRedirect(httpServletRequest,httpServletResponse,"/home");
    }
}
