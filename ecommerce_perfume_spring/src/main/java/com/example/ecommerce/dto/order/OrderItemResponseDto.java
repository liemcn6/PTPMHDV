package com.example.ecommerce.dto.order;

import com.example.ecommerce.dto.perfume.PerfumeResponseDto;
import lombok.Data;

@Data
public class OrderItemResponseDto {
    private Long id;
    private Long amount;
    private Long quantity;
    private PerfumeResponseDto perfume;
}
