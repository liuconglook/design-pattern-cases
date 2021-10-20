package com.belean.designpatterncases.report;

/**
 * 分解成本
 * @author belean
 * @date 2021/10/19
 */
public class ExplodedCostVisitor implements PartVisitor {

    private double cost = 0;

    public double cost() {
        return this.cost;
    }

    @Override
    public void visit(PiecePart piecePart) {
        this.cost += piecePart.getCost();
    }

    @Override
    public void visit(Assembly a) {

    }
}
