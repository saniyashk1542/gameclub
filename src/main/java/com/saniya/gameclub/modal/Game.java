package com.saniya.gameclub.modal;

import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "games")

public class Game {
    @Id
    private String id;
    private String name;
    private String description;
    private String price;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public Game(String id, String name, String description, String price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public Game() {
    }
    @Override
    public String toString() {
        return "Game [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", getId()="
                + getId() + ", getName()=" + getName() + ", getDescription()=" + getDescription() + ", getPrice()="
                + getPrice() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }
}
