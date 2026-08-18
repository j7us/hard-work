package org.example.parent.mapper;

import org.example.parent.dto.ParsedJson;

public interface JsonMapper {

    ParsedJson parse(String body);
}
