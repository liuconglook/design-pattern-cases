package com.belean.designmodecases.extension;

/**
 * @author belean
 * @date 2021/10/20
 */
public class XMLPiecePartExtension implements XMLPartExtension {

    private PiecePart piecePart = null;

    public XMLPiecePartExtension(PiecePart part) {
        this.piecePart = part;
    }

    @Override
    public Element getXMLElement() {
        Element e = new Element("PiecePart");
        e.addContent(new Element("PartNumber").setText(piecePart.getPartNumber()));
        e.addContent(new Element("Description").setText(piecePart.getDescription()));
        e.addContent(new Element("Cost").setText(Double.toString(piecePart.getCost())));
        return e;
    }
}
