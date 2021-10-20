package com.belean.designpatterncases.visitor;

/**
 * 调制解调器
 * @author belean
 * @date 2021/10/18
 */
public interface Modem {

    /**
     * 拨号
     * @param pno 电话号码
     */
    void dial(String pno);

    /**
     * 挂断
     */
    void hangup();

    /**
     * 发送
     * @param c 字符
     */
    void send(char c);

    /**
     * 接收
     * @return 字符
     */
    char recv();

    /**
     * 接受
     * @param v 访客
     */
    void accept(ModemVisitor v);

}
