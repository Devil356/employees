package com.arsenev.employees.util;

/**
 * POJO, который отправляется обратно подписчикам для
 * перерисовки таблицы. (Пока как заглушка)
 */
public class Plug {

    private String content;

    public Plug() {
    }

    public Plug(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}