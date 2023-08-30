package org.natixis.kata.domain.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.natixis.kata.domain.exception.ShopCartException;
import org.natixis.kata.domain.model.Cart;
import org.natixis.kata.domain.model.Item;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class CartOperationTest {

    private CartOperation cartOperation = mock(CartOperation.class);

    Cart cart;

    @BeforeEach
    public void setUp() throws IOException {
        cartOperation = new CartOperation();
        List<Item> items= new ArrayList<>();
        Item item = new Item("product1",5L, BigDecimal.valueOf(6.0));
        items.add(item);
        cart = new Cart(items, BigDecimal.ZERO);

    }
    @Nested
    @DisplayName("Check that the item is well added")
    class calculateTotal {

        @Test
        public void addOrUpdateItemCheck() throws ShopCartException {
            Item item = new Item("product2",7L, BigDecimal.valueOf(7.0));
            cartOperation.addOrUpdateItem(cart,item);
            assertEquals(2, cart.getItems().size());
        }


    }
}
