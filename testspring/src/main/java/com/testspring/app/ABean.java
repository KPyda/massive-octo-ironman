package com.testspring.app;

/**
 * Created by Praktykant on 02.09.14.
 */
public class ABean {
    private String text;

    public ABean() {}

    public ABean(String text) {
        setText(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
