package com.welleys.stu.pattern.watcher;

import java.util.List;

public interface ISubject {
    public void addObserver(IObserver observer);

    public void delObserver(IObserver observer);

    public void notifyObservers();
}
