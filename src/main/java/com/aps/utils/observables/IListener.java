package com.aps.utils.observables;

/**
 * Listener interface for handling events
 * @param <T> Listener type
 */
public interface IListener<T> {    
    public void call(T value);
}
