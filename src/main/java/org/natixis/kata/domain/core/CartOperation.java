package org.natixis.kata.domain.core;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.natixis.kata.domain.exception.ShopCartException;
import org.natixis.kata.domain.model.Cart;
import org.natixis.kata.domain.model.Item;

import java.math.BigDecimal;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
public class CartOperation {

    public void addOrUpdateItem(Cart cart, Item item) throws ShopCartException {
        try{
            Optional<Item> itemOpt =
                    cart.getItems().stream()
                            .filter(cartItem -> cartItem.getProductName().equals(item.getProductName()))
                            .findAny();
            if (itemOpt.isPresent())
                itemOpt.get().setQuantity(itemOpt.get().getQuantity() + item.getQuantity());
            else cart.getItems().add(item);
        }catch (Exception e){
            throw new ShopCartException(e.getMessage(),e);
        }

    }

    public BigDecimal calculateTotal(Cart cart) throws ShopCartException {
        return CartUtil.calculateTotal(cart);
    }
}
