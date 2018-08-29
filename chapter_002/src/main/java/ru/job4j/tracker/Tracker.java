package ru.job4j.tracker;

import java.util.*;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 29.08.2018
 */

public class Tracker {
	private Item[] items = new Item[100];
	private int position = 0;
	private static final Random RN = new Random();

	/**
	 * метод генерации id для заявки
	 * @return
	 */
	private String generatedId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt());
	}
	/**
	 * добавление новой заявки в трекер
	 * @param item - заявка
	 * @return
	 */
	public Item add(Item item) {
		String create = new Date().toString();
		item.setId(this.generatedId());
		item.setCreate(create);
		items[position++] = item;
		return item;		
	}

	/**
	 * выводит список всех заявок в трекере
	 * @return
	 */
	public Item[] getAll() {
		return (Arrays.copyOf(this.items, this.position));
	}

	/**
	 * заменяет существущую заявку на другую по id
	 * @param id - идентификатор заявки
	 * @param item - заявка
	 */
	public void replace(String id, Item item) {

		for (int i = 0; i < this.position; i++) {
			if (this.items[i].getId().equals(id)) {
				this.items[i] = item;
				break;
			}			
		}
	}

	/**
	 * заменяет существущую заявку на другую по id (Знаю что это дубль метода
	 * edit но пока он мне нужен).
	 * @param id - идентификатор заявки
	 * @param name - новое имя
	 * @param desc - новое описание
	 */
	public void edit(String id, String name, String desc) {
		int index = this.findIndexById(id);
		Item newItem = new Item(name, desc);
		newItem.setId(this.items[index].getId());
		newItem.setCreate(this.items[index].getCreate());
		this.items[index] = newItem;
	}

	/**
	 * поиск заявки по id
	 * @param id - идентификатор заявки
	 * @return
	 */
	public Item findById(String id) {
		Item result = null;
		for (int i = 0; i < this.position; i++) {
			if (this.items[i].getId().equals(id)) {
				result = this.items[i];
				break;
			}			
		}
		return result;
	}

	/**
	 * метод поиска заявки по имени
	 * @param keyName - имя заявки
	 * @return
	 */
	public Item[] findByName(String keyName) {
		int index = 0;
		int count = 0;
		Item[] result = new Item[this.position];
		for (int i = 0; i < this.position; i++) {
			if (this.items[i].getName().equals(keyName)) {
				result[index++] = this.items[i];
			}
		}					
		return (Arrays.copyOf(result, index));
	}

	/**
	 * метод определения индекса заявки по id
	 * @param id - идентификатор заявки
	 * @return
	 */
	private int findIndexById(String id) {
		int result = 0;
		for (int i = 0; i < this.position; i++) {
			if (this.items[i].getId().equals(id)) {
				result = i;
				break;
			}			
		}
		return result;
	}

	/**
	 * метод удаления заявки по id
	 * @param id - идентификатор заявки
	 * @return
	 */
	public void remove(String id) {
		Item[] result = new Item[this.position - 1];	
		int indexResult = 0;
		int indexById = findIndexById(id);
		for (int i = 0; i < this.position; i++) {
			if (i != indexById) {
				result[indexResult++] = this.items[i];
			}
		}
		this.position--;
		this.items = Arrays.copyOf(result, this.items.length);
	}	
}
