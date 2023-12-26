package service.imp;

import service.CategoryService;
import domain.Category;

public class CategoryServiceImp implements CategoryService {
    {
        Category category = new Category("tech");
        Category category1 = new Category("food");
        CATEGORIES.add(category);
        CATEGORIES.add(category1);
    }
    @Override
    public void addCategory(String name) {
        for(Category category:CATEGORIES){
            if(category.getCategoryName().equals(name)){
                System.out.println("Such category already exist");
                return;
            }
        }
        Category myCategory = new Category(name);
        CATEGORIES.add(myCategory);

    }

    @Override
    public void editCategory(String name, String newName) {
        for(Category category:CATEGORIES){
            if(category.getCategoryName().equals(name)){
                category.setCategoryName(newName);
                return;
            }
        }
        System.out.println("No such category exist!");
    }

    @Override
    public void showAllCategory() {
        for(Category category: CATEGORIES){
            System.out.println(category.getId()+ ". " + category);
        }
    }
}
