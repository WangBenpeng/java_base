package com.pengo.design.observer;

/**
 * @author pengo
 * @description:
 * @date 2022/2/24 16:56
 */
public class ObserverDemo {
    public static void main(String[] args) {
        Admin a = new Admin();
        Customer c = new Customer();
        Store s = new Store();
        s.addPO(a);
        s.addPO(c);
        s.addPO(new ProductObserver() {
            @Override
            public void onPublished(Product product) {
                System.out.println("[Log] on product published: " + product);
            }

            @Override
            public void onPriceChange(Product product) {
                System.out.println("[Log] on product price changed: " + product);
            }
        });
        s.addNewProduct("Design Patterns", 35.6);
        s.addNewProduct("Effective Java", 50.8);
        s.setProductPrice("Design Patterns", 31.9);
    }
}

class Customer implements ProductObserver {

    @Override
    public void onPublished(Product product) {
        System.out.println("[Customer] on product published: " + product);
    }

    @Override
    public void onPriceChange(Product product) {
        System.out.println("[Customer] on product price changed: " + product);
    }
}

class Admin implements ProductObserver {

    @Override
    public void onPublished(Product product) {
        System.out.println("[Admin] on product published: " + product);
    }

    @Override
    public void onPriceChange(Product product) {
        System.out.println("[Admin] on product price changed: " + product);
    }
}
