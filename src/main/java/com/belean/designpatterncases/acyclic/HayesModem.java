package com.belean.designpatterncases.acyclic;

/**
 * @author belean
 * @date 2021/10/19
 */
public class HayesModem implements Modem{

    String configurationString = null;

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
            HayesModemVisitor hayesModemVisitor = (HayesModemVisitor) v;
            hayesModemVisitor.visit(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
