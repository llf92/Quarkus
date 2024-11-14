package uk.ac.newcastle.enterprisemiddleware.commodity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Description
 * Copyright © 启明星辰 版权所有
 *
 * @author Li, Long fei
 * @date 2024/11/14
 */
@Entity
@NamedQueries({
        @NamedQuery(name = Flights.FLIGHT_FIND_ALL, query = "SELECT f FROM Flights f"),
        @NamedQuery(name = Flights.FLIGHT_BY_FLIGHT_NUMBER, query = "SELECT f FROM Flights f WHERE f.flightNumber = :flightNumber")

})
@XmlRootElement
@Table(name = "flights", uniqueConstraints = @UniqueConstraint(columnNames = "flight_number"))
public class Flights extends Commodity{
    public static final String FLIGHT_FIND_ALL = "Flights.findAll";
    public static final String FLIGHT_BY_FLIGHT_NUMBER = "Flights.findByFlightNumber";
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    @NotNull
    @Size(min = 5, max = 5)
    @Pattern(regexp = "[A-Z0-9']+", message = "a non-empty alpha-numerical string which is 5 characters in length")
    @Column(name = "flight_number")
    private String flightNumber;
    @NotNull
    @Size(min = 3, max = 3)
    @Pattern(regexp = "[A-Z']+", message = "a non-empty alphabetical string, which is upper case and 3 characters in length")
    @Column(name = "start_point")
    private String startPoint;
    @NotNull
    @Size(min = 3, max = 3)
    @Pattern(regexp = "[A-Z']+", message = "a non-empty alphabetical string, which is upper case, 3 characters in length and different from its point of departure")
    @Column(name = "destination")
    private String destination;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}