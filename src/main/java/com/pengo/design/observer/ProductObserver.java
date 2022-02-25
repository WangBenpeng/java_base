package com.pengo.design.observer;

public interface ProductObserver {
    void onPublished(Product product);

    void onPriceChange(Product product);
}
