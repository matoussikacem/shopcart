package org.natixis.kata.domain.adapter.impl;

import lombok.extern.slf4j.Slf4j;
import org.natixis.kata.domain.adapter.CartPrinter;
import org.natixis.kata.domain.model.Item;

import java.math.BigDecimal;

@Slf4j
public class CartPrinterAdapter implements CartPrinter {
    @Override
    public void print(Item item) {
        log.info(
                "{} | {} | {} | {}",
                item.getProductName(),
                item.getQuantity(),
                item.getUnitPrice(),
                item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
    }
}
