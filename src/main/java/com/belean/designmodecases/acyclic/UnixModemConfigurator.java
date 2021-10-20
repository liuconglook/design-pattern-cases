package com.belean.designmodecases.acyclic;

/**
 * @author belean
 * @date 2021/10/19
 */
public class UnixModemConfigurator implements ErnieModemVisitor, HayesModemVisitor, ZoomModemVisitor, ModemVisitor {
    @Override
    public void visit(ErnieModem ernieModem) {
        ernieModem.configurationPattern = "C is too slow";
    }

    @Override
    public void visit(HayesModem hayesModem) {
        hayesModem.configurationString = "&s1=4&D=3";
    }

    @Override
    public void visit(ZoomModem zoomModem) {
        zoomModem.configurationValue = 42;
    }
}
