package ru.itpark.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.itpark.model.Product;
import ru.itpark.model.Smartphone;
import ru.itpark.model.Tv;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {
    private ProductService service = new ProductService();
    private List<Product> target;
    private List<Product> result;

    @BeforeEach
    void initial() {
        service.add(
                new Smartphone(1, "Xiaomi b", "смартфоны", 1, 8000),
                new Smartphone(2, "Xiaomi c", "смартфоны", 3, 10000),
                new Smartphone(3, "Xiaomi a", "смартфоны", 2, 6000),
                new Smartphone(4, "Xiaomi d", "смартфоны", 2, 7000),
                new Smartphone(5, "Xiaomi e", "смартфоны", 4, 2000),
                new Smartphone(6, "Xiaomi f", "смартфоны", 5, 1500),
                new Smartphone(7, "Xiaomi g", "смартфоны", 5, 1500),
                new Tv(8, "LG a", "телевизоры", 5, 15000),
                new Tv(9, "LG g", "телевизоры", 5, 47000),
                new Tv(10, "LG e", "телевизоры", 3, 9000),
                new Tv(11, "LG v", "телевизоры", 4, 13000),
                new Tv(12, "LG m", "телевизоры", 5, 17000)
        );
    }

    @Test
    void add() {
        assertEquals(12, service.getProducts().size());
    }

    @Test
    void searchByName() {
        target = Arrays.asList(
                new Smartphone(3, "Xiaomi a", "смартфоны", 2, 6000),
                new Smartphone(1, "Xiaomi b", "смартфоны", 1, 8000),
                new Smartphone(2, "Xiaomi c", "смартфоны", 3, 10000),
                new Smartphone(4, "Xiaomi d", "смартфоны", 2, 7000),
                new Smartphone(5, "Xiaomi e", "смартфоны", 4, 2000),
                new Smartphone(6, "Xiaomi f", "смартфоны", 5, 1500),
                new Smartphone(7, "Xiaomi g", "смартфоны", 5, 1500)
        );
        result = service.searchByName("Xia");
        assertEquals(target, result);
    }

    @Test
    void searchByCategory() {
        target = Arrays.asList(
                new Tv(8, "LG a", "телевизоры", 5, 15000),
                new Tv(10, "LG e", "телевизоры", 3, 9000),
                new Tv(9, "LG g", "телевизоры", 5, 47000),
                new Tv(12, "LG m", "телевизоры", 5, 17000),
                new Tv(11, "LG v", "телевизоры", 4, 13000)
        );
        result = service.searchByCategory("телевизоры");
        assertEquals(target, result);
    }

    @Test
    void pageOfProducts() {
        target = Arrays.asList(
                new Smartphone(6, "Xiaomi f", "смартфоны", 5, 1500),
                new Smartphone(7, "Xiaomi g", "смартфоны", 5, 1500),
                new Smartphone(5, "Xiaomi e", "смартфоны", 4, 2000),
                new Smartphone(3, "Xiaomi a", "смартфоны", 2, 6000),
                new Smartphone(4, "Xiaomi d", "смартфоны", 2, 7000),
                new Tv(8, "LG a", "телевизоры", 5, 15000)
        );
        result = service.pageOfProducts(2, 8);
        assertEquals(target, result);
    }

    @Test
    void sortByName() {
        target = Arrays.asList(
                new Tv(8, "LG a", "телевизоры", 5, 15000),
                new Tv(10, "LG e", "телевизоры", 3, 9000),
                new Tv(9, "LG g", "телевизоры", 5, 47000),
                new Tv(12, "LG m", "телевизоры", 5, 17000),
                new Tv(11, "LG v", "телевизоры", 4, 13000),
                new Smartphone(3, "Xiaomi a", "смартфоны", 2, 6000),
                new Smartphone(1, "Xiaomi b", "смартфоны", 1, 8000),
                new Smartphone(2, "Xiaomi c", "смартфоны", 3, 10000),
                new Smartphone(4, "Xiaomi d", "смартфоны", 2, 7000),
                new Smartphone(5, "Xiaomi e", "смартфоны", 4, 2000),
                new Smartphone(6, "Xiaomi f", "смартфоны", 5, 1500),
                new Smartphone(7, "Xiaomi g", "смартфоны", 5, 1500)
        );
        result = service.sortByName();
        assertEquals(target, result);
    }

    @Test
    void sortByRating() {
        target = Arrays.asList(
                new Smartphone(6, "Xiaomi f", "смартфоны", 5, 1500),
                new Smartphone(7, "Xiaomi g", "смартфоны", 5, 1500),
                new Tv(8, "LG a", "телевизоры", 5, 15000),
                new Tv(12, "LG m", "телевизоры", 5, 17000),
                new Tv(9, "LG g", "телевизоры", 5, 47000),
                new Smartphone(5, "Xiaomi e", "смартфоны", 4, 2000),
                new Tv(11, "LG v", "телевизоры", 4, 13000),
                new Tv(10, "LG e", "телевизоры", 3, 9000),
                new Smartphone(2, "Xiaomi c", "смартфоны", 3, 10000),
                new Smartphone(3, "Xiaomi a", "смартфоны", 2, 6000),
                new Smartphone(4, "Xiaomi d", "смартфоны", 2, 7000),
                new Smartphone(1, "Xiaomi b", "смартфоны", 1, 8000)
        );
        result = service.sortByRating();
        assertEquals(target, result);
    }

    @Test
    void sortByPrice() {
        target = Arrays.asList(
                new Smartphone(6, "Xiaomi f", "смартфоны", 5, 1500),
                new Smartphone(7, "Xiaomi g", "смартфоны", 5, 1500),
                new Smartphone(5, "Xiaomi e", "смартфоны", 4, 2000),
                new Smartphone(3, "Xiaomi a", "смартфоны", 2, 6000),
                new Smartphone(4, "Xiaomi d", "смартфоны", 2, 7000),
                new Smartphone(1, "Xiaomi b", "смартфоны", 1, 8000),
                new Tv(10, "LG e", "телевизоры", 3, 9000),
                new Smartphone(2, "Xiaomi c", "смартфоны", 3, 10000),
                new Tv(11, "LG v", "телевизоры", 4, 13000),
                new Tv(8, "LG a", "телевизоры", 5, 15000),
                new Tv(12, "LG m", "телевизоры", 5, 17000),
                new Tv(9, "LG g", "телевизоры", 5, 47000)
        );
        result = service.sortByPrice();
        assertEquals(target, result);
    }
}