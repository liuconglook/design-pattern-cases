package com.belean.designpatterncases.state.state;

import com.belean.designpatterncases.state.switches.TurnstileController;

/**
 * @author belean
 * @date 2021/10/20
 */
public class Turnstile {

    private static TurnstileState lockedState = new LockedTurnstileState();
    private static TurnstileState unlockedState = new UnlockedTurnstileState();

    private TurnstileController turnstileController;
    private TurnstileState state = lockedState;

    public Turnstile(TurnstileController action) {
        this.turnstileController = action;
    }

    public void coin() {
        state.coin(this);
    }

    public void pass() {
        state.pass(this);
    }

    public void setLocked() {
        state = lockedState;
    }

    public void setUnlocked() {
        state = unlockedState;
    }

    public boolean isLocked() {
        return state == lockedState;
    }

    public boolean isUnlocked() {
        return state == unlockedState;
    }

    void thankyou() {
        turnstileController.thankyou();
    }

    void alarm() {
        turnstileController.alarm();
    }

    void lock() {
        turnstileController.lock();
    }

    void unlock() {
        turnstileController.unlock();
    }
}
