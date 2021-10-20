package com.belean.designpatterncases.state.switches;

import junit.framework.TestCase;

/**
 * @author belean
 * @date 2021/10/20
 */
public class TurnstileTest extends TestCase {

    private Turnstile t;
    private boolean lockCalled = false;
    private boolean unlockCalled = false;
    private boolean thankyouCalled = false;
    private boolean alarmCalled = false;

    public TurnstileTest(String name) {
        super(name);
    }

    @Override
    protected void setUp() throws Exception {
        TurnstileController controllerSpoof = new TurnstileController() {
            @Override
            public void lock() {
                lockCalled = true;
            }

            @Override
            public void unlock() {
                unlockCalled = true;
            }

            @Override
            public void thankyou() {
                thankyouCalled = true;
            }

            @Override
            public void alarm() {
                alarmCalled = true;
            }
        };
        t = new Turnstile(controllerSpoof);
    }

    public void testInitialConditions() {
        assertEquals(Turnstile.LOCKED, t.state);
    }

    public void testCoinInLockedState() {
        t.state = Turnstile.LOCKED;
        t.event(Turnstile.COIN);
        assertEquals(Turnstile.UNLOCKED, t.state);
        assertTrue(unlockCalled);
    }

    public void testCoinInUnlockedState() {
        t.state = Turnstile.UNLOCKED;
        t.event(Turnstile.COIN);
        assertEquals(Turnstile.UNLOCKED, t.state);
        assertTrue(thankyouCalled);
    }

    public void testPassInLockedState() {
        t.state = Turnstile.LOCKED;
        t.event(Turnstile.PASS);
        assertEquals(Turnstile.LOCKED, t.state);
        assertTrue(alarmCalled);
    }

    public void testPassInUnlockedState() {
        t.state = Turnstile.UNLOCKED;
        t.event(Turnstile.PASS);
        assertEquals(Turnstile.LOCKED, t.state);
        assertTrue(lockCalled);
    }
}
