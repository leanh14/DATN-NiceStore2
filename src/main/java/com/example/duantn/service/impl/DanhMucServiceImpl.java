package com.example.duantn.service.impl;

import com.example.duantn.model.DanhMuc;
import com.example.duantn.repository.DanhMucRepository;
import com.example.duantn.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DanhMucServiceImpl implements BaseService<DanhMuc> {
    @Autowired
    DanhMucRepository repo_danhMuc;


    public List<DanhMuc> layDanhSach() {
        return repo_danhMuc.getAll();
    }

    @Override
    public Page<DanhMuc> layDanhSach(Pageable pageable) {
        return null;
    }

    @Override
    public Page<DanhMuc> layDanhSach(String textSearch, Pageable pageable) {
        return null;
    }

    @Override
    public void xoa(UUID id) {

    }

    @Override
    public void themMoi(DanhMuc entity) {

    }

    @Override
    public void capNhat(DanhMuc entity) {
        repo_danhMuc.save(entity);
    }

    @Override
    public DanhMuc chiTietTheoId(UUID id) {
        return null;
    }

    @Override
    public List<DanhMuc> layDanhSachTheoTen(String ten) {
        return null;
    }
}
