package com.example.app.auth;

import com.example.app.domain.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrincipalDetails implements UserDetails, OAuth2User {

    private UserDTO userDTO;

    private Map<String, Object> attributes;
    private String accessToken;

    public PrincipalDetails(UserDTO userDTO) {
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList();

        collection.add(new GrantedAuthority(){
            @Override
            public String getAuthority() {
                return userDTO.getUserRole();
            }
        } );
        return collection;
    }

    @Override
    public String getPassword() {
        return userDTO.getUserPw();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return userDTO.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
}
