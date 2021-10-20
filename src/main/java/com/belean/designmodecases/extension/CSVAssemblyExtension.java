package com.belean.designmodecases.extension;

import java.util.Iterator;

/**
 * @author belean
 * @date 2021/10/20
 */
public class CSVAssemblyExtension implements CSVPartExtension {

    private Assembly assembly = null;

    public CSVAssemblyExtension(Assembly assembly) {
        this.assembly = assembly;
    }

    @Override
    public String getCSV() {
        StringBuffer str = new StringBuffer("Assembly,");
        str.append(assembly.getPartNumber());
        str.append(",");
        str.append(assembly.getDescription());

        Iterator i = assembly.getParts();
        while(i.hasNext()) {
            Part p = (Part) i.next();
            CSVPartExtension ce = (CSVPartExtension) p.getExtension("CSV");
            str.append(",{");
            str.append(ce.getCSV());
            str.append("}");
        }
        return str.toString();
    }
}
