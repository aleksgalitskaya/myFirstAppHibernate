package models;


import javax.persistence.*;

@Entity
@Table(name = "autos")
public class Auto {
    public Auto() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "model")
    private String model;

    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Auto(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public User getUser() {
        return user;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
