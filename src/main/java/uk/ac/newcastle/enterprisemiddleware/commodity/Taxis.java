package uk.ac.newcastle.enterprisemiddleware.commodity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
        @NamedQuery(name = Taxis.TAXI_FIND_ALL, query = "SELECT t FROM Taxis t"),
        @NamedQuery(name = Taxis.FIND_BY_LICENSE_PLATE, query = "SELECT t FROM Taxis t WHERE t.licensePlate = :licensePlate")

})
@XmlRootElement
@Table(name = "taxis", uniqueConstraints = @UniqueConstraint(columnNames = "license_plate"))
public class Taxis extends Commodity{
    public static final String TAXI_FIND_ALL = "Taxis.findAll";
    public static final String FIND_BY_LICENSE_PLATE = "Taxis.findByLicensePlate";
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    @NotNull
    @Column(name = "license_plate")
    private String licensePlate;
    @NotNull
    @Size(min = 2, max = 20)
    @Column(name = "seats")
    private Integer seats;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }
}