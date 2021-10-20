package com.belean.designpatterncases.state.state;

/**
 * @author belean
 * @date 2021/10/20
 */
public class LockedTurnstileState implements TurnstileState {

    @Override
    public void coin(Turnstile t) {
        t.setUnlocked();
        t.unlock();
    }

    @Override
    public void pass(Turnstile t) {
        t.alarm();
    }
}
