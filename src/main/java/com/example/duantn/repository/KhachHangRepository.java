package com.example.duantn.repository;

import com.example.duantn.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {
    @Query("select k from KhachHang k where k.taiKhoan = :username")
    KhachHang findByUsername(String username);
}
