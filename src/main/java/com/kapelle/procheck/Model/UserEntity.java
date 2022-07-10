package com.kapelle.procheck.Model;

import com.kapelle.procheck.Classes.JSONArrayConverter;
import com.kapelle.procheck.Validation.UniqueEmailConstraint;
import com.kapelle.procheck.Validation.UniqueUsernameConstraint;
import com.kapelle.procheck.Validation.UsernameFormatConstraint;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.github.openjson.JSONArray;

/**
 *
 * @author anda
 */
@Entity
@Table(name = "users")
public class UserEntity{
    @Id
    @Column(name = "id", unique = true)
    public Long id;

    @Column(name = "username", columnDefinition = "varchar(100)")
    @NotEmpty(message = "Username must be filled")
    @UniqueUsernameConstraint
    @Size(min = 4, message="Username too short")
    @Size(max= 50, message="Phrases too Long")
    @UsernameFormatConstraint
    public String username;
    
    @Column(name = "password", columnDefinition = "varchar(100)")
    @NotEmpty(message = "Password must be filled")
    @Size(min = 6, message="Password too short")
    @Size(max= 200, message="Phrases too Long")
    //https://mkyong.com/regular-expressions/how-to-validate-password-with-regular-expression/
    @Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,200}$", message="Password must contain Uppercase and Lowercases Latin characters, Digits and Special characters")
    public String password;

    @Column(name = "role", columnDefinition = "varchar(100)")
    public String role = "USER";
    
    @Column(name = "firstname", columnDefinition = "varchar(100)")
    @NotEmpty(message = "First name must be filled")
    @Size(min = 3, message="First name too short")
    @Size(max= 50, message="Phrase too Long")
    @Pattern(regexp ="^[a-zA-Z]*$", message="Incorect first name")
    public String firstname;
    
    @Column(name = "lastname", columnDefinition = "varchar(100)")
    @Size(min = 3, message="Last name too short")
    @Size(max= 50, message="Phrase too Long")
    @Pattern(regexp ="^[a-zA-Z]*$", message="Incorect last name")
    public String lastname;
    
    @Column(name = "email", columnDefinition = "varchar(100)")
    @NotEmpty(message = "Email address must be filled")
    @Size(max= 100, message="Phrase too Long")
    @UniqueEmailConstraint
    @Email(message = "Please enter valid email address")
    public String email;
    
    //@Column(name = "emailverication", columnDefinition = "boolean")
    public Boolean isEnabled = false;
    
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
    public  JSONArray address = new JSONArray();
    
    @Column(name = "followers", columnDefinition = "int")
    public Integer followers = 0;
    
    @Column(name = "following", columnDefinition = "int")
    public Integer following = 0;

    @Column(name = "date_Util", columnDefinition = "DATE")
    java.util.Date utilDate = new java.util.Date();

    @Column(name = "date_Signup", columnDefinition = "DATE")
    //@Temporal(TemporalType.TIMESTAMP) //used with java.util.Data
    public java.sql.Date date_Signup = new java.sql.Date(utilDate.getTime());
    
    @Column(name = "time_Signup", columnDefinition = "TIME")
    //@Temporal(TemporalType.TIMESTAMP) //used with java.util.Data
    java.sql.Time time_Signup = new java.sql.Time(utilDate.getTime());
    
    public UserEntity(){
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Boolean isEnabled() {
        return isEnabled;
    }
    public void setEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
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
    
    public Integer getFollowers() {
        return followers;
    }
    public void setFollowers(Integer followers) {
        this.followers = followers;
    }
    
    public Integer getFollowing() {
        return following;
    }
    public void setFollowing(Integer following) {
        this.following = following;
    }

    public java.util.Date getUtilDate() {
        return utilDate;
    }
    public void setUtilDate(java.util.Date date) {
        this.utilDate = date;
    }
    
    public Date getSignupDate() {
        return date_Signup;
    }
    public void setSignupDate(Date date) {
        this.date_Signup = date;
    }
    
    public Time getSignupTime() {
        return time_Signup;
    }
    public void setSignupTime(Time time) {
        this.time_Signup = time;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id='" + id +
                "', username='" + username +
                "', password='" + password +
                "', role='" + role +
                "', firstname='" + firstname +
                "', lastname='" + lastname +
                "', email='" + email +
                "', isEnabled='" + isEnabled +
                "', address='" + address +
                "', followers='" + followers +
                "', following='" + following +
                "', date_Signup='" + date_Signup +
                "', time_Signup='" + time_Signup +
                "'}";
    }
}
