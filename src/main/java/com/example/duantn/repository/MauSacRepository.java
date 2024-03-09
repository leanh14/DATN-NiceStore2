package com.example.duantn.repository;

import com.example.duantn.model.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, UUID> {
    @Query(value = "select * from MauSac ", nativeQuery = true)
    public List<MauSac> getAll();
}
