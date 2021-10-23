package com.belean.designpatterncases.refactoring.movie_rental_shop;

/**
 * @author belean
 * @date 2021/10/23
 */
public interface Price {
    /**
     * 获片价格类型代码
     * @return
     */
    int getPriceCode();

    /**
     * 根据租借天数计算费用
     * @param daysRented
     * @return
     */
    double getCharge(int daysRented);

    /**
     * 根据租借天数计算积分
     * @param daysRented
     * @return
     */
    int getFrequentRenterPoints(int daysRented);
}
