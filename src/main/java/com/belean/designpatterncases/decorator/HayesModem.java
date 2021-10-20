package com.belean.designpatterncases.decorator;

/**
 * @author belean
 * @date 2021/10/19
 */
public class HayesModem implements Modem {

    private String phoneNumber;
    private int speakerVolume;

    @Override
    public void dial(String pno) {
        this.phoneNumber = pno;
    }

    @Override
    public void setSpeakerVolume(int volume) {
        this.speakerVolume = volume;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public int getSpeakerVolume() {
        return this.speakerVolume;
    }
}
