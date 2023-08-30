package org.natixis.kata.domain.core;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.natixis.kata.domain.exception.ShopCartException;
import org.natixis.kata.domain.model.Cart;
import org.natixis.kata.domain.model.Item;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;



public class CoreUtilTest {


    @Nested
    @DisplayName("Check that the cart total is correct")
    class calculateTotal {
        @Test
        public void checkCalculateTotal() throws ShopCartException {
            List<Item> items= new ArrayList<>();
            Item item = new Item("product1",5L, BigDecimal.valueOf(6.0));
            Item newItem = new Item("product1",7L, BigDecimal.valueOf(6.0));
            items.add(item);
            items.add(newItem);
            Cart cart = new Cart(items, BigDecimal.ZERO);
            assertNotNull(CartUtil.calculateTotal(cart));
            assertEquals(BigDecimal.valueOf(72.0), CartUtil.calculateTotal(cart));
        }
    }
}
