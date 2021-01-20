package com.bit.listener;

import java.util.*;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName Player.java
 * @Description TODO
 * @createTime 2020年03月14日 19:00:00
 * @remark PlayListener的实现应该有独立的类，这里做简化处理。
 */
public class Player implements IEventPublisher {
    private List<IPlayListener> repository = new ArrayList<>();

    private Object lock = new Object();

    private Object regLock = new Object();

    public void play(String fileName) {
        publish(new PlayEvent(fileName, this));
    }

    @Override
    public void register(IPlayListener listener) {
        synchronized (regLock) {
            repository.add(listener);
        }
    }

    @Override
    public void publish(PlayEvent event) {
        IPlayListener listener = null;
        Iterator<IPlayListener> iterator = repository.listIterator();
        if(repository == null || repository.size() == 0) {
            return;
        }
        synchronized (lock) {
            while (iterator.hasNext() && (listener = iterator.next()) != null) {
                listener.onEvent(event);
            }
        }
    }
}