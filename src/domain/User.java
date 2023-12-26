package domain;

import enums.RoleEnum;

import javax.management.relation.Role;
import java.time.LocalDateTime;

public class User {
    private static Integer sequence = 0;
    {
        sequence++;
    }
    private Integer id = sequence;
    private String name;
    private String password;
    private Integer limit;
    {
        limit = 10;
    }
    private final LocalDateTime userCreatedTime= LocalDateTime.now();
    private LocalDateTime userUpdatedTime;
    private RoleEnum role = RoleEnum.CUSTOMER;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public Integer getLimit() {
        return limit;
    }
    public void minusLimit(){
        this.limit--;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getUserUpdatedTime() {
        return userUpdatedTime;
    }

    public void setUserUpdatedTime(LocalDateTime userUpdatedTime) {
        this.userUpdatedTime = userUpdatedTime;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}

