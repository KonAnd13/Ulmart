package ru.itpark.service;

import ru.itpark.comparator.SearchByNameAscComparator;
import ru.itpark.comparator.SearchByRatingDescComparator;
import ru.itpark.model.Product;

import java.util.*;

public class ProductService {
    private final List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void add(Product ... product) {
        Collections.addAll(products, product);
    }

    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().startsWith(name.toLowerCase())) {
                result.add(product);
            }
        }
        result.sort(new SearchByNameAscComparator());
        return result;
    }

    public List<Product> searchByCategory(String category) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().toLowerCase().equals(category.toLowerCase())) {
                result.add(product);
            }
        }
        result.sort(new SearchByNameAscComparator());
        return result;
    }

    public List<Product> pageOfProducts(int fromIndex, int toIndex) {
        List<Product> result = new ArrayList<>();
        if (products.size() >= toIndex) {
            result = products.subList(fromIndex, toIndex);
        } else if (products.size() > fromIndex) {
            result = products.subList(fromIndex, products.size());
        }
        Collections.sort(result);
        return result;
    }

    public List<Product> sortByName() {
        List<Product> result = new ArrayList<>(products);
        result.sort(new SearchByNameAscComparator());
        return result;
    }

    public List<Product> sortByRating() {
        List<Product> result = new ArrayList<>(products);
        result.sort(new SearchByRatingDescComparator());
        return result;
    }

    public List<Product> sortByPrice() {
        List<Product> result = new ArrayList<>(products);
        Collections.sort(result);
        return result;
    }
}
