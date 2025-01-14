//package uk.ac.newcastle.enterprisemiddleware.Booking;
//
//import javax.enterprise.context.RequestScoped;
//import javax.inject.Inject;
//import javax.inject.Named;
//import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import javax.validation.ConstraintViolationException;
//import java.util.List;
//import java.util.logging.Logger;
//
///**
// * <p>This is a Repository class and connects the Service/Control layer (see {@link BookingService} with the
// * Domain/Entity Object (see {@link Booking}).<p/>
// *
// * <p>There are no access modifiers on the methods making them 'package' scope.  They should only be accessed by a
// * Service/Control object.<p/>
// *
// * @author Joshua Wilson
// * @see Booking
// * @see EntityManager
// */
//@RequestScoped
//public class BookingRepository {
//
//    @Inject
//    @Named("logger")
//    Logger log;
//
//    @Inject
//    EntityManager em;
//
//    /**
//     * <p>Returns a List of all persisted {@link Booking} objects, sorted alphabetically by last name.</p>
//     *
//     * @return List of Contact objects
//     */
//    List<Booking> findAllOrderedByName() {
//        TypedQuery<Booking> query = em.createNamedQuery(Booking.FIND_ALL, Booking.class);
//        return query.getResultList();
//    }
//
//    /**
//     * <p>Returns a single Contact object, specified by a Long id.<p/>
//     *
//     * @param id The id field of the Contact to be returned
//     * @return The Contact with the specified id
//     */
//    Booking findById(Long id) {
//        return em.find(Booking.class, id);
//    }
//
//    /**
//     * <p>Returns a single Contact object, specified by a String email.</p>
//     *
//     * <p>If there is more than one Contact with the specified email, only the first encountered will be returned.<p/>
//     *
//     * @param email The email field of the Contact to be returned
//     * @return The first Contact with the specified email
//     */
//
//
//    /**
//     * <p>Returns a list of Contact objects, specified by a String firstName.<p/>
//     *
//     * @param firstName The firstName field of the Contacts to be returned
//     * @return The Contacts with the specified firstName
//     */
//    List<Booking> findAllByFirstName(String firstName) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Booking> criteria = cb.createQuery(Booking.class);
//        Root<Booking> contact = criteria.from(Booking.class);
//        // Swap criteria statements if you would like to try out type-safe criteria queries, a new feature in JPA 2.0.
//        // criteria.select(contact).where(cb.equal(contact.get(Contact_.firstName), firstName));
//        criteria.select(contact).where(cb.equal(contact.get("firstName"), firstName));
//        return em.createQuery(criteria).getResultList();
//    }
//
//    /**
//     * <p>Returns a single Contact object, specified by a String lastName.<p/>
//     *
//     * @param lastName The lastName field of the Contacts to be returned
//     * @return The Contacts with the specified lastName
//     */
//    List<Booking> findAllByLastName(String lastName) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Booking> criteria = cb.createQuery(Booking.class);
//        Root<Booking> contact = criteria.from(Booking.class);
//        // Swap criteria statements if you would like to try out type-safe criteria queries, a new feature in JPA 2.0.
//        // criteria.select(contact).where(cb.equal(contact.get(Contact_.lastName), lastName));
//        criteria.select(contact).where(cb.equal(contact.get("lastName"), lastName));
//        return em.createQuery(criteria).getResultList();
//    }
//
//    /**
//     * <p>Persists the provided Contact object to the application database using the EntityManager.</p>
//     *
//     * <p>{@link EntityManager#persist(Object) persist(Object)} takes an entity instance, adds it to the
//     * context and makes that instance managed (ie future updates to the entity will be tracked)</p>
//     *
//     * <p>persist(Object) will set the @GeneratedValue @Id for an object.</p>
//     *
//     * @param booking The Contact object to be persisted
//     * @return The Contact object that has been persisted
//     * @throws ConstraintViolationException, ValidationException, Exception
//     */
//    Booking create(Booking booking) throws Exception {
//        log.info("ContactRepository.create() - Creating " + booking.getFirstName() + " " + booking.getLastName());
//
//        // Write the contact to the database.
//        em.persist(booking);
//
//        return booking;
//    }
//
//    /**
//     * <p>Updates an existing Contact object in the application database with the provided Contact object.</p>
//     *
//     * <p>{@link EntityManager#merge(Object) merge(Object)} creates a new instance of your entity,
//     * copies the state from the supplied entity, and makes the new copy managed. The instance you pass in will not be
//     * managed (any changes you make will not be part of the transaction - unless you call merge again).</p>
//     *
//     * <p>merge(Object) however must have an object with the @Id already generated.</p>
//     *
//     * @param booking The Contact object to be merged with an existing Contact
//     * @return The Contact that has been merged
//     * @throws ConstraintViolationException, ValidationException, Exception
//     */
//    Booking update(Booking booking) throws Exception {
//        log.info("ContactRepository.update() - Updating " + booking.getFirstName() + " " + booking.getLastName());
//
//        // Either update the contact or add it if it can't be found.
//        em.merge(booking);
//
//        return booking;
//    }
//
//    /**
//     * <p>Deletes the provided Contact object from the application database if found there</p>
//     *
//     * @param booking The Contact object to be removed from the application database
//     * @return The Contact object that has been successfully removed from the application database; or null
//     * @throws Exception
//     */
//    Booking delete(Booking booking) throws Exception {
//        log.info("ContactRepository.delete() - Deleting " + booking.getFirstName() + " " + booking.getLastName());
//
//        if (booking.getId() != null) {
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
//            em.remove(em.merge(booking));
//
//        } else {
//            log.info("ContactRepository.delete() - No ID was found so can't Delete.");
//        }
//
//        return booking;
//    }
//
//}
