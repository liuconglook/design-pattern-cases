package com.belean.designmodecases.decorator;

/**
 * @author belean
 * @date 2021/10/19
 */
public class ModemDecorator implements Modem {

    private Modem modem;

    public ModemDecorator(Modem modem) {
        this.modem = modem;
    }

    @Override
    public void dial(String pno) {
        this.modem.dial(pno);
    }

    @Override
    public void setSpeakerVolume(int volume) {
        this.modem.setSpeakerVolume(volume);
    }

    @Override
    public String getPhoneNumber() {
        return this.modem.getPhoneNumber();
    }

    @Override
    public int getSpeakerVolume() {
        return this.modem.getSpeakerVolume();
    }

    public Modem getModem() {
        return modem;
    }
}
