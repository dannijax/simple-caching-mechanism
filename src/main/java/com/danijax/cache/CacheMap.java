package com.danijax.cache;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by danijax on 8/2/17.
 */
public class CacheMap extends Hashtable implements Pingable {

    private long expiryTime;
    private Ping cleaner;

    public CacheMap(long expiryTime) {
        super();
        this.expiryTime = expiryTime;
        this.cleaner = new Ping(this, (long)(expiryTime * 0.75));

    }

    @Override
    public synchronized Object put(Object key, Object value) {
        return super.put(key, new TimeWrapper(value));
    }

    @Override
    public synchronized Object get(Object key) {
        return ((TimeWrapper) super.get(key)).getObject();
    }

    @Override
    public synchronized void ping() {
        Enumeration e = super.keys();
        while (e.hasMoreElements()){
            Object key  = e.nextElement();
            TimeWrapper timeWrapper = (TimeWrapper) super.get(key);
            if (timeWrapper != null && timeWrapper.getAge() > expiryTime) remove(key);

        }
        System.gc();
    }
}
