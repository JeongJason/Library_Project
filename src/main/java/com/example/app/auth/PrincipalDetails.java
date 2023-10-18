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
@NoArgsConstructor
public class PrincipalDetails implements UserDetails {

    private UserDTO dto;

    public PrincipalDetails(UserDTO dto) {
        this.dto = dto;
    }

    //user에 대한 getter 메소드 추가
    public void setDto(UserDTO dto) { this.dto = dto; }

    public String getUserId() { return dto.getUserId(); }

    public String getUserPw() { return dto.getUserPw(); }

    public String getActualUserName() { return dto.getUserName(); }

    public String getUserEmail() {
        return dto.getUserEmail();
    }

    public String getUserBirth() {
        return dto.getUserBirth();
    }

    public String getUserEmailPrefix(){ return dto.getEmailPrefix();}

    public String getUserEmailDns(){ return dto.getEmailDns();}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(new GrantedAuthority(){
            @Override
            public String getAuthority() {
                if(dto.getUserRole() == "ROLE_USER")
                    return "ROLE_USER";
                else
                    return "ROLE_ADMIN";
            }
        } );

        return collection;

    }

    @Override
    public String getPassword() {
        return dto.getUserPw();
    }

    @Override
    public String getUsername() {
        return dto.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
