package com.example.duantn.service.impl;

import com.example.duantn.model.ChatLieu;
import com.example.duantn.repository.ChatLieuRepository;
import com.example.duantn.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChatLieuServiceImpl implements BaseService<ChatLieu> {
    @Autowired
    ChatLieuRepository repo_chatLieu;

//    @Override
//    public List<ChatLieu> layDanhSach() {
//        return repo_chatLieu.getAll();
//    }
//
//    @Override
//    public List<ChatLieu> findByCondition(ChatLieu entity) {
//        return null;
//    }

    @Override
    public Page<ChatLieu> layDanhSach(Pageable pageable) {
        return null;
    }

    @Override
    public Page<ChatLieu> layDanhSach(String textSearch, Pageable pageable) {
        return null;
    }

//    @Override
//    public Page<ChatLieu> findPage(ChatLieu entity, Pageable pageable) {
//        return null;
//    }

    @Override
    public void xoa(UUID id) {

    }

    @Override
    public void themMoi(ChatLieu entity) {

    }

    @Override
    public void capNhat(ChatLieu entity) {
         repo_chatLieu.save(entity);
    }

    @Override
    public ChatLieu chiTietTheoId(UUID id) {
        return null;
    }

    @Override
    public List<ChatLieu> layDanhSachTheoTen(String ten) {
        return null;
    }
}
