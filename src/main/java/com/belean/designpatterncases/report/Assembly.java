package com.belean.designpatterncases.report;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 部件集合
 * @author belean
 * @date 2021/10/19
 */
public class Assembly implements Part {

    private List parts = new LinkedList();
    private String partNumber;
    private String description;

    public Assembly(String partNumber, String description) {
        this.partNumber = partNumber;
        this.description = description;
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
        Iterator iterator = getParts();
        while(iterator.hasNext()) {
            Part p = (Part) iterator.next();
            p.accept(v);
        }
    }

    public void add(Part part) {
        this.parts.add(part);
    }

    public Iterator getParts() {
        return this.parts.iterator();
    }
}
