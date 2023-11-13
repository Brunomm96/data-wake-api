package br.com.datawake.datawakeapi.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;
public class StringResourceCreatedEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    private HttpServletResponse response;
    private String tag;

    public StringResourceCreatedEvent(Object source, HttpServletResponse response, String tag) {
        super(source);
        this.response = response;
        this.tag = tag;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public String getTag() {
        return tag;
    }

}