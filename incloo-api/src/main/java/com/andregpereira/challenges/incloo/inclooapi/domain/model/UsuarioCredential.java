package com.andregpereira.challenges.incloo.inclooapi.domain.model;

import com.andregpereira.challenges.incloo.inclooapi.cross.security.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCredential implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private Set<Role> authorities = new HashSet<>();
    private LocalDate createdDate;
    private LocalDate lastModifiedDate;
    private boolean enabled;

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

    public boolean isEnabled() {
        return true;
    }

}
