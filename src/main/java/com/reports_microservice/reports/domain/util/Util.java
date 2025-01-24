package com.reports_microservice.reports.domain.util;

public class Util {

    public static final String CLAIM_AUTHORITIES = "authorities";
    public static final String EMAIL = "email";
    public static final String AUTH_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String ROLE_CLIENT = "hasRole('CLIENT')";
    public static final String ID_NOT_NULL = "Id no puede ser nulo";
    public static final String USER_ID_NOT_NULL = "el id del usuario no puede ser nulo";
    public static final String TOTAL_NOT_NULL = "el total no puede ser nulo";
    public static final String CREATION_DATE_NOT_NULL = "la fecha de creacion no puede ser nula";
    public static final String SALE_DETAILS_NOT_NULL = "los detalles de la venta no pueden ser nulos";
    public static final String ARTICLE_ID_NOT_NULL = "el id del articulo no puede ser nulo";
    public static final String QUANTITY_NOT_NULL = "la cantidad no puede ser nula";
    public static final String PRICE_NOT_NULL = "el precio no puede ser nulo";
    public static final String SUBTOTAL_NOT_NULL = "el sub total no puede ser nulo";

    public static final int TOKEN_PREFIX_LENGTH = 7;
    private Util() {}
}
