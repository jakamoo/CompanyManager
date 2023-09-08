package com.enoca.demo.exceptions;

import com.enoca.demo.models.errors.CompanyError;

public class CompanyServiceNotFoundRestException extends CompanyServiceRestException{

    public CompanyServiceNotFoundRestException(Long companyId) {
        super(CompanyError.BAD_PARAM_BODY,
                "Company with Id "+companyId+" is not exists");
    }

}

