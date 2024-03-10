package com.example.duantn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.UUID;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class BaseModel { //:)))
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID id;

    @Column(name = "NgaySua")
    protected Date ngaySua;

    @Column(name = "NgayTao")
    protected Date ngayTao;

    @Column(name = "NguoiSua")
    protected Integer nguoiSua;

    @Column(name = "NguoiTao")
    protected Integer nguoiTao;

    @Column(name = "TrangThai")
    protected Integer trangThai;
}
