package org.example.visitor.uploaders;

import org.example.visitor.Visitor;
import org.example.visitor.dto.TextDocument;

public class TextDocumentUploader {
    private final TextDocument document;

    public TextDocumentUploader(TextDocument document) {
        this.document = document;
    }

    public TextDocument getDocument() {
        return document;
    }

    public void execute(Visitor visitor) {
        visitor.visit(this);
    }
}
