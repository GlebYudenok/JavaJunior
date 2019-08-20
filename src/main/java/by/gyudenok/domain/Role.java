package by.gyudenok.domain;

public enum Role {
    ADMIN("admin"),
    MANAGER("manager"),
    USER("user");

    private String name;

    private Role(final String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return ordinal();
    }

    public static Role getById(final int id){
        return Role.values()[id];
    }
}
