package com.resultmanagementsystem.config;

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

    public CustomUserDetails(Teacher teacher){
        this.id=teacher.getId();
        this.password= teacher.getPassword();
        this.roles= Arrays.stream(teacher.getRoles()).map(SimpleGrantedAuthority::new).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println(roles);
        return roles;
    }

    @Override
    public String getPassword() {
        System.out.println(password);
        return password;
    }

    @Override
    public String getUsername() {
        System.out.println(id);
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
