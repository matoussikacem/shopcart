package org.natixis.kata.domain.core;

import lombok.extern.slf4j.Slf4j;
import org.natixis.kata.domain.exception.ShopCartException;
import org.natixis.kata.domain.model.Cart;

import java.math.BigDecimal;
@Slf4j
public class CartUtil {

    public static BigDecimal calculateTotal(Cart cart) throws ShopCartException {
        try{
            return cart.getItems().stream()
                    .map(item -> item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                    .reduce(BigDecimal.ZERO, (subTotal, item) -> subTotal.add(item));
        }catch (Exception e){
            log.error("Error when generating json file"+e.getMessage());
            throw new ShopCartException(e.getMessage(),e);
        }

    }
}
