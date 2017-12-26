package com.example.challenge.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=5, max=25)
    @Column(name = "name")
    private String name;

    @NotNull
    @Size(min=5, max=255)
    @Column(name = "description")
    private String description;

    public Brand() {}

    public Brand(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
