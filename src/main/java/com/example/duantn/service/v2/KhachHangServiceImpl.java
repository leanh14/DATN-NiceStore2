package com.example.duantn.service.v2;

import com.example.duantn.constant.UserConst;
import com.example.duantn.model.KhachHang;
import com.example.duantn.model.Role;
import com.example.duantn.record.RegisterRequest;
import com.example.duantn.repository.KhachHangRepository;
import com.example.duantn.repository.RoleRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class KhachHangServiceImpl implements KhachHangService {
    private final KhachHangRepository khachHangRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepo roleRepo;

    @Override
    public KhachHang findByUsername(String username) {
        return khachHangRepository.findByUsername(username);
    }

    @Override
    public KhachHang register(RegisterRequest model) {
        KhachHang khachHang = new KhachHang();
        khachHang.setTaiKhoan(model.getUsername());
        khachHang.setMatKhau(passwordEncoder.encode(model.getPassword()));
        khachHang.setEmail(model.getEmail());
        khachHang.setSoDT(model.getPhone());
        Role role = roleRepo.findByName(UserConst.ROLE_USER);
        khachHang.setRoleList(Set.of(role));
        return khachHangRepository.save(khachHang);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return khachHangRepository.findByUsername(username);
    }
}
