package org.natixis.kata.domain.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.natixis.kata.domain.core.CartOperation;
import org.natixis.kata.domain.core.CartStatement;
import org.natixis.kata.domain.exception.ShopCartException;
import org.natixis.kata.domain.model.Cart;
import org.natixis.kata.domain.model.Item;

import java.math.BigDecimal;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
public class CartService {
    private CartOperation cartOperation;

    private CartStatement cartStatement;

    public void addOrUpdateItem(Cart cart, Item item) throws ShopCartException {
        this.cartOperation.addOrUpdateItem(cart, item);
    }

    public void printCart(Cart cart) throws ShopCartException {
        this.cartStatement.printCart(cart);
    }

    public void exportJsonFile (Cart cart) throws ShopCartException {
        this.cartStatement.exportJsonFile(cart);
    }

}
