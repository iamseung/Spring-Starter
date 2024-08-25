package com.example.start.pattern;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ObserverTest {
    interface Subject {
        public void register(Observer obj);
        public void unregister(Observer obj);
        public void notifyObservers();
        public Object getUpdate(Observer obj);
    }

    interface Observer {
        public void update();
    }

    class Topic implements Subject {
        private List<Observer> observers;
        private String message;

        public Topic() {
            this.observers = new ArrayList<>();
            this.message = "";
        }

        @Override
        public void register(Observer obj) {
            if (!observers.contains(obj)) observers.add(obj);
        }

        @Override
        public void unregister(Observer obj) {
            observers.remove(obj);
        }

        @Override
        public void notifyObservers() {
            this.observers.forEach(Observer::update);
        }

        @Override
        public Object getUpdate(Observer obj) {
            return this.message;
        }

        public void postMessage(String msg) {
            System.out.println("Message sended to Topic: " + msg);
            this.message = msg;
            notifyObservers();
        }
    }

    class TopicSubscriber implements Observer {
        private String name;
        private Subject topic;

        public TopicSubscriber(String name, Subject topic) {
            this.name = name;
            this.topic = topic;
        }

        @Override
        public void update() {
            String msg = (String) topic.getUpdate(this);
            System.out.println(name + ":: got message >> " + msg);
        }
    }

    @Test
    void observerTest() {
        /*
            주체 → 객체의 상태 변화를 보고 있는 관찰자
            옵저버 → 이 객체의 상태 변화에 따라 전달되는 메서드 등을 기반으로 ‘추가 변화 사항’이 생기는 객체들을 의미
         */

        // 주체이자 객체
        Topic topic = new Topic();
        Observer a = new TopicSubscriber("a", topic);
        Observer b = new TopicSubscriber("b", topic);
        Observer c = new TopicSubscriber("c", topic);
        topic.register(a);
        topic.register(b);
        topic.register(c);

        topic.postMessage("amumu is op champion!!");
    }
}
