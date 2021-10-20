package com.belean.designmodecases.report;

/**
 * @author belean
 * @date 2021/10/19
 */
public interface PartVisitor {
    void visit(PiecePart piecePart);
    void visit(Assembly a);
}
