package uk.ac.newcastle.enterprisemiddleware.commodity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Validator;


@ApplicationScoped
public class CommodityValidator {
    @Inject
    Validator validator;

    @Inject
    CommodityRepository crud;


}

