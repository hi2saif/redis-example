package com.thebadengineer.cache.springredisexample;

import java.io.Serializable;

//If this error comes  DefaultSerializer requires a Serializable payload but received an object of type [...]
//it means the model class should implement Serializable because The Java object to be cached must implement the Serializable interface, because Spring will serialize the object and store it in Redis.
public class User implements Serializable {
    private String id;

    public String getId() {
        return id;
    }

    public User(String id, String name, Long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
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

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    private String name;
    private Long salary;
}
