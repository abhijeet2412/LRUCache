package com.prep.lru;

import com.prep.lru.entity.LRU;
import com.prep.lru.service.ILRUService;
import com.prep.lru.service.LRUService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){


        System.out.println("Welcome to LRU Cache implementation");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the LRU Cache: ");
        Integer size = sc.nextInt();
        Map<String, Date> lruCache = new HashMap<>();
        LRU lru = new LRU(lruCache, size);
        ILRUService lruService = new LRUService(lru);
        printMenu();
        Integer choice =  sc.nextInt();

        do {
            switch (choice) {
                case 1:
                    lruService.listAll();
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Enter entry value: ");
                    String entry = sc.nextLine();
                    lruService.put(entry, new Date());
                    System.out.println("Entry added successfully.");
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Enter item to search: ");
                    String searchKey = sc.nextLine();
                    lruService.get(searchKey);
                    break;
                default:
                    System.out.println("Please enter a valid input.");
                    break;
            }
            printMenu();
            choice = sc.nextInt();

        } while (choice != 4);
    }

    private static void printMenu() {
        System.out.println("Select one of below choices: ");
        System.out.println("1. List all items in LRU");
        System.out.println("2. Add an item to LRU");
        System.out.println("3. Get an item from LRU");
        System.out.println("4. Exit LRU System");
    }
}
