package com.elviva;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class VideoRentalTest {

    //tests that VideoRental throws an exception when a video is unavailable
    @org.junit.Test
    public void testVideoRentalVideoUnavailable() throws VideoException{
        Account steveAccount = new Account("Steve", "Murphy", "sMurphy@gmail.com");
        Account kimAccount = new Account("Kim", "Murphy", "kMurphy@gmail.com");
        Video jaws = new Video("Jaws", 1977);
        new VideoRental(jaws, steveAccount);
        try  {
            new VideoRental(jaws, kimAccount);
            fail();
        }
        catch (VideoException videoException){
            //Expected
            videoException.printStackTrace();
        }
    }

    //tests that isOverDue returns true when a video is over due
    @org.junit.Test
    public void testVideoRentalisOverDue() throws VideoException{
        Account steveAccount = new Account("Steve", "Murphy", "sMurphy@gmail.com");
        Video jaws = new Video("Jaws", 1977);
        LocalDate dueDate = LocalDate.of(2019, 12, 21);
        VideoRental rental = new VideoRental(jaws, steveAccount, dueDate);
        assertTrue(rental.isOverDue());
    }

    //tests that isOverDue returns false when a video is not over due
    @org.junit.Test
    public void testVideoRentalisNotOverDue() throws VideoException{
        Account steveAccount = new Account("Steve", "Murphy", "sMurphy@gmail.com");
        Video jaws = new Video("Jaws", 1977);
        LocalDate dueDate = LocalDate.of(2017, 11, 20);
        VideoRental rental = new VideoRental(jaws, steveAccount, dueDate);
        assertEquals( false, rental.isOverDue());
    }

    //tests that the equals method works as expected
    @org.junit.Test
    public void testVideoRentalequalsPositive() throws VideoException{
        Account nancyAccount = new Account("Nancy", "Murphy", "nMurphy@gmail.com");
        Video casino = new Video("Casino", 1995);
        LocalDate dueDate = LocalDate.of(2019, 11, 21);
        VideoRental casinoRental = new VideoRental(casino, nancyAccount, dueDate);
        assertTrue(casinoRental.equals(casinoRental));
    }

    //tests that the equals method works as expected
    @org.junit.Test
    public void testVideoRentalequalsNegative() throws VideoException{
        Account nancyAccount = new Account("Nancy", "Murphy", "nMurphy@gmail.com");
        Video casino = new Video("Casino", 1995);
        Video castAway = new Video("Cast Away", 1996);
        LocalDate dueDate = LocalDate.of(2019, 11, 21);
        VideoRental casinoRental = new VideoRental(casino, nancyAccount, dueDate);
        VideoRental castAwayRental = new VideoRental(castAway, nancyAccount, dueDate);
        assertFalse(casinoRental.equals(castAwayRental));
    }

    //tests that toString method works as expected
    @org.junit.Test
    public void testVideoRentalToString() throws VideoException{
        Account steveAccount = new Account("Steve", "Murphy", "sMurphy@gmail.com");
        Video jaws = new Video("Jaws", 1977);
        LocalDate dueDate = LocalDate.of(2019, 12, 21);
        VideoRental rental = new VideoRental(jaws, steveAccount, dueDate);
        assertEquals( "Jaws->sMurphy@gmail.com due on 2019-12-21", rental.toString());
    }

// tests that isOpen returns true when a is rented then returned
//	@org.junit.Test
//	public void testVideoRentalreturn() throws VideoException{
//		Account nancyAccount = new Account("Nancy", "Murphy", "nMurphy@gmail.com");
//		Video casino = new Video("Casino", 1995);
//		LocalDate dueDate = LocalDate.of(2019, 11, 21);
//		VideoRental casinoRental = new VideoRental(casino, nancyAccount, dueDate);
//		casinoRental.rentalReturn();
//		assertEquals( true, casinoRental.isOpen());
//	}
//
//	//tests that isOpen returns false when a is rented then not returned
//	@org.junit.Test
//	public void testVideoRentalNotReturned() throws VideoException{
//		Account donAccount = new Account("Don", "Murphy", "dMurphy@gmail.com");
//		Video castAway = new Video("Cast Away", 1996);
//		LocalDate dueDate = LocalDate.of(2019, 11, 21);
//		VideoRental castAwayRental = new VideoRental(castAway, donAccount, dueDate);
//		assertEquals( false, castAwayRental.isOpen());
//	}

}