package com.example.start.pattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleTonTest {

    static class SingleTon {
        private static final SingleTon INSTANCE = new SingleTon();

        public static SingleTon getInstance() {
            return SingleTon.INSTANCE;
        }
    }

    @Test
    void singleTonEqual() {
        SingleTon a = SingleTon.getInstance();
        SingleTon b = SingleTon.getInstance();
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        assertEquals(a,b);
    }
}
