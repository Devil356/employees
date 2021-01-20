package com.arsenev.employees.util.WebSocket;

/**
 * POJO, который отправляется обратно подписчикам для
 * перерисовки таблицы. (Пока как заглушка)
 */
public class Update {

    private Long draw;
    private Long length;
    private Long start;

    public Update(Long draw, Long length, Long start) {
        this.draw = draw;
        this.length = length;
        this.start = start;
    }

    public Long getDraw() {
        return draw;
    }

    public void setDraw(Long draw) {
        this.draw = draw;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }
}