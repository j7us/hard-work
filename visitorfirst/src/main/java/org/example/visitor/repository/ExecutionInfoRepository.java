package org.example.visitor.repository;

import org.example.visitor.dto.ParsedJson;
import org.example.visitor.dto.ParsedXml;

public interface ExecutionInfoRepository {
    void save(ParsedJson json);
    void save(ParsedXml xml);
}
