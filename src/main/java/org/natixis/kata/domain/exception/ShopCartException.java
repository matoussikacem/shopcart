package org.natixis.kata.domain.exception;

public class ShopCartException  extends  Exception{

    public ShopCartException(String message) {super(message);}
    public ShopCartException(String message, Throwable cause) {super(message,cause);}
    public ShopCartException(Throwable cause) {super(cause);}
}
