package com.prep.lru.service;

import java.util.Date;

public interface ILRUService {
    void get(String key);
    void put(String key, Date time);
    void listAll();
}
