package com.belean.designpatterncases.visitor;

/**
 * 调制解调器 访问者模式
 * @author belean
 * @date 2021/10/18
 */
public interface ModemVisitor {

    /**
     * 访问
     * @param modem 海耶斯 调制解调器
     */
    void visit(HayesModem modem);

    /**
     * 访问
     * @param modem 变焦 调制解调器
     */
    void visit(ZoomModem modem);

    /**
     * 访问
     * @param modem 厄尼 调制解调器
     */
    void visit(ErnieModem modem);
}
