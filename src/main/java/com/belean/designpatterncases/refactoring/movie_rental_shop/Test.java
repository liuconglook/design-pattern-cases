package com.belean.designpatterncases.refactoring.movie_rental_shop;

import junit.framework.TestCase;

/**
 * @author belean
 * @date 2021/10/23
 */
public class Test extends TestCase {

    public Test(String name) {
        super(name);
    }

    public void testCreate() {
        Movie movie = new Movie("海上钢琴师", Movie.REGULAR);
        assertNotNull(movie);
        assertEquals("海上钢琴师", movie.getTitle());
        assertEquals(Movie.REGULAR, movie.getPrice().getPriceCode());

        Rental rental = new Rental(movie, 2);
        assertNotNull(rental);
        assertEquals(rental.getMovie(), movie);
        assertEquals(2, rental.getDaysRented());

        Customer customer = new Customer("1900");
        assertNotNull(customer);
        assertEquals("1900", customer.getName());
        customer.addRental(rental);
        assertEquals(2, customer.getTotalAmount(), 0.01);
        assertEquals(1, customer.getTotalFrequentRenterPoints());
    }

}
