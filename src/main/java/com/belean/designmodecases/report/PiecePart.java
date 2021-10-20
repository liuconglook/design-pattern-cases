package com.belean.designmodecases.report;

/**
 * 零部件
 * @author belean
 * @date 2021/10/19
 */
public class PiecePart implements Part {

    private String partNumber;
    private String description;
    private double cost;

    public PiecePart(String partNumber, String description, double cost) {
        this.partNumber = partNumber;
        this.description = description;
        this.cost = cost;
    }

    @Override
    public String getPartNumber() {
        return this.partNumber;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void accept(PartVisitor v) {
        v.visit(this);
    }

    public double getCost() {
        return this.cost;
    }
}
