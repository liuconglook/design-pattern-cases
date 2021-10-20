package com.belean.designmodecases.acyclic;

import junit.framework.TestCase;

/**
 * @author belean
 * @date 2021/10/19
 */
public class ModemVisitorTest extends TestCase {

    private ModemVisitor modemVisitor;

    public ModemVisitorTest(String name) {
        super(name);
    }

    @Override
    protected void setUp() throws Exception {
        modemVisitor = new UnixModemConfigurator();
    }

    public void testHayesForUnix() {
        HayesModem hayesModem = new HayesModem();
        hayesModem.accept(modemVisitor);
        assertEquals("&s1=4&D=3", hayesModem.configurationString);
    }

    public void testZoomForUnix() {
        ZoomModem zoomModem = new ZoomModem();
        zoomModem.accept(modemVisitor);
        assertSame(42, zoomModem.configurationValue);
    }

    public void testErnieForUnix() {
        ErnieModem ernieModem = new ErnieModem();
        ernieModem.accept(modemVisitor);
        assertEquals("C is too slow", ernieModem.configurationPattern);
    }
}
