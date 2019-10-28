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
        Collections.sort(products);
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

    private int firstIndex = 0;
    private int lastIndex = 10;
    private boolean end = false;
    private boolean start = false;
    public List<Product> nextPage() {
        List<Product> result = new ArrayList<>();
        if (!end) {
            if (products.size() > lastIndex) {
                result = products.subList(firstIndex, lastIndex);
                int i = lastIndex;
                lastIndex += 10;
                firstIndex = i;
            } else if (products.size() == lastIndex) {
                result = products.subList(firstIndex, lastIndex);
                end = true;
            } else if (products.size() > firstIndex) {
                result = products.subList(firstIndex, products.size());
                end = true;
            }
        } else {
            result = products.subList(firstIndex, products.size());
        }
        start = false;
        return result;
    }

    public List<Product> previousPage() {
        List<Product> result = new ArrayList<>();
        if (!start) {
            if (firstIndex > 0) {
                firstIndex -= 10;
                lastIndex -= 10;
                result = products.subList(firstIndex, lastIndex);
            } else if (firstIndex == 0 && products.size() >= lastIndex) {
                result = products.subList(firstIndex, lastIndex);
                start = true;
            } else {
                result = products.subList(firstIndex, products.size());
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
