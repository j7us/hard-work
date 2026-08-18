package org.example.parent.repository;

import org.example.parent.dto.ParsedJson;
import org.example.parent.dto.ParsedXml;

public interface ExecutionInfoRepository {
    void save(ParsedJson json);
    void save(ParsedXml xml);
}
