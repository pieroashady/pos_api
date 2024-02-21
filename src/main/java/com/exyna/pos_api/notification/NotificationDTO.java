package com.exyna.pos_api.notification;

import java.util.Date;
import java.util.Objects;

public class NotificationDTO {

    private Date date;
    private String title;
    private String content;

    public NotificationDTO() {
    }

    public NotificationDTO(Date date, String title, String content) {
        this.date = date;
        this.title = title;
        this.content = content;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NotificationDTO date(Date date) {
        setDate(date);
        return this;
    }

    public NotificationDTO title(String title) {
        setTitle(title);
        return this;
    }

    public NotificationDTO content(String content) {
        setContent(content);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof NotificationDTO)) {
            return false;
        }
        NotificationDTO notification = (NotificationDTO) o;
        return Objects.equals(date, notification.date) && Objects.equals(title, notification.title)
                && Objects.equals(content, notification.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, title, content);
    }

    @Override
    public String toString() {
        return "{" +
                " date='" + getDate() + "'" +
                ", title='" + getTitle() + "'" +
                ", content='" + getContent() + "'" +
                "}";
    }

}
