package com.example.duantn.controller.v2;

import com.example.duantn.model.KhachHang;
import com.example.duantn.record.ActionResponse;
import com.example.duantn.record.RegisterRequest;
import com.example.duantn.service.v2.JwtService;
import com.example.duantn.service.v2.KhachHangService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final KhachHangService khachHangService;
    private final HttpServletResponse response;

    @PostMapping("/login")
    public ActionResponse login(@RequestBody RegisterRequest model) {
        Authentication authentication = authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(model.getUsername(), model.getPassword()));
        if (authentication.isAuthenticated()) {
            response.setHeader("Access-Control-Expose-Headers", "Authorization");
            KhachHang khachHang = (KhachHang) authentication.getPrincipal();
            String token = jwtService.generateToken(khachHang.getTaiKhoan());
            response.setHeader("Authorization", token);
            return ActionResponse.builder().token(token)
                .success(true)
                .message("Đăng nhập thành công")
                .status(HttpStatus.OK.value())
                .build();
        } else {
            return ActionResponse.builder()
                .success(false)
                .message("Đăng nhập thất bại")
                .status(HttpStatus.UNAUTHORIZED.value())
                .build();
        }
    }

    @PostMapping("/register")
    public ActionResponse register(@RequestBody RegisterRequest model) {
        KhachHang khachHang = khachHangService.register(model);
        return ActionResponse.builder()
            .message("Đăng ký thành công")
            .status(200)
            .data(khachHang)
            .build();
    }

}
