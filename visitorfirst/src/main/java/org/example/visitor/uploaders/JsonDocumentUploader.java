package org.example.visitor.uploaders;

import org.example.visitor.Visitor;
import org.example.visitor.dto.TextDocument;

public class JsonDocumentUploader extends TextDocumentUploader {

    public JsonDocumentUploader(TextDocument document) {
        super(document);
    }

    @Override
    public void execute(Visitor visitor) {
        visitor.visit(this);
    }
}
