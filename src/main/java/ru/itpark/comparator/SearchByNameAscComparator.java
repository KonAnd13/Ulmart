package ru.itpark.comparator;

import ru.itpark.model.Product;

import java.util.Comparator;

public class SearchByNameAscComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        int i = o1.getName().compareTo(o2.getName());
        if (i != 0) {
            return i;
        }
        return o1.getPrice() - o2.getPrice();
    }
}
