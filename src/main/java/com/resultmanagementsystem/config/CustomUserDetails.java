package com.resultmanagementsystem.config;

import com.resultmanagementsystem.entity.CustomUser;
import com.resultmanagementsystem.entity.Teacher;
import com.resultmanagementsystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private String id;
    private String password;
    private List<GrantedAuthority> roles;

    public CustomUserDetails(CustomUser user){
        this.id=user.getUserId();
        this.password= user.getPassword();
        this.roles= Arrays.stream(user.getRoles()).map(SimpleGrantedAuthority::new).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return id;
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
