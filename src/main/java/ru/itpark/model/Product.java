package ru.itpark.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class Product implements Comparable<Product> {
    private int id;
    private String name;
    private String category;
    private int rating;
    private int price;

    @Override
    public int compareTo(Product o) {
        return price - o.price;
    }
}
