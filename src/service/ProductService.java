package service;

import domain.Product;

import java.util.ArrayList;

public interface ProductService {
    ArrayList<Product> PRODUCTS = new ArrayList<>();
    void addProduct(String name, Integer amount, Integer categoryId);
    void deleteProduct(Integer productId);
    void editProduct(Integer id, String newName, Integer amount, Integer categoryId);
    void showAll();
}
