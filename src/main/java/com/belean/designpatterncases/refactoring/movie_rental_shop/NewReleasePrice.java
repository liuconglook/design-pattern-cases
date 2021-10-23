package com.belean.designpatterncases.refactoring.movie_rental_shop;

/**
 * 新发布价
 * @author belean
 * @date 2021/10/23
 */
public class NewReleasePrice implements Price {
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
        // 3$一天
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        // 如果租借的影片是新发布的，且租借大于1天，则额外累计1积分
        return daysRented > 1 ? 2 : 1;
    }
}
