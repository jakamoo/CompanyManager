package com.enoca.demo.exceptions;

import com.enoca.demo.models.errors.CompanyError;
import lombok.AllArgsConstructor;

public class CompanyServiceRestException extends RuntimeException {
    private final CompanyError companyError;
    private final String description;

    public CompanyServiceRestException(CompanyError companyError,String description){

        super(description+" "+companyError.name());
        this.companyError = companyError;
        this.description = description;
    }






}
