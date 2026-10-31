package week_8.set_1;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.*;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract LocalDate calculateDueDate(LocalDate baseDate);

    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {
    public Book(String title) { super(title); }
    @Override
    public LocalDate calculateDueDate(LocalDate baseDate) { return baseDate.plusDays(14); }
}

class DVD extends LibraryItem {
    public DVD(String title) { super(title); }
    @Override
    public LocalDate calculateDueDate(LocalDate baseDate) { return baseDate.plusDays(7); }
}

class Magazine extends LibraryItem {
    public Magazine(String title) { super(title); }
    @Override
    public LocalDate calculateDueDate(LocalDate baseDate) { return baseDate.plusDays(3); }
}

public class P2_LibraryDueDate {
    public static void main(String[] args) {
        String[] lines = {
            "BOOK \"1984\"",
            "DVD \"The Matrix\"",
            "MAGAZINE \"Forbes Issue 500\""
        };

        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        List<LibraryItem> items = new ArrayList<>();

        Pattern pattern = Pattern.compile("^(\\S+)\\s+\"([^\"]+)\"");
        for (String line : lines) {
            Matcher m = pattern.matcher(line);
            if (m.find()) {
                String type = m.group(1);
                String title = m.group(2);
                if (type.equals("BOOK")) items.add(new Book(title));
                else if (type.equals("DVD")) items.add(new DVD(title));
                else if (type.equals("MAGAZINE")) items.add(new Magazine(title));
            }
        }

        for (LibraryItem item : items) {
            System.out.printf("%s: %s\n", item.getTitle(), item.calculateDueDate(currentDate));
        }
    }
}