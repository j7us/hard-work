package org.example.parent.uploaders;

import org.example.parent.repository.DocumentRepository;
import org.example.parent.mapper.JsonMapper;
import org.example.parent.dto.ParsedJson;
import org.example.parent.dto.TextDocument;
import org.example.parent.repository.ExecutionInfoRepository;

public class JsonDocumentUploader extends TextDocumentUploader {
    private final JsonMapper jsonMapper;
    private final ExecutionInfoRepository executionInfoRepository;

    public JsonDocumentUploader(DocumentRepository documentRepository,
                                JsonMapper jsonMapper,
                                ExecutionInfoRepository executionInfoRepository) {
        super(documentRepository);
        this.jsonMapper = jsonMapper;
        this.executionInfoRepository = executionInfoRepository;
    }

    @Override
    public void uploadDocument(TextDocument document) {
        ParsedJson parsedJson = jsonMapper.parse(document.getBody());
        executionInfoRepository.save(parsedJson);
    }
}
