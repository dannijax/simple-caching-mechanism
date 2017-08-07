package com.danijax.cache;

/**
 * Created by danijax on 8/2/17.
 */
public class TimeWrapper {

    private long age;
    private Object object;

    public TimeWrapper(Object object) {
        this.object = object;
        updateAge();
    }

    private void updateAge() {
        age = System.currentTimeMillis();
    }

    public long getAge() {
        return System.currentTimeMillis() - age;
    }

    public Object getObject() {
        updateAge();
        return object;
    }
}
