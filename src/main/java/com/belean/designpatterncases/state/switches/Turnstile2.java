package com.belean.designpatterncases.state.switches;

import java.util.Vector;

/**
 * @author belean
 * @date 2021/10/20
 */
public class Turnstile2 {

    // States
    public static final int LOCKED = 0;
    public static final int UNLOCKED = 1;

    // Events
    public static final int COIN = 0;
    public static final int PASS = 1;

    int state = LOCKED;

    private TurnstileController turnstileController;
    private Vector<Transition> transitions = new Vector();

    private interface Action {
        void execute();
    }

    private class Transition {
        int currentState;
        int event;
        int newState;
        Action action;

        public Transition(int currentState, int event, int newState, Action action) {
            this.currentState = currentState;
            this.event = event;
            this.newState = newState;
            this.action = action;
        }
    }

    public Turnstile2(TurnstileController action) {
        this.turnstileController = action;
        addTransition(LOCKED, COIN, UNLOCKED, unlock());
        addTransition(LOCKED, PASS, UNLOCKED, alarm());
        addTransition(UNLOCKED, COIN, UNLOCKED, thankyou());
        addTransition(UNLOCKED, PASS, LOCKED, lock());
    }

    private void addTransition(int currentState, int event, int newState, Action action) {
        this.transitions.add(new Transition(currentState, event, newState, action));
    }

    private Action lock() {
        return new Action() {
            @Override
            public void execute() {
                doLock();
            }
        };
    }

    private Action thankyou() {
        return new Action() {
            @Override
            public void execute() {
                doThankyou();
            }
        };
    }

    private Action unlock() {
        return new Action() {
            @Override
            public void execute() {
                doUnlock();
            }
        };
    }

    private Action alarm() {
        return new Action() {
            @Override
            public void execute() {
                doAlarm();
            }
        };
    }

    private void doLock() {
        turnstileController.lock();
    }

    private void doUnlock() {
        turnstileController.unlock();
    }

    private void doAlarm() {
        turnstileController.alarm();
    }

    private void doThankyou() {
        turnstileController.thankyou();
    }

    public void event(int event) {
        for(Transition transition : transitions) {
            if(state == transition.currentState && event == transition.event) {
                state = transition.newState;
                transition.action.execute();
            }
        }
    }
}
