package org.natixis.kata.domain;

import org.natixis.kata.domain.adapter.CartPrinter;
import org.natixis.kata.domain.adapter.CartToJson;
import org.natixis.kata.domain.adapter.impl.CartPrinterAdapter;
import org.natixis.kata.domain.adapter.impl.CartToJsonAdapter;
import org.natixis.kata.domain.core.CartOperation;
import org.natixis.kata.domain.core.CartStatement;
import org.natixis.kata.domain.exception.ShopCartException;
import org.natixis.kata.domain.model.Cart;
import org.natixis.kata.domain.model.Item;
import org.natixis.kata.domain.service.CartService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ShopCartException {
        CartPrinter cartPrinter = new CartPrinterAdapter();
        CartToJson cartToJson = new CartToJsonAdapter();
        CartOperation cartOperation = new CartOperation();
        CartStatement cartStatement = new CartStatement(cartPrinter,cartToJson);
        CartService cartService = new CartService(cartOperation,cartStatement);

        List<Item> items= new ArrayList<>();
        Cart cart = new Cart(items,BigDecimal.ZERO);
        Item item = new Item("product1",5L, BigDecimal.valueOf(6.0));
        Item item1 = new Item("product2",12L, BigDecimal.valueOf(9.0));
        Item item2 = new Item("product1",13L, BigDecimal.valueOf(6.0));
        Item item3 = new Item("product3",2L, BigDecimal.valueOf(7.0));
        Item item4 = new Item("product2",30L, BigDecimal.valueOf(9.0));
        cartService.addOrUpdateItem(cart,item);
        cartService.addOrUpdateItem(cart,item1);
        cartService.addOrUpdateItem(cart,item2);
        cartService.addOrUpdateItem(cart,item3);
        cartService.addOrUpdateItem(cart,item4);

        cartService.printCart(cart);
        cartService.exportJsonFile(cart);

        ;
    }
}