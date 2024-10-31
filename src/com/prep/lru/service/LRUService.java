package com.prep.lru.service;

import com.prep.lru.entity.LRU;

import java.util.Date;

public class LRUService implements ILRUService {
    public LRUService(LRU lru) {
        this.lru = lru;
    }

    private LRU lru;

    @Override
    public void get(String key) {
        if (lru.getLruCache().isEmpty()) {
            System.out.println("No such entry found.");
        }
        if (lru.getLruCache().get(key) == null) {
            System.out.println("No such entry found.");
        } else {
            lru.getLruCache().put(key, new Date());
            System.out.println("Entry found: " +  lru.getLruCache().get(key));
        }
    }

    @Override
    public void put(String key, Date time) {
        if (lru.getLruCache().isEmpty() || lru.getLruCache().size() < lru.getCacheSize()) {
            lru.getLruCache().put(key, new Date());
        } else {
            Date entryToEvict = lru.getLruCache().values().stream().sorted((Date a, Date b) -> (a.after(b)? 1:-1)).findFirst().get();
            String keyToEvict = lru.getLruCache().keySet().stream().filter(x -> lru.getLruCache().get(x).equals(entryToEvict)).findFirst().get().toString();
            System.out.println(lru.getLruCache().remove(keyToEvict));
            System.out.println("Evicted from LRU: " + keyToEvict);
            lru.getLruCache().put(key, new Date());
        }
    }

    @Override
    public void listAll() {
        System.out.println(lru);
    }


}
