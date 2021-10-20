package com.belean.designpatterncases.state.state;

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
        assertTrue(t.isLocked());
    }

    public void testCoinInLockedState() {
        t.setLocked();
        t.coin();
        assertTrue(t.isUnlocked());
        assertTrue(unlockCalled);
    }

    public void testCoinInUnlockedState() {
        t.setUnlocked();
        t.coin();
        assertTrue(t.isUnlocked());
        assertTrue(thankyouCalled);
    }

    public void testPassInLockedState() {
        t.setLocked();
        t.pass();
        assertTrue(t.isLocked());
        assertTrue(alarmCalled);
    }

    public void testPassInUnlockedState() {
        t.setUnlocked();
        t.pass();
        assertTrue(t.isLocked());
        assertTrue(lockCalled);
    }
}
