public class LibraryCatalogTest {
    public static void main(String[] args) {
        LibraryCatalog<LibraryItem> catalog = new LibraryCatalog<>();
        
        // Test adding items
        LibraryItem book = new LibraryItem("Java Programming", "John Doe", 1);
        catalog.addItem(book);
        assert catalog.getAllItems().contains(book);

        // Test removing items
        catalog.removeItem(1);
        assert !catalog.getAllItems().contains(book);

        // Test retrieving item details
        LibraryItem dvd = new LibraryItem("Inception", "Christopher Nolan", 2);
        catalog.addItem(dvd);
        assert catalog.getItemDetails(2).equals(dvd);
        
        System.out.println("All tests passed.");
    }
}
