package ru.job4j.tracker;

import java.util.*;

public class Tracker {
	private Item[] items = new Item[100];
	private int position = 0;
	private static final Random RN = new Random();
	
	
	private String getCurrentDate() {
		Date date = new Date();
		return date.toString();
	}
		
	private String generatedId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt());
	}
	
	public Item add(Item item, String name, String description) {
		item.setId(this.generatedId());
		item.setName(name);
		item.setDescription(description);		
		item.setCreate(this.getCurrentDate());
		items[position] = item;
		return item;		
	}
}
