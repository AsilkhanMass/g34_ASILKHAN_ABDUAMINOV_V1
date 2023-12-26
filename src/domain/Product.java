package domain;

import java.time.LocalDateTime;

public class Product {
    private static Integer sequence = 0;
    {
        sequence++;
    }
    private Integer id = sequence;
    private String name;
    private Integer amount;
    private Integer categoryId;
    private final LocalDateTime currentTime = LocalDateTime.now();
    private LocalDateTime updateTime;


    public Product(String name, Integer amount, Integer categoryId) {
        this.name = name;
        this.amount = amount;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public Product(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Id=" +id+ '\'' +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", categoryId=" + categoryId;
    }
}
