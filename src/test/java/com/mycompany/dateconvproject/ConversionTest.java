/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dateconvproject;




import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author mariumbinteibrahim
 */
public class ConversionTest {
    Calendar calendar;
    Date date;
    LocalDate localDate;
    LocalDateTime localDateTime;
    
    @Before
    public void init(){
        String sDate1="20-05-2010-10:35:10";  
        try {  
            date=new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss").parse(sDate1);
        } catch (ParseException ex) {
            Logger.getAnonymousLogger().log(Level.CONFIG, "Error in initial date formatting", ex);
        }
         
        localDate = LocalDate.of(2010, 5, 20);
        localDateTime=LocalDateTime.of(2010, 5, 20, 10, 35, 10);
        
    }

   
    @Test
    public void testDate_To_LocalDate() {
        
        LocalDate result = Conversion.convertToLocalDateViaInstant(date); 
        assertEquals(localDate, result);
        
    }
    
    @Test
    public void testDate_To_LocalDateTime(){
       
        LocalDateTime result=Conversion.convertToLocalDateTimeViaInstant(date);
        assertEquals(localDateTime, result); 
    }
    
    @Test
    public void testLocalDate_To_Date(){
        
        Date result = Conversion.convertToDateFromLocalDate(localDate);
        assertNotEquals(date, result); //Because Date has also time values but local date has only date 
        
    }
    
    @Test
    public void testLocalDateTime_To_Date(){
        
        Date result = Conversion.convertToDateFromLocalDateTime(localDateTime);
        assertEquals(date, result);  
        
    }
    // zone-time, offset-time korte hobe.....
    @Test
    public void testZoneId(){
        
    }
    
    
    
    
}
