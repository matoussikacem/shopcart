package org.natixis.kata.domain.core;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.natixis.kata.domain.adapter.CartPrinter;
import org.natixis.kata.domain.adapter.CartToJson;
import org.natixis.kata.domain.exception.ShopCartException;
import org.natixis.kata.domain.model.Cart;

import java.io.FileWriter;
import java.io.IOException;

@Slf4j
@AllArgsConstructor
public class CartStatement {

    private CartPrinter cartPrinter;

    private CartToJson cartToJson;

    public static final String PATH_FILE="c:\\temp\\";
    public static final String HEADER = "Product | Quantity | Price | Total";
    public static final String TOTAL = "Total: ";

    public void printHeader() {
        log.info(HEADER);
    }

    public void printCart(Cart cart) throws ShopCartException {
        printHeader();
        cart.getItems().forEach(item -> cartPrinter.print(item));
        printTotal(cart);
    }

    public void printTotal(Cart cart) throws ShopCartException {
        log.info(TOTAL + CartUtil.calculateTotal(cart));
    }

    public void exportJsonFile(Cart cart) throws ShopCartException {
        try {
            FileWriter file = new FileWriter(PATH_FILE+"CartJson");
            JSONObject jsonCart = this.cartToJson.generateCartJson(cart, CartUtil.calculateTotal(cart));
            file.write(jsonCart.toJSONString());
            file.close();
        }catch (Exception e){
            log.error("Error when generating json file"+e.getMessage());
            throw new ShopCartException(e.getMessage(),e);
        }

    }
}
