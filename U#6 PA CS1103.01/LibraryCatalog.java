import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog<T extends LibraryItem> {
    private List<T> items;

    public LibraryCatalog() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(int itemID) {
        boolean removed = items.removeIf(item -> item.getItemID() == itemID);
        if (!removed) {
            System.out.println("Item not found.");
        }
    }

    public T getItemDetails(int itemID) {
        for (T item : items) {
            if (item.getItemID() == itemID) {
                return item;
            }
        }
        System.out.println("Item not found.");
        return null;
    }

    public List<T> getAllItems() {
        return items;
    }
}
