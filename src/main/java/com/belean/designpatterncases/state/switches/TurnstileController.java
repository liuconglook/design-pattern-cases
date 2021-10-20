package com.belean.designpatterncases.state.switches;

/**
 * @author belean
 * @date 2021/10/20
 */
public interface TurnstileController {
    void lock();
    void unlock();
    void thankyou();
    void alarm();
}
