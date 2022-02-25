package com.pengo.design.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pengo
 * @description:
 * @date 2022/2/24 16:50
 */
public class Store {
    private List<ProductObserver> observers = new ArrayList<>();
    private Map<String, Product> products = new HashMap<>();

    public void addPO(ProductObserver po) {
        this.observers.add(po);
    }

    public void removePO(ProductObserver po) {
        this.observers.remove(po);
    }

    public void addNewProduct(String name, double price) {
        Product p = new Product(name, price);
        products.put(p.getName(), p);
        observers.forEach(o -> o.onPublished(p));
    }

    public void setProductPrice(String name, double price) {
        Product product = products.get(name);
        if (product != null) {
            product.setPrice(price);
            observers.forEach(observers -> observers.onPriceChange(product));
        }
    }
}
