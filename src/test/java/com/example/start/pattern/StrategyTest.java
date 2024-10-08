package com.example.start.pattern;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StrategyTest {
    interface PaymentStrategy {
        public void pay(int amount);
    }

    static class KAKAOCardStrategy implements PaymentStrategy {
        private String name;
        private String cardNumber;
        private String cvv;
        private String dateOfExpiry;

        public KAKAOCardStrategy(String nm, String ccNum, String cvv, String expiryDate){
            this.name=nm;
            this.cardNumber=ccNum;
            this.cvv=cvv;
            this.dateOfExpiry=expiryDate;
        }

        @Override
        public void pay(int amount) {
            System.out.println(amount +" paid using KAKAOCard.");
        }
    }

    static class LUNACardStrategy implements PaymentStrategy {
        private String emailId;
        private String password;

        public LUNACardStrategy(String email, String pwd){
            this.emailId=email;
            this.password=pwd;
        }

        @Override
        public void pay(int amount) {
            System.out.println(amount + " paid using LUNACard.");
        }
    }

    static class Item {
        private String name;
        private int price;

        public Item(String name, int cost){
            this.name=name;
            this.price=cost;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }
    }

    static class ShoppingCart {
        List<Item> items;

        public ShoppingCart(){
            this.items = new ArrayList<Item>();
        }

        public void addItem(Item item){
            this.items.add(item);
        }

        public void removeItem(Item item){
            this.items.remove(item);
        }

        public int calculateTotal(){
            int sum = 0;
            for(Item item : items){
                sum += item.getPrice();
            }
            return sum;
        }

        public void pay(PaymentStrategy paymentMethod){
            int amount = calculateTotal();
            paymentMethod.pay(amount);
        }
    }

    @Test
    void strategyTest() {
        /*
            쇼핑 카트에 아이템을 담아 LUNACard 또는 KAKAOCard 라는 두개의 전략으로 결제하는 코드
         */
        ShoppingCart cart = new ShoppingCart();

        Item A = new Item("kundolA",100);
        Item B = new Item("kundolB",300);

        cart.addItem(A);
        cart.addItem(B);

        // pay by LUNACard
        cart.pay(new LUNACardStrategy("kundol@example.com", "pukubababo"));
        // pay by KAKAOBank
        cart.pay(new KAKAOCardStrategy("Ju hongchul", "123456789", "123", "12/01"));
    }
}
