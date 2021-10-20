package com.belean.designpatterncases.visitor;


/**
 * Unix 调制解调器 配置器
 * @author belean
 * @date 2021/10/19
 */
public class UnixModemConfigurator implements ModemVisitor {
    @Override
    public void visit(HayesModem modem) {
        modem.configurationString = "&s1=4&D=3";
    }

    @Override
    public void visit(ZoomModem modem) {
        modem.configurationValue = 42;
    }

    @Override
    public void visit(ErnieModem modem) {
        modem.configurationPattern = "C is too slow";
    }
}
