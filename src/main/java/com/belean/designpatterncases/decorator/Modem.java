package com.belean.designpatterncases.decorator;

/**
 * @author belean
 * @date 2021/10/19
 */
public interface Modem {
    void dial(String pno);
    void setSpeakerVolume(int volume);
    String getPhoneNumber();
    int getSpeakerVolume();
}
