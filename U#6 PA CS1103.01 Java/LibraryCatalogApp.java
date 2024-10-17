import java.util.Scanner;

public class LibraryCatalogApp {
    public static void main(String[] args) {
        LibraryCatalog<LibraryItem> catalog = new LibraryCatalog<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. View Item Details");
            System.out.println("4. View All Items");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Item ID: ");
                    int itemID = scanner.nextInt();
                    scanner.nextLine();
                    LibraryItem item = new LibraryItem(title, author, itemID);
                    catalog.addItem(item);
                    System.out.println("Item added.");
                    break;
                case 2:
                    System.out.print("Enter Item ID to remove: ");
                    int removeID = scanner.nextInt();
                    catalog.removeItem(removeID);
                    break;
                case 3:
                    System.out.print("Enter Item ID to view: ");
                    int viewID = scanner.nextInt();
                    LibraryItem viewItem = catalog.getItemDetails(viewID);
                    if (viewItem != null) {
                        System.out.println(viewItem);
                    }
                    break;
                case 4:
                    for (LibraryItem libraryItem : catalog.getAllItems()) {
                        System.out.println(libraryItem);
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
