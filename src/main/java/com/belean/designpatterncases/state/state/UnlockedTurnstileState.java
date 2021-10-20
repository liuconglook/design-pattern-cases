package com.belean.designpatterncases.state.state;

/**
 * @author belean
 * @date 2021/10/20
 */
public class UnlockedTurnstileState implements TurnstileState {
    @Override
    public void coin(Turnstile t) {
        t.thankyou();
    }

    @Override
    public void pass(Turnstile t) {
        t.setLocked();
        t.lock();
    }
}
