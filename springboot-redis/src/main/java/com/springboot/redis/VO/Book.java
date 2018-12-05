package com.springboot.redis.VO;

import java.io.Serializable;

public class Book implements Serializable {

    private  String name ;
    private  String autor;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }

    public Book(String name, String autor) {
        this.name = name;
        this.autor = autor;
    }

    public Book() {

    }

    public String getAutor() {

        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
