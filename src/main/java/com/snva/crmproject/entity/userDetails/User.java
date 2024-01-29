package com.snva.crmproject.entity.userDetails;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @PrimaryKeyJoinColumn
    @JsonManagedReference
    private UserPersonalDetails userPersonalDetails;

    private String username;
    private String password;
    private String role;

    @Column(name = "account_non_locked")
    private boolean accountNonLocked;

    public User() {
        super();
    }

    public User(long id, String username, String role, boolean accountNonLocked) {
        super();
        this.id = id;
        this.username = username;
        this.role = role;
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        list.add(new SimpleGrantedAuthority(role));
        return list;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public UserPersonalDetails getUserPersonalDetails() {
        return userPersonalDetails;
    }

    public void setUserPersonalDetails(UserPersonalDetails userPersonalDetails) {
        this.userPersonalDetails = userPersonalDetails;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @JsonValue
    public Map<String, Object> toJson() {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("id", id);
        jsonMap.put("username", username);
        jsonMap.put("password", password);
        jsonMap.put("role", role);
        jsonMap.put("account_non_blocked", accountNonLocked);
        jsonMap.put("userPersonalDetails", userPersonalDetails);
        return jsonMap;
    }

    @Override
    public String toString() {
        return "User{" +
                "ic=" + id +
                ", userPersonalDetails=" + userPersonalDetails +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", accountNonLocked=" + accountNonLocked +
                '}';
    }
}
