package com.demo.test.library.eventbus;

import de.greenrobot.event.EventBus;

public final class TEventBus {

    private TEventBus() {
    }

    private static final EventBus mEventBus = EventBus.getDefault();

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public static void register(Object subscriber) {
        try {
            mEventBus.register(subscriber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void register(Object subscriber, int priority) {
        try {
            mEventBus.register(subscriber, priority);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void registerSticky(Object subscriber) {
        try {
            mEventBus.registerSticky(subscriber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void registerSticky(Object subscriber, int priority) {
        try {
            mEventBus.registerSticky(subscriber, priority);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void unregister(Object subscriber) {
        try {
            mEventBus.unregister(subscriber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isRegistered(Object subscriber) {
        return mEventBus.isRegistered(subscriber);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public static void post(Object event) {
        mEventBus.post(event);
    }

    public static void postSticky(Object event) {
        mEventBus.postSticky(event);
    }

    public static <T> T getStickyEvent(Class<T> eventType) {
        return mEventBus.getStickyEvent(eventType);
    }

    public static <T> T removeStickyEvent(Class<T> eventType) {
        return mEventBus.removeStickyEvent(eventType);
    }

    public static boolean removeStickyEvent(Object event) {
        return mEventBus.removeStickyEvent(event);
    }

    public static void removeAllStickyEvents() {
        mEventBus.removeAllStickyEvents();
    }

    public static boolean hasSubscriberForEvent(Class<?> eventClass) {
        return mEventBus.hasSubscriberForEvent(eventClass);
    }

    public static void cancelEventDelivery(Object event) {
        mEventBus.cancelEventDelivery(event);
    }
}
