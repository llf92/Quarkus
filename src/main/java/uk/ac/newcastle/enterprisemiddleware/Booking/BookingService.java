//package uk.ac.newcastle.enterprisemiddleware.Booking;
//
//
//import org.eclipse.microprofile.rest.client.inject.RestClient;
//import uk.ac.newcastle.enterprisemiddleware.area.Area;
//import uk.ac.newcastle.enterprisemiddleware.area.AreaService;
//import uk.ac.newcastle.enterprisemiddleware.area.InvalidAreaCodeException;
//
//import javax.enterprise.context.Dependent;
//import javax.inject.Inject;
//import javax.inject.Named;
//import javax.validation.ConstraintViolationException;
//import javax.ws.rs.ClientErrorException;
//import javax.ws.rs.core.Response;
//import java.util.List;
//import java.util.logging.Logger;
//
//@Dependent
//public class BookingService {
//
//    @Inject
//    @Named("logger")
//    Logger log;
//
//    @Inject
//    BookingRepository crud;
//
//    //Removed temporarily due to non-existing AreaService
//    @RestClient
//    AreaService areaService;
//
//    /**
//     * <p>Returns a List of all persisted {@link Booking} objects, sorted alphabetically by last name.<p/>
//     *
//     * @return List of Contact objects
//     */
//    List<Booking> findAllOrderedByName() {
//        return crud.findAllOrderedByName();
//    }
//
//    /**
//     * <p>Returns a single Contact object, specified by a Long id.<p/>
//     *
//     * @param id The id field of the Contact to be returned
//     * @return The Contact with the specified id
//     */
//    Booking findById(Long id) {
//        return crud.findById(id);
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
//    /**
//     * <p>Returns a single Contact object, specified by a String firstName.<p/>
//     *
//     * @param firstName The firstName field of the Contact to be returned
//     * @return The first Contact with the specified firstName
//     */
//    List<Booking> findAllByFirstName(String firstName) {
//        return crud.findAllByFirstName(firstName);
//    }
//
//    /**
//     * <p>Returns a single Contact object, specified by a String lastName.<p/>
//     *
//     * @param lastName The lastName field of the Contacts to be returned
//     * @return The Contacts with the specified lastName
//     */
//    List<Booking> findAllByLastName(String lastName) {
//        return crud.findAllByLastName(lastName);
//    }
//
//
//    Booking create(Booking contact) throws Exception {
//        log.info("ContactService.create() - Creating " + contact.getFirstName() + " " + contact.getLastName());
//
//        // Check to make sure the data fits with the parameters in the Contact model and passes validation.
////        validator.validateContact(contact);
//
//
//        //Create client service instance to make REST requests to upstream service
//        try {
//            //Removed temporarily due to non-existing AreaService
//            Area area = areaService.getAreaById(Integer.parseInt(contact.getPhoneNumber().substring(1, 4)));
//            contact.setState(area.getState());
//        } catch (ClientErrorException e) {
//            if (e.getResponse().getStatusInfo() == Response.Status.NOT_FOUND) {
//                throw new InvalidAreaCodeException("The area code provided does not exist", e);
//            } else {
//                throw e;
//            }
//        }
//
//        // Write the contact to the database.
//        return crud.create(contact);
//    }
//
//    /**
//     * <p>Updates an existing Contact object in the application database with the provided Contact object.<p/>
//     *
//     * <p>Validates the data in the provided Contact object using a ContactValidator object.<p/>
//     *
//     * @param contact The Contact object to be passed as an update to the application database
//     * @return The Contact object that has been successfully updated in the application database
//     * @throws ConstraintViolationException, ValidationException, Exception
//     */
//    Booking update(Booking contact) throws Exception {
//        log.info("ContactService.update() - Updating " + contact.getFirstName() + " " + contact.getLastName());
//
//        // Check to make sure the data fits with the parameters in the Contact model and passes validation.
////        validator.validateContact(contact);
//
//        try {
//            //Removed temporarily due to non-existing AreaService
//            Area area = areaService.getAreaById(Integer.parseInt(contact.getPhoneNumber().substring(1, 4)));
//            contact.setState(area.getState());
//        } catch (ClientErrorException e) {
//            if (e.getResponse().getStatusInfo() == Response.Status.NOT_FOUND) {
//                throw new InvalidAreaCodeException("The area code provided does not exist", e);
//            } else {
//                throw e;
//            }
//        }
//
//        // Either update the contact or add it if it can't be found.
//        return crud.update(contact);
//    }
//
//    /**
//     * <p>Deletes the provided Contact object from the application database if found there.<p/>
//     *
//     * @param contact The Contact object to be removed from the application database
//     * @return The Contact object that has been successfully removed from the application database; or null
//     * @throws Exception
//     */
//    Booking delete(Booking booking) throws Exception {
//        log.info("delete() - Deleting " + booking.toString());
//
//        Booking deletedContact = null;
//
//        if (booking.getId() != null) {
//            deletedContact = crud.delete(booking);
//        } else {
//            log.info("delete() - No ID was found so can't Delete.");
//        }
//
//        return deletedContact;
//    }
//}
