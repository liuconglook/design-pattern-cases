package com.belean.designpatterncases.refactoring.movie_rental_shop;

/**
 * 影片
 * @author belean
 * @date 2021/10/23
 */
public class Movie {

    /**
     * 儿童价
     */
    public static final int CHILDREN = 2;

    /**
     * 正常价
     */
    public static final int REGULAR = 0;

    /**
     * 新发布价
     */
    public static final int NEW_RELEASE = 1;

    /**
     * 影片名称
     */
    private String title;

    /**
     * 价格
     */
     private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public Price getPrice() {
        return price;
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                this.price = new RegularPrice();
                break;
            case NEW_RELEASE:
                this.price = new NewReleasePrice();
                break;
            case CHILDREN:
                this.price = new ChildrenPrice();
                break;
            default:
        }
    }

    public String getTitle() {
        return title;
    }

    /**
     * 获取租借费用
     * @param daysRented
     * @return
     */
    double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    /**
     * 计算积分
     *
     * @return
     */
    int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }
}
