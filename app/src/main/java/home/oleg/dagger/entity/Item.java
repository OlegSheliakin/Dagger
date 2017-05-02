package home.oleg.dagger.entity;

import android.support.annotation.NonNull;

import java.util.Date;

/**
 * Created by Oleg on 22.04.2017.
 */

public class Item implements ItemInterface{

    private Long id;
    private String name;
    private String description;
    private Date createdAt = new Date();
    private Date updatedAt = new Date();

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isExpired() {
        return true;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int compareTo(@NonNull ItemInterface o) {
        return getName().compareTo(o.getName());
    }
}
