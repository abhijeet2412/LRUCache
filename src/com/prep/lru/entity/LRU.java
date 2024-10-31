package com.prep.lru.entity;

import java.util.Date;
import java.util.Map;

public class LRU {
    private Map<String, Date> lruCache;

    @Override
    public String toString() {
        return "LRU{" +
                "lruCache=" + lruCache +
                ", cacheSize=" + cacheSize +
                '}';
    }

    final private Integer cacheSize;

    public Integer getCacheSize() {
        return cacheSize;
    }

    public LRU(Map<String, Date> lruCache, Integer cacheSize) {
        this.lruCache = lruCache;
        this.cacheSize = cacheSize;
    }

    public Map<String, Date> getLruCache() {
        return lruCache;
    }

    public void setLruCache(Map<String, Date> lruCache) {
        this.lruCache = lruCache;
    }
}
