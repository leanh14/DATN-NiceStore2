package com.example.duantn.repository;

import  com.example.duantn.model.KieuDang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface KieuDangRepository extends JpaRepository<KieuDang, UUID> {
    @Query(value = "select * from KieuDang", nativeQuery = true)
    public List<KieuDang> getAll();
}
