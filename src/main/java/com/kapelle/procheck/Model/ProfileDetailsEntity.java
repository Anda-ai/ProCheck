package com.kapelle.procheck.Model;

import com.kapelle.procheck.Classes.JSONArrayConverter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.Convert;
import org.json.JSONArray;

@Entity
@Table(name = "pros")
public class ProfileDetailsEntity{

    @Id
    @Column(name = "id")
    public Long id;

    @Column(name = "userId")
    public Long userId;

    @Column(name = "mainservice", columnDefinition = "json")
    @Convert(converter= JSONArrayConverter.class)
    public JSONArray mainservice = new JSONArray();

    @Column(name = "otherservices", columnDefinition = "json")
    @Convert(converter= JSONArrayConverter.class)
    public JSONArray otherservices = new JSONArray();

    @Column(name = "qualification", columnDefinition = "varchar(100)")
    @NotEmpty(message = "Qualification name must be filled")
    @Size(min = 2, message="Qualification name too short")
    @Size(max= 100, message="Phrases too Long")
    public String qualification;

    @Column(name = "experience", columnDefinition = "int")
    public Integer experience;

    @Column(name = "about", columnDefinition = "varchar(500)")
    @NotEmpty(message = "About must be filled")
    @Size(min = 10, message="Your 'About' description is too short")
    @Size(max= 500, message="Phrases too Long, Maximum 500")
    public String about;
    
    @Column(name = "avgreviews", columnDefinition = "int")
    public Integer reviews = 0;
    
    @Column(name = "bookings", columnDefinition = "int")
    public Integer bookings = 0;

    public ProfileDetailsEntity(){
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

    public JSONArray getMainservice() {
        return mainservice;
    }
    public void setMainservice(JSONArray mainservice) {
        this.mainservice = mainservice;
    }
    
    public JSONArray getOtherservices() {
        return otherservices;
    }
    public void setOtherservices(JSONArray otherservices) {
        this.otherservices = otherservices;
    }

    public String getQualification() {
        return qualification;
    }
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Integer getExperience() {
        return experience;
    }
    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getAbout() {
        return about;
    }
    public void setAbout(String about) {
        this.about = about;
    }

    public Integer getReviews() {
        return reviews;
    }
    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }
    
    public Integer getBookings() {
        return bookings;
    }
    public void setBookings(Integer bookings) {
        this.bookings = bookings;
    }
    
    
    @Override
    public String toString() {
    return "Pro{" +
            "id='" + id +
            "userid='" + userId +
            "', mainservice='" + mainservice +
            "', otherservices='" + otherservices +
            "', experience='" + experience +
            "', qualification='" + qualification +
            "', about='" + about +
            "', avgreviews='" + reviews +
            "', bookings='" + bookings +
            "'}";
    }
}
    

