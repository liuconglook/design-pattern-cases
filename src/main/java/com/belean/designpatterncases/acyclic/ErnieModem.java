package com.belean.designpatterncases.acyclic;

/**
 * @author belean
 * @date 2021/10/19
 */
public class ErnieModem implements Modem {

    String configurationPattern =  null;

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
            ErnieModemVisitor ev = (ErnieModemVisitor) v;
            ev.visit(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
