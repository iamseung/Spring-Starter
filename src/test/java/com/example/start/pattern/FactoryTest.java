package com.example.start.pattern;

import org.junit.jupiter.api.Test;

public class FactoryTest {
    static abstract class Coffee {
        public abstract int getPrice();

        @Override
        public String toString() {
            return "Hi this coffee is " + this.getPrice();
        }
    }

    static class CoffeeFactory {
        public static Coffee getCoffee(String type, int price) {
            if("Latte".equalsIgnoreCase(type))
                return new Latte(price);
            else if("Americano".equalsIgnoreCase(type))
                return new Americano(price);
            else
                return new DefaultCoffee();
        }
    }

    static class DefaultCoffee extends Coffee {
        private int price;

        public DefaultCoffee() {
            this.price = -1;
        }

        @Override
        public int getPrice() {
            return price;
        }
    }

    static class Latte extends Coffee {
        private int price;

        public Latte(int price) {
            this.price = price;
        }

        @Override
        public int getPrice() {
            return price;
        }
    }

    static class Americano extends Coffee {
        private int price;

        public Americano(int price) {
            this.price = price;
        }

        @Override
        public int getPrice() {
            return price;
        }
    }

    @Test
    void coffeeFactoryTest() {
        /*
            팩토리 메서드 패턴은 객체의 생성 과정을 서브 클래스에 위임함으로써
            객체 생성을 캡슐화하는 디자인 패턴

            Coffee → 추상 클래스
            CoffeeFactory → 팩토리 클래스, 커피 객체 생성 로직을 캡슐화.
         */
        Coffee latte = CoffeeFactory.getCoffee("Latte", 4000);
        Coffee americano = CoffeeFactory.getCoffee("Americano", 3000);

        System.out.println("Factory latte ::" + latte);
        System.out.println("Factory americano ::" + americano);
    }
}
