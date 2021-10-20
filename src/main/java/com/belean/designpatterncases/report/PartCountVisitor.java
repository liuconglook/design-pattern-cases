package com.belean.designpatterncases.report;

import java.util.HashMap;

/**
 * 零部件数量
 * @author belean
 * @date 2021/10/19
 */
public class PartCountVisitor implements PartVisitor {

    private int pieceCount = 0;
    private HashMap pieceMap = new HashMap();

    @Override
    public void visit(PiecePart piecePart) {
        this.pieceCount++;
        String partNumber = piecePart.getPartNumber();
        int partNumberCount = 0;
        if (this.pieceMap.containsKey(partNumber)) {
            Integer carrier = (Integer) this.pieceMap.get(partNumber);
            partNumberCount = carrier;
        }
        partNumberCount++;
        this.pieceMap.put(partNumber, partNumberCount);
    }

    @Override
    public void visit(Assembly a) {

    }

    public int getPieceCount() {
        return this.pieceCount;
    }

    public int getPartNumberCount() {
        return this.pieceMap.size();
    }

    public int getCountForPart(String partNumber) {
        int partNumberCount = 0;
        if (this.pieceMap.containsKey(partNumber)) {
            Integer carrier = (Integer) this.pieceMap.get(partNumber);
            partNumberCount = carrier.intValue();
        }
        return partNumberCount;
    }
}
