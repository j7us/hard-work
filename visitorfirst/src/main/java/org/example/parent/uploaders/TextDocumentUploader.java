package org.example.parent.uploaders;

import org.example.parent.repository.DocumentRepository;
import org.example.parent.dto.TextDocument;

public class TextDocumentUploader {
    private final DocumentRepository documentRepository;

    public TextDocumentUploader(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public void uploadDocument(TextDocument document) {
        documentRepository.save(document);
    }
}
