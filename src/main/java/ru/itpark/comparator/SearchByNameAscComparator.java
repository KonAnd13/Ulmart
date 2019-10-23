package ru.itpark.comparator;

import ru.itpark.model.Product;

import java.util.Comparator;

public class SearchByNameAscComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
