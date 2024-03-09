package com.example.duantn.record;

import java.util.UUID;

public record OrderDetailRecord(UUID orderId, String orderCode, String productName, Double price, Integer quantity,
                                Double totalMoney) {
    public OrderDetailRecord {
        if (price < 0 || quantity < 0)
            throw new IllegalArgumentException("Giá và số lượng phải lớn hơn 0");
        else if (orderId == null || orderCode == null || productName == null)
            throw new IllegalArgumentException("Dữ liệu không hợp lệ");
        else if (orderCode.isBlank() || productName.isBlank())
            throw new IllegalArgumentException("Dữ liệu không hợp lệ");
    }
}
