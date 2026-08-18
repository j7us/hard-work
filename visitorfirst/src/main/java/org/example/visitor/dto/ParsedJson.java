package org.example.visitor.dto;

public class ParsedJson {

    private String content;

    public ParsedJson() {
    }

    public ParsedJson(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
