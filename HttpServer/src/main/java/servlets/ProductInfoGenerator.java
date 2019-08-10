package servlets;

import db.tables.records.ProductsRecord;
import org.jetbrains.annotations.NotNull;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import javax.inject.Singleton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static db.tables.Products.PRODUCTS;
@Singleton
public final class ProductInfoGenerator {
    @NotNull
    private Connection connection= DriverManager.getConnection( "jdbc:postgresql://localhost:3600/test","postgres","rainbow7");
    @NotNull
    private DSLContext create = DSL.using(connection, SQLDialect.POSTGRES_10);
    @NotNull
    private ProductsRecord productsRecord=create.newRecord(PRODUCTS );

    public ProductInfoGenerator() throws SQLException {
    }

    @NotNull String getInfo(){
        StringBuilder info= new StringBuilder( "<!DOCTYPE html>" +
                "<html>" +
                "<head><title>Products</title></head>" );
    Result<Record> result=  create.select( ).from( PRODUCTS ).fetch();
        for (Record record:result
             ) {
            info.append( "<p>" ).append( record.getValue( "id" ) ).append( "  " ).append( " product: " ).append( record.getValue( "name" ) ).append( "  " ).append( " company: " ).append( record.getValue( "company" ) ).append( "  " ).append( " quantity: " ).append( record.getValue( "quantity" ) ).append( "</p>" );

        }
        info.append( "</html>" );

        return info.toString( );


    }
    public void setInfo(@NotNull String request){
        String[] strings=request.split( "&" );
        String[] nameInfo=strings[0].split( "=" );
        String[] companyInfo = strings[1].split( "=" );
        String[] quantityInfo = strings[2].split( "=" );
        productsRecord.setCompany( companyInfo[1] );
        productsRecord.setName( nameInfo[1] );
        productsRecord.setQuantity( Integer.valueOf( quantityInfo[1] ) );
        productsRecord.insert();
            }

}
