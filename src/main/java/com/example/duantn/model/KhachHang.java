package com.example.duantn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Table(name = "KhachHang")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class KhachHang extends BaseModel implements UserDetails {
    @Column(name = "Ma")
    private String ma;

    @Column(name = "HoTen")
    private String hoVaTen;

    @Column(name = "TaiKhoan")
    private String taiKhoan;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "GioiTinh")
    private Integer gioiTinh;

    @Column(name = "SoDT")
    private String soDT;

    @Column(name = "Email")
    private String email;

    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
    @JoinTable(name = "khachhang_role",
        joinColumns = @JoinColumn(name = "khachhang_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleList = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role : roleList) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return matKhau;
    }

    @Override
    public String getUsername() {
        return taiKhoan;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static KhachHang getContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            if (authentication.getPrincipal() instanceof KhachHang) {
                return (KhachHang) authentication.getPrincipal();
            }
        }
        throw new RuntimeException("Bạn chưa đăng nhập");
    }

    public static UUID getContextId() {
        KhachHang khachHang = getContext();
        return khachHang.getId();
    }
}
