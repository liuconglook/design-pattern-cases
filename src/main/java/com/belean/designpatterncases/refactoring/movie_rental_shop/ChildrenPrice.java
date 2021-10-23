package com.belean.designpatterncases.refactoring.movie_rental_shop;

/**
 * 儿童价
 * @author belean
 * @date 2021/10/23
 */
public class ChildrenPrice implements Price {
    @Override
    public int getPriceCode() {
        return Movie.CHILDREN;
    }

    @Override
    public double getCharge(int daysRented) {
        // 租借不超过3天，只要1.5$；超过3天的部分按1.5$一天算
        double amount = 1.5;
        if (daysRented > 3) {
            amount += (daysRented - 3) * 1.5;
        }
        return amount;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
