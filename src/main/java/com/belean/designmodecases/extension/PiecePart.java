package com.belean.designmodecases.extension;

/**
 * @author belean
 * @date 2021/10/20
 */
public class PiecePart extends Part {

    private String partNumber;
    private String description;
    private double cost;

    public PiecePart(String partNumber, String description, double cost) {
        this.partNumber = partNumber;
        this.description = description;
        this.cost = cost;
        addExtension("CSV", new CSVPiecePartExtension(this));
        addExtension("XML", new XMLPiecePartExtension(this));
    }

    @Override
    public String getPartNumber() {
        return this.partNumber;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    public double getCost() {
        return cost;
    }
}
