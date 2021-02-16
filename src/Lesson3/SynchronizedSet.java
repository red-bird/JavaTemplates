package Lesson3;

import java.util.*;

public class SynchronizedSet<E> extends TreeSet {
    @Override
    synchronized public int size() {
        return super.size();
    }

    @Override
    synchronized public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    synchronized public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    synchronized public boolean add(Object o) {
        return super.add(o);
    }

    @Override
    synchronized public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    synchronized public void clear() {
        super.clear();
    }

    @Override
    synchronized public boolean addAll(Collection c) {
        return super.addAll(c);
    }

    @Override
    synchronized public NavigableSet subSet(Object fromElement, boolean fromInclusive, Object toElement, boolean toInclusive) {
        return super.subSet(fromElement, fromInclusive, toElement, toInclusive);
    }

    @Override
    synchronized public NavigableSet headSet(Object toElement, boolean inclusive) {
        return super.headSet(toElement, inclusive);
    }

    @Override
    synchronized public NavigableSet tailSet(Object fromElement, boolean inclusive) {
        return super.tailSet(fromElement, inclusive);
    }

    @Override
    synchronized public SortedSet subSet(Object fromElement, Object toElement) {
        return super.subSet(fromElement, toElement);
    }

    @Override
    synchronized public SortedSet headSet(Object toElement) {
        return super.headSet(toElement);
    }

    @Override
    synchronized public SortedSet tailSet(Object fromElement) {
        return super.tailSet(fromElement);
    }

    @Override
    synchronized public Comparator comparator() {
        return super.comparator();
    }

    @Override
    synchronized public Object first() {
        return super.first();
    }

    @Override
    synchronized public Object last() {
        return super.last();
    }

    @Override
    synchronized public Object lower(Object o) {
        return super.lower(o);
    }

    @Override
    synchronized public Object floor(Object o) {
        return super.floor(o);
    }

    @Override
    synchronized public Object ceiling(Object o) {
        return super.ceiling(o);
    }

    @Override
    synchronized public Object higher(Object o) {
        return super.higher(o);
    }

    @Override
    synchronized public Object pollFirst() {
        return super.pollFirst();
    }

    @Override
    synchronized public Object pollLast() {
        return super.pollLast();
    }

    @Override
    synchronized public Object clone() {
        return super.clone();
    }
}
