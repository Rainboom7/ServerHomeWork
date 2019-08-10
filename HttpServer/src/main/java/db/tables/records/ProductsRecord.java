/*
 * This file is generated by jOOQ.
 */
package db.tables.records;


import db.tables.Products;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


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
public class ProductsRecord extends UpdatableRecordImpl<ProductsRecord> implements Record4<Integer, String, String, Integer> {

    private static final long serialVersionUID = 1129513520;

    /**
     * Setter for <code>public.products.id</code>.
     */
    public ProductsRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.products.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.products.name</code>.
     */
    public ProductsRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.products.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.products.company</code>.
     */
    public ProductsRecord setCompany(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.products.company</code>.
     */
    public String getCompany() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.products.quantity</code>.
     */
    public ProductsRecord setQuantity(Integer value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.products.quantity</code>.
     */
    public Integer getQuantity() {
        return (Integer) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, String, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, String, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Products.PRODUCTS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Products.PRODUCTS.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Products.PRODUCTS.COMPANY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Products.PRODUCTS.QUANTITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getCompany();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getQuantity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getCompany();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getQuantity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductsRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductsRecord value3(String value) {
        setCompany(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductsRecord value4(Integer value) {
        setQuantity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductsRecord values(Integer value1, String value2, String value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ProductsRecord
     */
    public ProductsRecord() {
        super(Products.PRODUCTS);
    }

    /**
     * Create a detached, initialised ProductsRecord
     */
    public ProductsRecord(Integer id, String name, String company, Integer quantity) {
        super(Products.PRODUCTS);

        set(0, id);
        set(1, name);
        set(2, company);
        set(3, quantity);
    }
}
