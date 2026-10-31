import java.util.List;

public class Problem1_LibraryCatalogLookup {

    public static class BookRecord {
        public String isbn;
        public String title;

        public BookRecord(String isbn, String title) {
            this.isbn = isbn;
            this.title = title;
        }
    }

    public static String findBook(List<BookRecord> catalog, String targetIsbn) {
        int left = 0;
        int right = catalog.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = catalog.get(mid).isbn.compareTo(targetIsbn);

            if (cmp == 0) {
                return catalog.get(mid).title;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        List<BookRecord> catalog = List.of(
            new BookRecord("0001112223", "Introduction to Algebra"),
            new BookRecord("0002223334", "Beginning Python"),
            new BookRecord("0003334445", "Classic Mythology"),
            new BookRecord("0004445556", "Data and Society"),
            new BookRecord("0005556667", "European History")
        );

        System.out.println(findBook(catalog, "0003334445"));
        System.out.println(findBook(catalog, "0009998887"));
    }
}