package com.bit.listener;

import java.util.EventObject;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName PlayEvent.java
 * @Description play event
 * @createTime 2020年03月14日 18:57:00
 */
public class PlayEvent extends EventObject {
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public PlayEvent(String fileName, Object source) {
        super(source);
        this.fileName = fileName;
    }
}