package com.belean.designpatterncases.state.state;

/**
 * @author belean
 * @date 2021/10/20
 */
public interface TurnstileState {

    void coin(Turnstile t);

    void pass(Turnstile t);

}
