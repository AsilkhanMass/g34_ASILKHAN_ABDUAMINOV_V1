package service.imp;

import service.ProductService;
import domain.Product;

import java.time.LocalDateTime;

public class ProductServiceImp implements ProductService {
    {
        Product product = new Product("Iphone", 5, 1);
        Product product1 = new Product("myaso", 3, 2);
        PRODUCTS.add(product1);
        PRODUCTS.add(product);
    }
    @Override
    public void addProduct(String name, Integer amount, Integer categoryId) {
        for(Product product:PRODUCTS){
            if(product.getName().equals(name)){
                System.out.println("Such product already exist!");
            }
        }
        Product myProduct = new Product(name,amount,categoryId);
        PRODUCTS.add(myProduct);
    }

    @Override
    public void deleteProduct(Integer productId) {
        for(Product product:PRODUCTS){
            if(product.getId().equals(productId)){
                PRODUCTS.remove(product);
                return;
            }
        }
        System.out.println("No such product!");
    }

    @Override
    public void editProduct(Integer id, String newName, Integer amount, Integer categoryId) {
        for(Product product:PRODUCTS){
            if(product.getId().equals(id)){
                product.setName(newName);
                product.setAmount(amount);
                product.setCategoryId(categoryId);
                product.setUpdateTime(LocalDateTime.now());
                return;
            }
        }
        System.out.println("No such product found!");

    }

    @Override
    public void showAll() {
        for (Product product:PRODUCTS){
            System.out.println(product.getId()+ ". " + product);
        }
    }
}
