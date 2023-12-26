package domain;

public class Category {
    private static Integer sequence = 0;
    {
        sequence++;
    }
    private Integer id = sequence;
    private String categoryName;


    public Category(String categoryName) {
        this.categoryName = categoryName;


    }

    public Integer getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "categoryName='" + categoryName;
    }
}
