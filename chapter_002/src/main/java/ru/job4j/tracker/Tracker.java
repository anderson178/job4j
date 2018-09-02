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
	 * @item - заявка
	 */
	public boolean edit(String id, Item item) {
		boolean result = false;
		for (int i = 0; i < this.position; i++) {
			if (this.items[i].getId().equals(id)) {
				item.setId(this.items[i].getId());
				item.setCreate(this.items[i].getCreate());
				this.items[i] = item;
				result = true;
				break;
			}
		}
		return result;
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
		Item[] result = new Item[this.position];
		for (int i = 0; i < this.position; i++) {
			if (this.items[i].getName().equals(keyName)) {
				result[index++] = this.items[i];
			}
		}					
		return (Arrays.copyOf(result, index));
	}

	/**
	 * метод удаления заявки по id
	 * @param id - идентификатор заявки
	 * @return
	 */
	public boolean remove(String id) {
		boolean res = false;
		for (int i = 0; i < this.position; i++) {
			if (this.items[i].getId().equals(id)) {
				System.arraycopy(this.items, i + 1, this.items, i, this.items.length - i - 1);
				res = true;
				this.position--;
				break;
			}
		}
		return res;
	}	
}
