package com.example.duantn.repository;

import com.example.duantn.model.ChatLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChatLieuRepository extends JpaRepository<ChatLieu, UUID> {
    @Query(value = "select * from ChatLieu", nativeQuery = true)
    public List<ChatLieu> getAll();

}
