package com.kapelle.procheck.Model;

import com.kapelle.procheck.Classes.JSONArrayConverter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.Convert;
import org.json.JSONArray;

@Entity
@Table(name = "pros")
public class BusinessDetailsEntity{
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique=true)
    public Long id;

    @Column(name = "userId")
    public Long userId;

    @Column(name = "companyname", columnDefinition = "varchar(100)")
    @NotEmpty(message = "Company name must be filled")
    @Size(min = 2, message="Company name too short")
    @Size(max= 100, message="Phrase too Long")
    public String companyname;

    @Column(name = "country")
    public transient String country;

    @Column(name = "town")
    public transient String town;
    
    @Column(name = "suburb")
    public transient String suburb;

    @Column(name = "zip")
    public transient Integer zip;

    @Column(name = "address", columnDefinition = "json")
    @Convert(converter= JSONArrayConverter.class)
    public JSONArray address = new JSONArray();

    @Column(name = "email", columnDefinition = "varchar(100)")
    @NotEmpty(message = "Email must be filled")
    @Size(max= 100, message="Phrase too Long")
    @Email(message = "Please enter valid email address")
    public String email;

    @Column(name = "phonenumber", columnDefinition = "long")
    public Long phonenumber;
    
    public BusinessDetailsEntity(){
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCompanyname() {
        return companyname;
    }
    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }
    public void setTown(String town) {
        this.town = town;
    }

    public String getSuburb() {
        return suburb;
    }
    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public Integer getZip() {
        return zip;
    }
    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public JSONArray getAddress() {
        return address;
    }
    public void setAddress(JSONArray address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }
    @Override
public String toString() {
    return "Pro{" +
            "id='" + id +
            "', userid='" + userId +
            "', companyname='" + companyname +
            "', address='" + address +
            "', email='" + email +
            "', contacts='" + phonenumber +
            "'}";
}

}


