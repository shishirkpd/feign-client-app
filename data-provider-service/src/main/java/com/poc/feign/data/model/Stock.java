package com.poc.feign.data.model;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    String name;
    Double price;
}
