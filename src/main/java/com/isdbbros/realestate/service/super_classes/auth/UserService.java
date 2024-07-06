package com.isdbbros.realestate.service.super_classes.auth;

import com.isdbbros.realestate.dto.auth.LoginResponse;
import com.isdbbros.realestate.model.auth.User;
import com.isdbbros.realestate.service.super_classes.CrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends CrudService<User, Long>, UserDetailsService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    String getUserameByRandomStringAndPublicKeyAndHash(String randomStr, String publicKey, String hash);

    ResponseEntity<LoginResponse> getLoginResponse(User user);

    ResponseEntity<LoginResponse> refreshAuthTokens(String refreshToken);
}
