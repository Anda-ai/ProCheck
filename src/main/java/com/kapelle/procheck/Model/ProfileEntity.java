package com.kapelle.procheck.Model;

import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author anda
 */
@Entity
@Table(name = "profileimages")
public class ProfileEntity{
    @Id
    @Column(name = "id", unique = true)
    public Long id;

    @Column(name = "userId")
    public Long userId;

    @Column(name = "imgPath", columnDefinition = "varchar(500)")
    public String imgPath;

    @Column(name = "date_Util", columnDefinition = "DATE")
    java.util.Date utilDate = new java.util.Date();

    @Column(name = "date", columnDefinition = "DATE")
    //@Temporal(TemporalType.TIMESTAMP) //used with java.util.Data
    public java.sql.Date date = new java.sql.Date(utilDate.getTime());
    
    @Column(name = "time", columnDefinition = "TIME")
    //@Temporal(TemporalType.TIMESTAMP) //used with java.util.Data
    java.sql.Time time = new java.sql.Time(utilDate.getTime());
    
    public ProfileEntity(){
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

    public String getImgPath() {
        return imgPath;
    }
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public java.util.Date getUtilDate() {
        return utilDate;
    }
    public void setUtilDate(java.util.Date date) {
        this.utilDate = date;
    }
    
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    
    public Time getTime() {
        return time;
    }
    public void set(Time time) {
        this.time = time;
    }
    
    @Override
    public String toString() {
        return "Profile{" +
                "id='" + id +
                "', userid='" + userId +
                "', imgPath='" + imgPath +
                "', date_Signup='" + date +
                "', time_Signup='" + time +
                "'}";
    }
}
