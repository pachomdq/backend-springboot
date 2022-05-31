package com.portfolio.apis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Portfolio {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String src;
    private String thumb;
    private String caption;

    public Portfolio() {
    }

    public Portfolio(int id, String src, String thumb, String caption) {
        this.id = id;
        this.src = src;
        this.thumb = thumb;
        this.caption = caption;
    }    
}
