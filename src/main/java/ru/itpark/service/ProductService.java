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

    private int startIndex = 0;
    private int endIndex = 10;
    private boolean end = false;
    private boolean start = false;
    public List<Product> nextPage() {
        List<Product> result = new ArrayList<>();
        if (!end) {
            if (products.size() > endIndex) {
                result = products.subList(startIndex, endIndex);
                startIndex += 10;
                endIndex += 10;
            } else if (products.size() == endIndex) {
                result = products.subList(startIndex, endIndex);
                end = true;
            } else if (products.size() > startIndex) {
                result = products.subList(startIndex, products.size());
                end = true;
            }
        } else {
            result = products.subList(startIndex, products.size());
        }
        start = false;
        return result;
    }

    public List<Product> previousPage() {
        List<Product> result = new ArrayList<>();
        if (!start) {
            if (startIndex > 0) {
                startIndex -= 10;
                endIndex -= 10;
                result = products.subList(startIndex, endIndex);
            } else if (startIndex == 0 && products.size() >= endIndex) {
                result = products.subList(startIndex, endIndex);
                start = true;
            } else {
                result = products.subList(startIndex, products.size());
                start = true;
            }
        }
        end = false;
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
