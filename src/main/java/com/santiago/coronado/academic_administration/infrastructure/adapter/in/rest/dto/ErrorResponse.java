package com.santiago.coronado.academic_administration.infrastructure.adapter.in.rest.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponse {
    private String error;
    private LocalDateTime time;
    private String state;
    private int code;
}