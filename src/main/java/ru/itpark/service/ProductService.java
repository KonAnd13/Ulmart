package ru.itpark.service;

import ru.itpark.comparator.SearchByNameAscComparator;
import ru.itpark.comparator.SearchByRatingDescComparator;
import ru.itpark.model.Product;

import java.util.*;

public class ProductService {
    private final List<Product> products = new ArrayList<>();

    //created for ease of testing
    public List<Product> getProducts() {
        return products;
    }

    public void add(Product ... product) {
        Collections.addAll(products, product);
    }

    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().startsWith(name)) {
                result.add(product);
            }
        }
        result.sort(new SearchByNameAscComparator());
        return result;
    }

    public List<Product> searchByCategory(String category) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                result.add(product);
            }
        }
        result.sort(new SearchByNameAscComparator());
        return result;
    }

    public List<Product> searchByIndex(int fromIndex, int toIndex) {
        List<Product> result = new ArrayList<>();
        if (products.size() > toIndex) {
            for (int i = fromIndex; i < toIndex; i++) {
                    result.add(products.get(i));
            }
        } else if (products.size() > fromIndex) {
            for (int i = fromIndex; i < products.size(); i++) {
                result.add(products.get(i));
            }
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
