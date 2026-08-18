package org.example.visitor;

import org.example.visitor.dto.ParsedJson;
import org.example.visitor.dto.ParsedXml;
import org.example.visitor.mapper.JsonMapper;
import org.example.visitor.mapper.XmlMapper;
import org.example.visitor.repository.DocumentRepository;
import org.example.visitor.repository.ExecutionInfoRepository;
import org.example.visitor.uploaders.JsonDocumentUploader;
import org.example.visitor.uploaders.TextDocumentUploader;
import org.example.visitor.uploaders.XmlDocumentUploader;

public class Visitor {
    private final DocumentRepository documentRepository;
    private final JsonMapper jsonMapper;
    private final XmlMapper xmlMapper;
    private final ExecutionInfoRepository executionInfoRepository;

    public Visitor(DocumentRepository documentRepository,
                   JsonMapper jsonMapper,
                   XmlMapper xmlMapper,
                   ExecutionInfoRepository executionInfoRepository) {
        this.documentRepository = documentRepository;
        this.jsonMapper = jsonMapper;
        this.xmlMapper = xmlMapper;
        this.executionInfoRepository = executionInfoRepository;
    }

    public void visit(TextDocumentUploader uploader) {
        documentRepository.save(uploader.getDocument());
    }

    public void visit(JsonDocumentUploader uploader) {
        ParsedJson parsedJson = jsonMapper.parse(uploader.getDocument().getBody());
        executionInfoRepository.save(parsedJson);
    }

    public void visit(XmlDocumentUploader uploader) {
        ParsedXml parsedXml = xmlMapper.parse(uploader.getDocument().getBody());
        executionInfoRepository.save(parsedXml);
    }
}
