package service;

import domain.Category;

import java.util.ArrayList;

public interface CategoryService {
    ArrayList<Category> CATEGORIES = new ArrayList<>();
    void addCategory(String name);
    void editCategory(String name, String newName);
    void showAllCategory();
}
