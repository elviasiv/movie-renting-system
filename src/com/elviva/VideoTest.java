package com.elviva;

import static org.junit.Assert.*;

public class VideoTest {

    //tests the video creation functionality
    @org.junit.Test
    public void testVideoCreation() throws VideoException{
        Video newVideo = new Video("E.T.", 1988);
        assertEquals("E.T.", newVideo.getTitle());
    }

    //tests the video to string functionality
    @org.junit.Test
    public void testVideoToString() throws VideoException{
        Video newVideo = new Video("E.T.", 1988);
        assertEquals("E.T.: 1988 is AVAILABLE", newVideo.toString());
    }

    //tests the video availability
    @org.junit.Test
    public void testVideoAvailability() throws VideoException{
        Video etVideo = new Video("E.T.", 1988);
        assertTrue(etVideo.isAvailable());
    }

    //tests the video unavailable
    @org.junit.Test
    public void testVideoAvailabilityNegative() throws VideoException{
        Video etVideo = new Video("E.T.", 1988);
        etVideo.checkOut();
        assertFalse(etVideo.isAvailable());
    }

    //tests the video unavailable
    @org.junit.Test
    public void testVideoIsNotAvailable() throws VideoException{
        Video etVideo = new Video("E.T.", 1988);
        etVideo.checkOut();
        assertTrue(etVideo.isNotAvailable());
    }

    //tests the video equals functionality
    @org.junit.Test
    public void testVideoEquals() throws VideoException{
        Video etVideo = new Video("E.T.", 1988);
        Video etVideoDuplicate = new Video("E.T.", 1988);
        etVideo.checkOut();
        assertTrue(etVideo.equals(etVideoDuplicate));
    }

    //tests the video equals functionality negative case
    @org.junit.Test
    public void testVideoEqualsNegative() throws VideoException{
        Video etVideo = new Video("E.T.", 1988);
        Video indianaJones = new Video("Indiana Jones", 1988);
        etVideo.checkOut();
        assertFalse(etVideo.equals(indianaJones));
    }

    //tests the video check in functionality
    @org.junit.Test
    public void testVideoCheckIn() throws VideoException{
        Video etVideo = new Video("E.T.", 1988);
        etVideo.checkOut();
        etVideo.checkIn();
        assertTrue(etVideo.isAvailable());
    }

    //tests the video check in functionality negative case
    @org.junit.Test
    public void testVideoCheckInNegative() throws VideoException{
        Video indianaJones = new Video("Indiana Jones", 1988);
        indianaJones.checkOut();
        indianaJones.checkIn();
        indianaJones.checkOut();
        assertTrue(indianaJones.isNotAvailable());
    }

    //tests the video remove from stock and add it back it
    @org.junit.Test
    public void testAddFromStock() throws VideoException{
        Video empireStrikesBack = new Video("The Empire Strikes Back", 1980);
        empireStrikesBack.removeFromStock();
        empireStrikesBack.replaceToStock();
        assertTrue(empireStrikesBack.isAvailable());
    }


}
