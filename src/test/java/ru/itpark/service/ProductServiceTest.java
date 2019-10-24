package ru.itpark.service;

import org.junit.jupiter.api.Test;
import ru.itpark.model.Product;
import ru.itpark.model.Smartphone;
import ru.itpark.model.Tv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {
    private ProductService service = new ProductService();
    List<Product> target;
    List<Product> result;
    boolean test;

    {
        service.add(
                new Smartphone(1, "Xiaomi b", "смартфоны", 1, 8000),
                new Smartphone(2, "Xiaomi c", "смартфоны", 3, 9000),
                new Smartphone(3, "Xiaomi a", "смартфоны", 2, 6000),
                new Smartphone(4, "Xiaomi d", "смартфоны", 2, 7000),
                new Smartphone(5, "Xiaomi e", "смартфоны", 4, 2000),
                new Tv(6, "LG a", "телевизоры", 5, 15000),
                new Tv(7, "LG g", "телевизоры", 5, 47000),
                new Tv(8, "LG e", "телевизоры", 3, 9000),
                new Tv(9, "LG v", "телевизоры", 4, 13000),
                new Tv(10, "LG m", "телевизоры", 5, 17000)
        );
    }

    @Test
    void add() {
        assertEquals(10, service.getProducts().size());
    }

    @Test
    void searchByName() {
        target = new ArrayList<>(Arrays.asList(
                new Smartphone(1, "Xiaomi b", "смартфоны", 1, 8000),
                new Smartphone(2, "Xiaomi c", "смартфоны", 3, 9000),
                new Smartphone(3, "Xiaomi a", "смартфоны", 2, 6000),
                new Smartphone(4, "Xiaomi d", "смартфоны", 2, 7000),
                new Smartphone(5, "Xiaomi e", "смартфоны", 4, 2000))
        );
        result = service.searchByName("Xia");
        if (target.containsAll(result) && result.containsAll(target)) {
            test = true;
        } else {
            test = false;
        }
        assertTrue(test);
    }

    @Test
    void searchByCategory() {
        target = new ArrayList<>(Arrays.asList(
                new Tv(6, "LG a", "телевизоры", 5, 15000),
                new Tv(7, "LG g", "телевизоры", 5, 47000),
                new Tv(8, "LG e", "телевизоры", 3, 9000),
                new Tv(9, "LG v", "телевизоры", 4, 13000),
                new Tv(10, "LG m", "телевизоры", 5, 17000))
        );
        result = service.searchByCategory("телевизоры");
        if (target.containsAll(result) && result.containsAll(target)) {
            test = true;
        } else {
            test = false;
        }
        assertTrue(test);
    }

    @Test
    void searchByIndex() {
        target = new ArrayList<>(Arrays.asList(
                new Smartphone(3, "Xiaomi a", "смартфоны", 2, 6000),
                new Smartphone(4, "Xiaomi d", "смартфоны", 2, 7000),
                new Smartphone(5, "Xiaomi e", "смартфоны", 4, 2000),
                new Tv(6, "LG a", "телевизоры", 5, 15000),
                new Tv(7, "LG g", "телевизоры", 5, 47000))
        );
        result = service.searchByIndex(2, 7);
        if (target.containsAll(result) && result.containsAll(target)) {
            test = true;
        } else {
            test = false;
        }
        assertTrue(test);
    }

    @Test
    void sortByName() {
        target = new ArrayList<>(Arrays.asList(
                new Tv(6, "LG a", "телевизоры", 5, 15000),
                new Tv(8, "LG e", "телевизоры", 3, 9000),
                new Tv(7, "LG g", "телевизоры", 5, 47000),
                new Tv(10, "LG m", "телевизоры", 5, 17000),
                new Tv(9, "LG v", "телевизоры", 4, 13000),
                new Smartphone(3, "Xiaomi a", "смартфоны", 2, 6000),
                new Smartphone(1, "Xiaomi b", "смартфоны", 1, 8000),
                new Smartphone(2, "Xiaomi c", "смартфоны", 3, 9000),
                new Smartphone(4, "Xiaomi d", "смартфоны", 2, 7000),
                new Smartphone(5, "Xiaomi e", "смартфоны", 4, 2000))
        );
        List<Product> result = service.sortByName();
        for (int i = 0; i < target.size(); i++) {
            if (result.get(i).getId() == target.get(i).getId()) {
                test = true;
            } else {
                test = false;
                break;
            }
        }
        assertTrue(test);
    }

    @Test
    void sortByRating() {
        target = new ArrayList<>(Arrays.asList(
                new Tv(6, "LG a", "телевизоры", 5, 15000),
                new Tv(7, "LG g", "телевизоры", 5, 47000),
                new Tv(10, "LG m", "телевизоры", 5, 17000),
                new Smartphone(5, "Xiaomi e", "смартфоны", 4, 2000),
                new Tv(9, "LG v", "телевизоры", 4, 13000),
                new Smartphone(2, "Xiaomi c", "смартфоны", 3, 9000),
                new Tv(8, "LG e", "телевизоры", 3, 9000),
                new Smartphone(3, "Xiaomi a", "смартфоны", 2, 6000),
                new Smartphone(4, "Xiaomi d", "смартфоны", 2, 7000),
                new Smartphone(1, "Xiaomi b", "смартфоны", 1, 8000))
        );
        List<Product> result = service.sortByRating();
        for (int i = 0; i < target.size(); i++) {
            if (result.get(i).getId() == target.get(i).getId()) {
                test = true;
            } else {
                test = false;
                break;
            }
        }
        assertTrue(test);
    }

    @Test
    void sortByPrice() {
        target = new ArrayList<>(Arrays.asList(
                new Smartphone(5, "Xiaomi e", "смартфоны", 4, 2000),
                new Smartphone(3, "Xiaomi a", "смартфоны", 2, 6000),
                new Smartphone(4, "Xiaomi d", "смартфоны", 2, 7000),
                new Smartphone(1, "Xiaomi b", "смартфоны", 1, 8000),
                new Smartphone(2, "Xiaomi c", "смартфоны", 3, 9000),
                new Tv(8, "LG e", "телевизоры", 3, 9000),
                new Tv(9, "LG v", "телевизоры", 4, 13000),
                new Tv(6, "LG a", "телевизоры", 5, 15000),
                new Tv(10, "LG m", "телевизоры", 5, 17000),
                new Tv(7, "LG g", "телевизоры", 5, 47000))
        );
        List<Product> result = service.sortByPrice();
        for (int i = 0; i < target.size(); i++) {
            if (result.get(i).getId() == target.get(i).getId()) {
                test = true;
            } else {
                test = false;
                break;
            }
        }
        assertTrue(test);
    }
}