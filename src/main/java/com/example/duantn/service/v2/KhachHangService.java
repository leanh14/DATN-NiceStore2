package com.example.duantn.service.v2;

import com.example.duantn.model.KhachHang;
import com.example.duantn.record.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface KhachHangService extends UserDetailsService {
    KhachHang findByUsername(String username);

    KhachHang register(RegisterRequest model);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
