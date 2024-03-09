package com.example.duantn.repository;

import com.example.duantn.model.DayGiay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DayGiayRepository extends JpaRepository<DayGiay, UUID> {
    @Query(value = "select * from DayGiay", nativeQuery = true)
    public List<DayGiay> getAll();

}
