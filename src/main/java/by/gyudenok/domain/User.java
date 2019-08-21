package by.gyudenok.domain;

import java.util.List;

public class User {
    private int userId;
    private String name;
    private String surname;
    private String email;
    private List<String> phones;
    private List<Role> roles;

    public User(){

    }

    public User(String name, String surname, String email,
                List<String> phones, List<Role> roles) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phones = phones;
        this.roles = roles;
        userId = hashCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (phones != null ? !phones.equals(user.phones) : user.phones != null) return false;
        return roles != null ? roles.equals(user.roles) : user.roles == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phones != null ? phones.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phones=" + phones +
                ", roles=" + roles +
                '}';
    }
}
