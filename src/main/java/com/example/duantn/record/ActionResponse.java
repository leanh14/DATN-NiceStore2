package com.example.duantn.record;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ActionResponse {
    private String message;
    private boolean success;
    private Object data;
    private String error;
    private Integer status;
    private String token;
}
