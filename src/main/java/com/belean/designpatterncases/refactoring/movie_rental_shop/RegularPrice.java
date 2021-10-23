package com.belean.designpatterncases.refactoring.movie_rental_shop;

/**
 * 正常价
 * @author belean
 * @date 2021/10/23
 */
public class RegularPrice implements Price {
    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double getCharge(int daysRented) {
        // 租借不超过2天，只需要2$；超过2天的部分按1.5$一天算
        double amount = 2;
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }
        return amount;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
