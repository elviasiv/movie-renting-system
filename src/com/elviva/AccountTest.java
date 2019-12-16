package com.elviva;

import java.time.LocalDate;
import static org.junit.Assert.*;

public class AccountTest {

    //tests the account creation functionality
    @org.junit.Test
    public void testAccountCreation() {
        Account brendanAccount = new Account("Brendan", "Murphy", "bMurphy@gmail.com");
        assertEquals(brendanAccount.toString(), "Brendan Murphy bMurphy@gmail.com");
    }

    //tests that hasOpenRental returns true with a new rental
    @org.junit.Test
    public void testAddRental() throws VideoException {
        Account mikeAccount = new Account("Mike", "Murphy", "mMurphy@gmail.com");
        Video forrestGump = new Video("Forrest Gump", 1995);
        LocalDate dueDate = LocalDate.of(2019, 11, 21);
        new VideoRental(forrestGump, mikeAccount, dueDate);
        assertEquals(1, mikeAccount.getOpenRentals().size());
    }

    //tests that hasOpenRental returns false with no rentals
    @org.junit.Test
    public void testNoOpenRentals() throws VideoException {
        Account tomAccount = new Account("Tom", "Murphy", "tMurphy@gmail.com");
        assertEquals(0, tomAccount.getOpenRentals().size());
    }

    //tests that settleRentals adds a returned video to closed rentals list
    @org.junit.Test
    public void testSettleRentals() throws VideoException {
        Account mikeAccount = new Account("Mike", "Murphy", "mMurphy@gmail.com");
        LocalDate dueDate = LocalDate.of(2019, 11, 21);
        Video forrestGump = new Video("Forrest Gump", 1995);
        new VideoRental(forrestGump, mikeAccount, dueDate);
        mikeAccount.settleRentals();
        assertEquals(1, mikeAccount.getClosedRentals().size());
    }

    //tests that settleRentals adds all returned video to closed rentals list
    @org.junit.Test
    public void testSettleManyRentals() throws VideoException {
        Account mikeAccount = new Account("Mike", "Murphy", "mMurphy@gmail.com");
        LocalDate dueDate = LocalDate.of(2019, 11, 21);
        Video forrestGump = new Video("Forrest Gump", 1995);
        Video braveHeart = new Video("Brave Heart", 1995);
        new VideoRental(forrestGump, mikeAccount, dueDate);
        new VideoRental(braveHeart, mikeAccount, dueDate);
        mikeAccount.settleRentals();
        assertEquals(2, mikeAccount.getClosedRentals().size());
    }



    //tests that settleRental does not function when wrong video passed in
    @org.junit.Test
    public void testSettleRentalWrongVideo() throws VideoException {
        Account patAccount = new Account("Patrick", "Murphy", "pMurphy@gmail.com");
        LocalDate dueDate = LocalDate.of(2019, 11, 21);
        Video forrestGump = new Video("Forrest Gump", 1995);
        new Video("Brave Heart", 1995);
        new VideoRental(forrestGump, patAccount, dueDate);
        patAccount.settleRental("Brave Hear");
        assertEquals(0, patAccount.getClosedRentals().size());
    }

    //tests that clear history deletes outstanding rentals
    @org.junit.Test
    public void testClearHistory() throws VideoException {
        Account patAccount = new Account("Patrick", "Murphy", "pMurphy@gmail.com");
        LocalDate dueDate = LocalDate.of(2019, 11, 21);
        Video forrestGump = new Video("Forrest Gump", 1995);
        VideoRental rental = new VideoRental(forrestGump, patAccount, dueDate);
        patAccount.settleRental(rental);
        patAccount.clearHistory();
        assertEquals(0, patAccount.getClosedRentals().size());
    }

    //tests that equals method returns false with different accounts
    @org.junit.Test
    public void testEqualsNegativeScenario() {
        Account brendanAccount = new Account("Brendan", "Murphy", "bMurphy@gmail.com");
        Account mikeAccount = new Account("Mike", "Murphy", "mMurphy@gmail.com");
        assertFalse(brendanAccount.equals(mikeAccount));
    }

    //tests that equals method returns true with same accounts
    @org.junit.Test
    public void testEqualsPositiveScenario() {
        Account brendanAccount = new Account("Brendan", "Murphy", "bMurphy@gmail.com");
        Account brendanAccountClone = new Account("Brendan", "Murphy", "bMurphy@gmail.com");
        assertTrue(brendanAccount.equals(brendanAccountClone));
    }
}
