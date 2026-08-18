package org.example.visitor.dto;

public class ParsedXml {

    private String content;

    public ParsedXml() {
    }

    public ParsedXml(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
