package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "operators")
public class Operator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


    public Service_provider getService_provider() {
        return service_provider;
    }

    public void setService_provider(Service_provider service_provider) {
        this.service_provider = service_provider;
    }

    @ManyToOne()
    @JoinColumn(name = "service_provider_id")
    private Service_provider service_provider;

    @Override
    public String toString() {
        return "Operator{" + "id=" + id + ", name='" + name + '\'' + ", service_provider=" + service_provider + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
