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
@NamedQueries({@NamedQuery(name = Hotel.HOTEL_FIND_ALL, query = "SELECT h FROM Hotel h")})
@XmlRootElement
@Table(name = "hotel")
public class Hotel extends Commodity{
    public static final String HOTEL_FIND_ALL = "Hotel.findAll";
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    @NotNull
    @Size(max = 50)
    @Pattern(regexp = "[A-Za-z_']+", message = "a non-empty alphabetical string less than 50 characters in length")
    @Column(name = "name")
    private String name;
    @NotNull
    @Size(min = 11, max = 11)
    @Pattern(regexp = "\\+?[1-9]\\d{1,14}", message = "a non-empty string which starts with a 0, contains only digits and is 11 characters in length")
    @Column(name = "phone_number")
    private String phoneNumber;
    @NotNull
    @Size(min = 6, max = 6)
    @Pattern(regexp = "\\d{6}", message = "a non-empty alpha-numerical string which is 6 characters in length")
    @Column(name = "post_code")
    private String postCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}