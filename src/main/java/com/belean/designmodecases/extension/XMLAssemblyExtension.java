package com.belean.designmodecases.extension;

import java.util.Iterator;

/**
 * @author belean
 * @date 2021/10/20
 */
public class XMLAssemblyExtension implements XMLPartExtension {

    private Assembly assembly = null;

    public XMLAssemblyExtension(Assembly assembly) {
        this.assembly = assembly;
    }

    @Override
    public Element getXMLElement() {
        Element e = new Element("Assembly");
        e.addContent(new Element("PartNumber").setText(assembly.getPartNumber()));
        e.addContent(new Element("Description").setText(assembly.getDescription()));
        Element parts = new Element("Parts");
        e.addContent(parts);
        Iterator i = assembly.getParts();
        while(i.hasNext()) {
            Part p = (Part) i.next();
            PartExtension pe = p.getExtension("XML");
            XMLPartExtension xpe = (XMLPartExtension) pe;
            parts.addContent(xpe.getXMLElement());
        }
        return e;
    }
}
