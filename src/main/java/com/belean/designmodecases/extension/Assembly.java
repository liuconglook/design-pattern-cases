package com.belean.designmodecases.extension;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author belean
 * @date 2021/10/20
 */
public class Assembly extends Part {

    private List parts = new LinkedList();
    private String partNumber;
    private String description;

    public Assembly(String partNumber, String description) {
        this.partNumber = partNumber;
        this.description = description;
        addExtension("CSV", new CSVAssemblyExtension(this));
        addExtension("XML", new XMLAssemblyExtension(this));
    }

    @Override
    public String getPartNumber() {
        return this.partNumber;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void add(Part part) {
        parts.add(part);
    }

    public Iterator getParts() {
        return parts.iterator();
    }
}
