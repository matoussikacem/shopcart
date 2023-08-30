package org.natixis.kata.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@Setter
@Builder
public class Cart {

    private List<Item> items;
    private BigDecimal total;

    public Cart(List<Item> items, BigDecimal total) {
        this.items = items;
        this.total = total;
    }

    public Cart() {
        this.items = new ArrayList<>();
        this.total = BigDecimal.ZERO;
    }

    public List<Item> getItems() {
        return items;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
