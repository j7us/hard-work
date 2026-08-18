package org.example.visitor.uploaders;

import org.example.visitor.Visitor;
import org.example.visitor.dto.TextDocument;

public class XmlDocumentUploader extends TextDocumentUploader {

    public XmlDocumentUploader(TextDocument document) {
        super(document);
    }

    @Override
    public void execute(Visitor visitor) {
        visitor.visit(this);
    }
}
