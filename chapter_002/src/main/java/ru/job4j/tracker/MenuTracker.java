package ru.job4j.tracker;
import java.util.ArrayList;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 07.09.2018
 */

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private String ln = System.lineSeparator();
    private ArrayList<UserAction> listActions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    public void fillActions() {
        listActions.add(new AddItem(0));
        listActions.add(new ShowAllItem(1));
        listActions.add(new EditItem(2));
        listActions.add(new DeleteItem(3));
        listActions.add(new FindByIdItem(4));
        listActions.add(new FinfByNameItem(5));
        listActions.add(new Exit(6));
    }
    public void select(int key) {
        this.listActions.get(key).execute(this.input, this.tracker);
    }
    public void show() {
        for (UserAction action: this.listActions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    private void showAllItems(Item[] items) {
        if (items.length != 0) {
            for (int i = 0; i < items.length; i++) {
                System.out.print("id: " + items[i].getId() + ". ");
                System.out.print("Name: " + items[i].getName() + ". ");
                System.out.print("Description: " + items[i].getDescription() + ". ");
                System.out.print("Date create: " + items[i].getCreate() + ln);
            }
        } else {
            System.out.println("Список пуст");
        }
    }
    private class AddItem implements UserAction {
        private int key;
        private AddItem(int key) {
            this.key = key;
        }
      @Override
       public int key() {
           return this.key;
       }

       @Override
       public void execute(Input input, Tracker tracker) {
           System.out.println();
           String name = input.ask("Please enter the task name: ");
           String desc = input.ask("Please enter the task description: ");
           tracker.add(new Item(name, desc));
       }

       @Override
       public String info() {
           return String.format("%s: %s", this.key(), "ADD");
       }
   }
    private class ShowAllItem implements UserAction {
       private int key;
       private ShowAllItem(int key) {
           this.key = key;
       }
       @Override
       public int key() {
           return this.key;
       }

       @Override
       public void execute(Input input, Tracker tracker) {
           Item[] items = tracker.getAll();
           System.out.println("You selection SHOW_ALL");
           showAllItems(items);
       }

       @Override
       public String info() {
           return String.format("%s: %s", this.key(), "SHOW_ALL");
       }
   }
    private class EditItem implements UserAction {
       private int key;
       private EditItem(int key) {
           this.key = key;
       }
        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("You selection EDIT");
            String id = input.ask("input id item:");
            String name = input.ask("input new name:");
            String desc = input.ask("input new description:");
            Item item = new Item(name, desc);
            if (tracker.edit(id, item)) {
                System.out.println("Item is update");
            } else {
                System.out.println("Item with id: " + id + " not found");
            }
        }

        @Override
        public String info() {
            return String.format("%s: %s", this.key(), "EDIT");
        }
    }
    private class DeleteItem implements UserAction {
       private int key;
       private DeleteItem(int key) {
           this.key = key;
       }
        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("You selection DELETE");
            String id = input.ask("input id item:");
            if (tracker.remove(id)) {
                System.out.println("Item remove");
            } else {
                System.out.println("Item not found");
            }
        }

        @Override
        public String info() {
            return String.format("%s: %s", this.key(), "DELETE");
        }
    }
    private class FindByIdItem implements UserAction {
       private int key;
       private FindByIdItem(int key) {
           this.key = key;
       }
        @Override
        public int key() {
            return this.key;
        }

        private String toStringItem(String id, String name, String desc, String create) {
            return String.format("Item id: %s, Name: %s, Description: %s Create: %s", id, name, desc, create);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("You selection FIND_BY_ID");
            String id = input.ask("input id item:");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(toStringItem(item.getId(), item.getName(), item.getDescription(), item.getCreate()));
            } else {
                System.out.println("По данному id: " + id + " заявок не найдено");
            }
        }

        @Override
        public String info() {
            return String.format("%s: %s", this.key(), "FIND_BY_ID");
        }
   }
    private class FinfByNameItem implements UserAction {
       private int key;
       private FinfByNameItem(int key) {
           this.key = key;
       }
       @Override
       public int key() {
           return this.key;
       }

       @Override
       public void execute(Input input, Tracker tracker) {
           System.out.println("You selection FIND_BY_NAME");
           String name = input.ask("input name:");
           Item[] items = tracker.findByName(name);
           showAllItems(items);
       }

       @Override
       public String info() {
           return String.format("%s: %s", this.key(), "FIND_BY_NAME");
       }
   }
    private static class Exit implements UserAction  {
       private int key;
       private Exit(int key) {
           this.key = key;
       }
       @Override
       public int key() {
            return this.key;
       }
        @Override
       public void execute(Input input, Tracker tracker) {
            System.out.println("You selection EXIT");
            System.out.println("Goode bye");
            System.exit(0);
       }
        @Override
       public String info() {
            return String.format("%s: %s", this.key(), "EXIT");
       }
    }



}
