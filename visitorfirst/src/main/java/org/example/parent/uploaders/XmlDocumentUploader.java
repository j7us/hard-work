package org.example.parent.uploaders;

import org.example.parent.repository.DocumentRepository;
import org.example.parent.dto.ParsedXml;
import org.example.parent.dto.TextDocument;
import org.example.parent.mapper.XmlMapper;
import org.example.parent.repository.ExecutionInfoRepository;

public class XmlDocumentUploader extends TextDocumentUploader {
    private final XmlMapper xmlMapper;
    private final ExecutionInfoRepository executionInfoRepository;

    public XmlDocumentUploader(DocumentRepository documentRepository,
                               XmlMapper xmlMapper,
                               ExecutionInfoRepository executionInfoRepository) {
        super(documentRepository);
        this.xmlMapper = xmlMapper;
        this.executionInfoRepository = executionInfoRepository;
    }

    @Override
    public void uploadDocument(TextDocument document) {
        ParsedXml parsedXml = xmlMapper.parse(document.getBody());
        executionInfoRepository.save(parsedXml);
    }
}
