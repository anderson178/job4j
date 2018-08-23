package ru.job4j.tracker;

import java.util.*;

public class Item {
	private String id;
	private String name;
	private String description;
	private String create = new Date().toString();
	
	Item(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getId() {
		return this.id;
	}
	public String setId(String id) {
		this.id = id;
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String setName(String name) {
		return this.name;
	}
	public String getDescription() {
		return this.description;
	}
	public String setDescription() {
		return this.description;
	}
	public String getCreate() {
		return this.create;
	}
	public String setCreate() {
		return this.create;
	}
}
