package com.andregpereira.challenges.incloo.inclooapi.cross.security;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

@RequiredArgsConstructor
public enum Role implements GrantedAuthority {
    ADMIN(Map.of(HttpMethod.GET, Set.of("/**"), HttpMethod.POST, Set.of("/**"), HttpMethod.PUT, Set.of("/**"),
            HttpMethod.DELETE, Set.of("/**"), HttpMethod.PATCH, Set.of("/**"))),
    USER(Map.of(HttpMethod.GET, Set.of("/usuarios/{id}", "/vagas/**", "/candidaturas/**"), HttpMethod.POST,
            Set.of("/candidaturas/**"), HttpMethod.PUT, Set.of("/usuarios/**"), HttpMethod.PATCH,
            Set.of("/usuarios/**", "/auth/**"), HttpMethod.DELETE, Set.of("/usuarios/{id}"))),
    ANONYMOUS(Map.of(HttpMethod.GET, Set.of("/vagas/**"), HttpMethod.POST,
            Set.of("/usuarios/**", "/auth/usuario", "/auth/login")));

    private final Map<HttpMethod, Set<String>> permissions;

    public static Role getRole(String name) {
        return Stream.of(values()).filter(r -> r.name().equalsIgnoreCase(name)).findFirst().orElseGet(() -> ANONYMOUS);
    }

    public Set<String> getPermissions(HttpMethod method) {
        return permissions.getOrDefault(method, Collections.emptySet());
    }

    @Override
    public String getAuthority() {
        return this.toString();
    }
}
