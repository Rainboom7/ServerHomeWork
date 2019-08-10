/*
 * This file is generated by jOOQ.
 */
package db.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Products implements Serializable {

    private static final long serialVersionUID = 1035821518;

    private final Integer id;
    private final String  name;
    private final String  company;
    private final Integer quantity;

    public Products(Products value) {
        this.id = value.id;
        this.name = value.name;
        this.company = value.company;
        this.quantity = value.quantity;
    }

    public Products(
        Integer id,
        String  name,
        String  company,
        Integer quantity
    ) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.quantity = quantity;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCompany() {
        return this.company;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Products (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(company);
        sb.append(", ").append(quantity);

        sb.append(")");
        return sb.toString();
    }
}
