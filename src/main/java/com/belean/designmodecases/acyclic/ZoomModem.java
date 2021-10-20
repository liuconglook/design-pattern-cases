package com.belean.designmodecases.acyclic;

/**
 * @author belean
 * @date 2021/10/19
 */
public class ZoomModem implements Modem {

    Integer configurationValue = null;

    @Override
    public void dial(String pno) {

    }

    @Override
    public void hangup() {

    }

    @Override
    public void send(char c) {

    }

    @Override
    public char recv() {
        return 0;
    }

    @Override
    public void accept(ModemVisitor v) {
        try {
            ZoomModemVisitor zoomModemVisitor = (ZoomModemVisitor) v;
            zoomModemVisitor.visit(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
