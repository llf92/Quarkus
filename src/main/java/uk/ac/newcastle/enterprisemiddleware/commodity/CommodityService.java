package uk.ac.newcastle.enterprisemiddleware.commodity;


import org.eclipse.microprofile.rest.client.inject.RestClient;
import uk.ac.newcastle.enterprisemiddleware.area.AreaService;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.logging.Logger;

@Dependent
public class CommodityService {

    @Inject
    @Named("logger")
    Logger log;

    @Inject
    CommodityValidator validator;

    @Inject
    CommodityRepository crud;

    //Removed temporarily due to non-existing AreaService
    @RestClient
    AreaService areaService;

    /**
     * <p>Returns a List of all persisted {@link Commodity} objects, sorted alphabetically by last name.<p/>
     *
     * @return List of Commodity objects
     */
    List<Taxis> findAllTaxis() {
        return crud.findAllTaxis();
    }

    List<Flights> findAllFlights() {
        return crud.findAllFlights();
    }

    List<Hotel> findAllHotels() {
        return crud.findAllHotels();
    }
}
