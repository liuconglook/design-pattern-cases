package com.belean.designpatterncases.visitor;

/**
 * 变焦 调制解调器
 * @author belean
 * @date 2021/10/18
 */
public class ZoomModem implements Modem{

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
        v.visit(this);
    }
}
