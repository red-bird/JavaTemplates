package Lesson3;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class SynchronizedMap<K, V> extends HashMap {

    @Override
    public int size() {
        Lock lock = new ReentrantLock();
        lock.lock();
        int tmp = super.size();
        lock.unlock();
        return tmp;
    }

    @Override
    public boolean isEmpty() {
        Lock lock = new ReentrantLock();
        lock.lock();
        boolean tmp = super.isEmpty();
        lock.unlock();
        return tmp;
    }

    @Override
    public Object get(Object key) {
        Lock lock = new ReentrantLock();
        lock.lock();
        Object tmp = super.get(key);
        lock.unlock();
        return tmp;
    }

    @Override
    public boolean containsKey(Object key) {
        Lock lock = new ReentrantLock();
        lock.lock();
        boolean tmp = super.containsKey(key);
        lock.unlock();
        return tmp;
    }

    @Override
    public Object put(Object key, Object value) {
        Lock lock = new ReentrantLock();
        lock.lock();
        Object tmp = super.put(key, value);
        lock.unlock();
        return tmp;
    }

    @Override
    public void putAll(Map m) {
        Lock lock = new ReentrantLock();
        lock.lock();
        super.putAll(m);
        lock.unlock();
    }

    @Override
    public Object remove(Object key) {
        Lock lock = new ReentrantLock();
        lock.lock();
        Object tmp = super.remove(key);
        lock.unlock();
        return tmp;
    }

    @Override
    public void clear() {
        Lock lock = new ReentrantLock();
        lock.lock();
        super.clear();
        lock.unlock();
    }

    @Override
    public boolean containsValue(Object value) {
        Lock lock = new ReentrantLock();
        lock.lock();
        boolean tmp = super.containsValue(value);
        lock.unlock();
        return tmp;
    }

    @Override
    public Set keySet() {
        Lock lock = new ReentrantLock();
        lock.lock();
        Set tmp = super.keySet();
        lock.unlock();
        return tmp;
    }

    @Override
    public Collection values() {
        Lock lock = new ReentrantLock();
        lock.lock();
        Collection tmp = super.values();
        lock.unlock();
        return tmp;
    }

    @Override
    public Set<Entry> entrySet() {
        Lock lock = new ReentrantLock();
        lock.lock();
        Set tmp = super.entrySet();
        lock.unlock();
        return tmp;
    }

    @Override
    public Object getOrDefault(Object key, Object defaultValue) {
        Lock lock = new ReentrantLock();
        lock.lock();
        Object tmp = super.getOrDefault(key, defaultValue);
        lock.unlock();
        return tmp;
    }

    @Override
    public Object putIfAbsent(Object key, Object value) {
        Lock lock = new ReentrantLock();
        lock.lock();
        Object tmp = super.putIfAbsent(key, value);
        lock.unlock();
        return tmp;
    }

    @Override
    public boolean remove(Object key, Object value) {
        Lock lock = new ReentrantLock();
        lock.lock();
        boolean tmp = super.remove(key, value);
        lock.unlock();
        return tmp;
    }

    @Override
    public boolean replace(Object key, Object oldValue, Object newValue) {
        Lock lock = new ReentrantLock();
        lock.lock();
        boolean tmp = super.replace(key, oldValue, newValue);
        lock.unlock();
        return tmp;
    }

    @Override
    public Object replace(Object key, Object value) {
        Lock lock = new ReentrantLock();
        lock.lock();
        Object tmp = super.replace(key, value);
        lock.unlock();
        return tmp;
    }

    @Override
    public Object computeIfAbsent(Object key, Function mappingFunction) {
        Lock lock = new ReentrantLock();
        lock.lock();
        Object tmp = super.computeIfAbsent(key, mappingFunction);
        lock.unlock();
        return tmp;
    }

    @Override
    public Object computeIfPresent(Object key, BiFunction remappingFunction) {
        Lock lock = new ReentrantLock();
        lock.lock();
        Object tmp = super.computeIfPresent(key, remappingFunction);
        lock.unlock();
        return tmp;
    }

    @Override
    public Object compute(Object key, BiFunction remappingFunction) {
        Lock lock = new ReentrantLock();
        lock.lock();
        Object tmp = super.compute(key, remappingFunction);
        lock.unlock();
        return tmp;
    }

    @Override
    public Object merge(Object key, Object value, BiFunction remappingFunction) {
        Lock lock = new ReentrantLock();
        lock.lock();
        Object tmp = super.merge(key, value, remappingFunction);
        lock.unlock();
        return tmp;
    }

    @Override
    public void forEach(BiConsumer action) {
        Lock lock = new ReentrantLock();
        lock.lock();
        super.forEach(action);
        lock.unlock();
    }

    @Override
    public void replaceAll(BiFunction function) {
        Lock lock = new ReentrantLock();
        lock.lock();
        super.replaceAll(function);
        lock.unlock();
    }

    @Override
    public Object clone() {
        Lock lock = new ReentrantLock();
        lock.lock();
        Object tmp = super.clone();
        lock.unlock();
        return tmp;
    }
}
