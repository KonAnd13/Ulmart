package ru.itpark.comparator;

import ru.itpark.model.Product;

import java.util.Comparator;

public class SearchByRatingDescComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        int i = - (o1.getRating() - o2.getRating());
        if (i != 0) {
            return i;
        }
        return o1.getPrice() - o2.getPrice();
    }
}
