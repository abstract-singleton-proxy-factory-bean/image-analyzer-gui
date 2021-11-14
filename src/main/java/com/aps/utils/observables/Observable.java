package com.aps.utils.observables;

import java.util.ArrayList;

/**
 * Observable class helper for subscribing to events on data
 * @param <T> Observable type 
 */
public class Observable<T> {
    private T state;
    private final ArrayList<IListener<T>> beforeChangeListeners;
    private final ArrayList<IListener<T>> afterChangeListeners;
    
    public Observable(T state) {
        this.state = state;
        this.beforeChangeListeners = new ArrayList<>();
        this.afterChangeListeners = new ArrayList<>();
    }
    
    /**
     * Subscribes to any internal state change before the state is mutated
     * @param listener Listener to add to the list of listeners
     */
    public void subscribeToBeforeChange(IListener<T> listener) {
        this.beforeChangeListeners.add(listener);
    }
    
    /**
     * Subscribes to any internal state change after the state is mutated
     * @param listener Listener to add to the list of listeners
     */
    public void subscribeToAfterChange(IListener<T> listener) {
        this.afterChangeListeners.add(listener);
    }
    
    /**
     * Dispatches all listeners passed to it
     * @param listeners Listeners to be notified
     * @param state State to pass to the listeners
     */
    private void dispatchListeners(ArrayList<IListener<T>> listeners, T state) {
        listeners.forEach(listener -> {
            listener.call(state);
        });
    }
    
    /**
     * Sets the internal state of the observable
     * @param state Value to mutate the original state to
     */
    public void setState(T state) {
        this.dispatchListeners(beforeChangeListeners, state);
        this.state = state;
        this.dispatchListeners(afterChangeListeners, state);
    }

    /**
     * Getter for the internal state
     * @return internal state
     */
    public T getState() {
        return this.state;
    }
}

