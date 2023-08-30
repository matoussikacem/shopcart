package org.natixis.kata.domain.model;

import lombok.*;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Builder
public class Item {
    private String productName;
    private Long quantity;
    private BigDecimal unitPrice;

    @Override
    public String toString() {
        return " Item{" +
                "productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
