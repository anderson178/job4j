package ru.job4j.tracker;

import java.util.*;

public class Tracker {
	private Item[] items = new Item[100];
	private int position = 0;
	private static final Random RN = new Random();		
		
	private String generatedId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt());
	}
	
	
	public Item add(Item item) {
		item.setId(this.generatedId());		
		items[position++] = item;
		return item;		
	}
	public Item[] getAll() {
		Item[] result = new Item[this.items.length];
		for (int i = 0; i < this.items.length; i++) {
			result[i] = this.items[i];
		}
		return result;
	}
	public void replace(String id, Item item) {
		for (int i = 0; i < this.items.length; i++) {
			if (this.items[i].getId().equals(id)) {
				this.items[i] = item;
				break;
			}			
		}
	}
	public Item findById(String id) {
		Item result = new Item("sd",  "sd");
		for (int i = 0; i < this.items.length; i++) {
			if (this.items[i].getId().equals(id)) {
				result = this.items[i];
				break;
			}			
		}
		return result;
	}
	
	
}
