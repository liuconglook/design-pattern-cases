package com.belean.designmodecases.extension;

/**
 * @author belean
 * @date 2021/10/20
 */
public class CSVPiecePartExtension implements CSVPartExtension {

    private PiecePart piecePart = null;

    public CSVPiecePartExtension(PiecePart part) {
        this.piecePart = part;
    }

    @Override
    public String getCSV() {
        StringBuffer str = new StringBuffer("PiecePart,");
        str.append(piecePart.getPartNumber());
        str.append(",");
        str.append(piecePart.getDescription());
        str.append(",");
        str.append(piecePart.getCost());
        return str.toString();
    }
}
