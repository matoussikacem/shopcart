package org.natixis.kata.domain.adapter;

import org.json.simple.JSONObject;
import org.natixis.kata.domain.model.Cart;

import java.math.BigDecimal;

public interface CartToJson {

    public JSONObject generateCartJson(Cart cart, BigDecimal total);
}
