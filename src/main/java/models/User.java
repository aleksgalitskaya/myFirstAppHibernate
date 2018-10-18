package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "users")
public class User {
    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int age;
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Auto> autos;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
        autos = new ArrayList<Auto>();
    }

    public void addAuto(Auto auto){
        autos.add(auto);
        auto.setUser(this);
    }

    public void removeAuto(Auto auto){
        autos.remove(auto);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    @Override
    public String toString() {
        return "models.User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", autos=" + autos +
                '}';
    }
}
