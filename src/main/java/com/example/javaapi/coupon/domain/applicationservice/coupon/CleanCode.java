package com.example.javaapi.coupon.domain.applicationservice.coupon;

public record CleanCode (String code) {
    public CleanCode {
        String removeSpecialCharacters = code.replaceAll("[^a-zA-Z0-9]", "");
        if (removeSpecialCharacters.length() != 6) {
            throw new IllegalArgumentException("O código do cupom deve ter 6 caracteres alfanuméricos.");
        }
        code = removeSpecialCharacters.toUpperCase();
    }
}
