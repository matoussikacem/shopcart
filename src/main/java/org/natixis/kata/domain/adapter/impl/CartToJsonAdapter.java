package org.natixis.kata.domain.adapter.impl;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.natixis.kata.domain.adapter.CartToJson;
import org.natixis.kata.domain.model.Cart;

import java.math.BigDecimal;
import java.util.List;

public class CartToJsonAdapter implements CartToJson {
    @Override
    public JSONObject generateCartJson(Cart cart, BigDecimal total) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        cart.getItems().forEach(
                        item -> {
                            JSONObject productObject = new JSONObject();
                            productObject.put("Product", item.getProductName());
                            productObject.put("Quantity", item.getQuantity());
                            productObject.put("UnitPrice", item.getUnitPrice());
                            productObject
                                    .put(
                                            "Total",
                                            item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
                            jsonArray.add(productObject);

                        });
        jsonObject.put("cart items", jsonArray);
        jsonObject.put("Total", total);
        return jsonObject;
    }
}
