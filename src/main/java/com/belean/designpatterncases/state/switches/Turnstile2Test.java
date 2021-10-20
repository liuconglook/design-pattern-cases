package com.belean.designpatterncases.state.switches;

import junit.framework.TestCase;

/**
 * @author belean
 * @date 2021/10/20
 */
public class Turnstile2Test extends TestCase {

    private Turnstile2 t;
    private boolean lockCalled = false;
    private boolean unlockCalled = false;
    private boolean thankyouCalled = false;
    private boolean alarmCalled = false;

    public Turnstile2Test(String name) {
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
        t = new Turnstile2(controllerSpoof);
    }

    public void testInitialConditions() {
        assertEquals(Turnstile2.LOCKED, t.state);
    }

    public void testCoinInLockedState() {
        t.state = Turnstile2.LOCKED;
        t.event(Turnstile2.COIN);
        assertEquals(Turnstile2.UNLOCKED, t.state);
        assertTrue(unlockCalled);
    }

    public void testCoinInUnlockedState() {
        t.state = Turnstile2.UNLOCKED;
        t.event(Turnstile2.COIN);
        assertEquals(Turnstile2.UNLOCKED, t.state);
        assertTrue(thankyouCalled);
    }

    public void testPassInLockedState() {
        t.state = Turnstile2.LOCKED;
        t.event(Turnstile2.PASS);
        assertEquals(Turnstile2.LOCKED, t.state);
        assertTrue(alarmCalled);
    }

    public void testPassInUnlockedState() {
        t.state = Turnstile2.UNLOCKED;
        t.event(Turnstile2.PASS);
        assertEquals(Turnstile2.LOCKED, t.state);
        assertTrue(lockCalled);
    }
}
