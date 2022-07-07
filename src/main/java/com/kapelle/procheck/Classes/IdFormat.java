package com.kapelle.procheck.Classes;

import java.util.Calendar;  
import java.util.Date;  
import java.time.Instant;  

public class IdFormat {
    public static Long generateId(){
        Calendar cln = Calendar.getInstance();  
        Date d = cln.getTime();  
        Instant instt = d.toInstant();  
        System.out.println("Time: "+instt);
        String id_ = instt.toString();
        id_ = id_.replaceAll("[^0-9]","");
        Long id = Long.parseLong(id_);
        return id;
    }
}
