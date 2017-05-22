package com.demo.test.library.eventbus;

/**
 *
 */
public class TEventBusUtil {

    private TEventBusUtil() {
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 这个接口没有任何方法
     * 以下类都具有生命周期管理，它们的子类 implements Subscriber 会自动注册和反注册EventBus
     * 1. RzActivity
     * 2. RzFragmentActivity
     * 3. RzFragment
     * 4. RzPresenter
     */
    public interface Subscriber {
    }

    public static void registerSubscriber(Object subscriber) {
        if (subscriber instanceof Subscriber) {
            TEventBus.register(subscriber);
        }
    }

    public static void unregisterSubscriber(Object subscriber) {
        if (subscriber instanceof Subscriber) {
            TEventBus.unregister(subscriber);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public static abstract class AutoRegisterSubscriber {

        public AutoRegisterSubscriber() {
            TEventBus.register(this);
        }
    }
}
