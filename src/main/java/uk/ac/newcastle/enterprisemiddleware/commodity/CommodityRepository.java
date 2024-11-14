package uk.ac.newcastle.enterprisemiddleware.commodity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

/**
 * <p>This is a Repository class and connects the Service/Control layer (see {@link CommodityService} with the
 * Domain/Entity Object (see {@link Commodity}).<p/>
 *
 * <p>There are no access modifiers on the methods making them 'package' scope.  They should only be accessed by a
 * Service/Control object.<p/>
 *
 * @author Joshua Wilson
 * @see Commodity
 * @see EntityManager
 */
@RequestScoped
public class CommodityRepository {

    @Inject
    @Named("logger")
    Logger log;

    @Inject
    EntityManager em;


    List<Taxis> findAllTaxis() {
        TypedQuery<Taxis> query = em.createNamedQuery(Taxis.TAXI_FIND_ALL, Taxis.class);
        return query.getResultList();
    }

    Commodity findByTaxisId(Long id) {
        return em.find(Taxis.class, id);
    }

    List<Flights> findAllFlights() {
        TypedQuery<Flights> query = em.createNamedQuery(Flights.FLIGHT_FIND_ALL, Flights.class);
        return query.getResultList();
    }

    Commodity findByFlightsId(Long id) {
        return em.find(Flights.class, id);
    }

    List<Hotel> findAllHotels() {
        TypedQuery<Hotel> query = em.createNamedQuery(Hotel.HOTEL_FIND_ALL, Hotel.class);
        return query.getResultList();
    }

    Commodity findByHotelId(Long id) {
        return em.find(Hotel.class, id);
    }
    Commodity create(Commodity commodity) throws Exception {
//        log.info("ContactRepository.create() - Creating " + commodity.getFirstName() + " " + commodity.getLastName());

        // Write the contact to the database.
        em.persist(commodity);

        return commodity;
    }


    Commodity update(Commodity commodity) throws Exception {
//        log.info("ContactRepository.update() - Updating " + commodity.getFirstName() + " " + commodity.getLastName());

        // Either update the contact or add it if it can't be found.
        em.merge(commodity);

        return commodity;
    }


//    Commodity delete(Commodity commodity) throws Exception {
//        log.info("ContactRepository.delete() - Deleting " + commodity.getFirstName() + " " + commodity.getLastName());
//
//        if (commodity.getId() != null) {
//            /*
//             * The Hibernate session (aka EntityManager's persistent context) is closed and invalidated after the commit(),
//             * because it is bound to a transaction. The object goes into a detached status. If you open a new persistent
//             * context, the object isn't known as in a persistent state in this new context, so you have to merge it.
//             *
//             * Merge sees that the object has a primary key (id), so it knows it is not new and must hit the database
//             * to reattach it.
//             *
//             * Note, there is NO remove method which would just take a primary key (id) and a entity class as argument.
//             * You first need an object in a persistent state to be able to delete it.
//             *
//             * Therefore we merge first and then we can remove it.
//             */
//            em.remove(em.merge(commodity));
//
//        } else {
//            log.info("ContactRepository.delete() - No ID was found so can't Delete.");
//        }
//
//        return commodity;
//    }

}
