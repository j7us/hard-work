package org.example.visitor.mapper;

import org.example.visitor.dto.ParsedJson;

public interface JsonMapper {

    ParsedJson parse(String body);
}
