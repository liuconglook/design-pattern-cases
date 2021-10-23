package com.belean.designpatterncases.refactoring.movie_rental_shop;

/**
 * 租赁
 * @author belean
 * @date 2021/10/23
 */
public class Rental {

    /**
     * 租借的影片
     */
    Movie movie;

    /**
     * 租借天数
     */
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }


    double getCharge() {
        return movie.getCharge(daysRented);
    }

    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }

}
