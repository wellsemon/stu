package com.welleys.stu.pattern.watcher;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubjectSimpleImpl implements ISubject {
    private Date date;
    private double salary;

    private List<IObserver> observers;

    public SubjectSimpleImpl() {
        observers = new ArrayList<IObserver>();
    }

    public void addObserver(IObserver observer) {
        if (null != observer && !observers.contains(observer))
            observers.add(observer);
    }

    public void delObserver(IObserver observer) {
        if (null != observer && observers.contains(observer))
            observers.remove(observer);
    }

    public void notifyObservers() {
        if (null != observers) {
            for (IObserver observer : observers) {
                if (null != observer)
                observer.update(this.date, this.salary);
            }
        }
    }

    public void setSubject(Date date, double salary){
        this.date = date;
        this.salary = salary;

        subjectChanged();
    }

    public void subjectChanged(){
        notifyObservers();
    }
}
