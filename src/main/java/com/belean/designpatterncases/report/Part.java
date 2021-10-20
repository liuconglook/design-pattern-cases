package com.belean.designpatterncases.report;

/**
 * @author belean
 * @date 2021/10/19
 */
public interface Part {
    String getPartNumber();
    String getDescription();
    void accept(PartVisitor v);
}
