package com.belean.designpatterncases.visitor;

import junit.framework.TestCase;

/**
 * @author belean
 * @date 2021/10/19
 */
public class ModemVisitorTest extends TestCase {

    private UnixModemConfigurator unixModemConfigurator;
    private HayesModem hayesModem;
    private ZoomModem zoomModem;
    private ErnieModem ernieModem;

    public ModemVisitorTest(String name) {
        super(name);
    }

    @Override
    protected void setUp() throws Exception {
        unixModemConfigurator = new UnixModemConfigurator();
        hayesModem = new HayesModem();
        zoomModem = new ZoomModem();
        ernieModem = new ErnieModem();
    }

    public void testHayesForUnix() {
        hayesModem.accept(unixModemConfigurator);
        assertEquals("&s1=4&D=3", hayesModem.configurationString);
    }

    public void testZoomForUnix() {
        zoomModem.accept(unixModemConfigurator);
        assertSame(42, zoomModem.configurationValue);
    }

    public void testErnieForUnix() {
        ernieModem.accept(unixModemConfigurator);
        assertEquals("C is too slow", ernieModem.configurationPattern);
    }
}
