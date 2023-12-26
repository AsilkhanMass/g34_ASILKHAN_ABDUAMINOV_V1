package enums;

import javax.management.relation.Role;

public enum RoleEnum {
    OWNER(1,"Owner"),
    CUSTOMER(2,"Customer");

    final int index;
    final String name;

    RoleEnum(int index, String name) {
        this.index = index;
        this.name = name;
    }
    public static RoleEnum getByIndex(int index){
        RoleEnum[] roleEnums = RoleEnum.values();
        for(RoleEnum role:roleEnums){
            if(role.index==index){
                return role;
            }
        }
        return CUSTOMER;
    }
}
