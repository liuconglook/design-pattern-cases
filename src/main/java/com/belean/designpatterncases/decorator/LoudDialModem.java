package com.belean.designpatterncases.decorator;

/**
 * @author belean
 * @date 2021/10/19
 */
public class LoudDialModem extends ModemDecorator {

    public LoudDialModem(Modem modem) {
        super(modem);
    }

    @Override
    public void dial(String pno) {
        getModem().setSpeakerVolume(10);
        getModem().dial(pno);
    }
}
