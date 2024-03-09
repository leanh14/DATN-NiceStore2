package com.example.duantn.service.impl;

import com.example.duantn.model.ChiTietSanPham;
import com.example.duantn.model.HoaDon;
import com.example.duantn.model.KichCo;
import com.example.duantn.repository.ChiTietSanPhamRepository;
import com.example.duantn.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChiTietSPServiceImpl implements BaseService<ChiTietSanPham> {
    @Autowired
    ChiTietSanPhamRepository repo_chiTietSanPham;

//    @Override
//    public List<ChiTietSanPham> layDanhSach() {
//        return repo_chiTietSanPham.getAll();
//    }
//
//    @Override
//    public List<ChiTietSanPham> findByCondition(ChiTietSanPham entity) {
//        return null;
//    }

    @Override
    public Page<ChiTietSanPham> layDanhSach(Pageable pageable) {
        return repo_chiTietSanPham.getAll(pageable);
    }

    @Override
    public Page<ChiTietSanPham> layDanhSach(String textSearch, Pageable pageable) {
        if(textSearch!=null){
            return repo_chiTietSanPham.getAll(textSearch, pageable);
        }

        return repo_chiTietSanPham.getAll(pageable);
    }

//    @Override
//    public Page<ChiTietSanPham> findPage(ChiTietSanPham entity, Pageable pageable) {
//        return null;
//    }

    @Override
    public void xoa(UUID id) {

    }

    @Override
    public void themMoi(ChiTietSanPham entity) {

    }

    @Override
    public void capNhat(ChiTietSanPham entity) {
        repo_chiTietSanPham.save(entity);
    }

    @Override
    public ChiTietSanPham chiTietTheoId(UUID id) {
        Optional<ChiTietSanPham> chiTietSanPham = repo_chiTietSanPham.findById(id);
        ChiTietSanPham chiTietSanPham1 = chiTietSanPham.get();
        return chiTietSanPham1;
    }

    @Override
    public List<ChiTietSanPham> layDanhSachTheoTen(String ten) {
        return null;
    }

    public void capNhatSoLuongSauKhiDatHang(Integer soLuongMua, UUID idChiTietSP) {
        repo_chiTietSanPham.updateSoLuong(soLuongMua, idChiTietSP);
    }



}
