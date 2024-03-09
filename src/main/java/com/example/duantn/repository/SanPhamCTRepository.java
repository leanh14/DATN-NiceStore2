package com.example.duantn.repository;

import com.example.duantn.model.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SanPhamCTRepository extends JpaRepository<ChiTietSanPham, UUID> {
    @Query(value = "select * from SanPhamCT ",nativeQuery = true)
    List<ChiTietSanPham> getAll();
}
