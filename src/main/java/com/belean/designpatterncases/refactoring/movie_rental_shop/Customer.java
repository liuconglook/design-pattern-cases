package com.belean.designpatterncases.refactoring.movie_rental_shop;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 顾客
 * @author belean
 * @date 2021/10/23
 */
public class Customer {

    /**
     * 顾客姓名
     */
    private String name;

    /**
     * 租借集合
     */
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }

    /**
     * 生成详单
     * @return
     */
    public String statement() {
        StringBuffer result = new StringBuffer();
        setHttpHeader(result);

        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental rental = (Rental) rentals.nextElement();
            addDetailForHtml(result, rental);
        }

        setHtmlFooter(result);
        return result.toString();
    }

    /**
     * 添加详单细目
     * @param result
     * @param rental
     */
    private void addDetailForHtml(StringBuffer result, Rental rental) {
        result.append("\t");
        result.append(rental.getMovie().getTitle());
        result.append("\t");
        result.append(rental.getCharge());
        result.append("\n");
    }

    /**
     * 设置表尾
     * @param result
     */
    private void setHtmlFooter(StringBuffer result) {
        result.append("Amount owed is ");
        result.append(getTotalAmount());
        result.append("\n");
        result.append("You earned ");
        result.append(getTotalFrequentRenterPoints());
        result.append(" frequent renter points");
    }

    /**
     * 设置表头
     * @param result
     */
    private void setHttpHeader(StringBuffer result) {
        result.append("Rental Record for ");
        result.append(name);
        result.append("\n");
    }

    /**
     * 合计积分
     * @return
     */
    public int getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental rental = (Rental) rentals.nextElement();
            frequentRenterPoints += rental.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    /**
     * 合计费用
     * @return
     */
    public double getTotalAmount() {
        double totalAmount = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental rental = (Rental) rentals.nextElement();
            totalAmount += rental.getCharge();
        }
        return totalAmount;
    }


}
