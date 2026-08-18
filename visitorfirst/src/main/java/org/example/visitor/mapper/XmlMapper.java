package org.example.visitor.mapper;

import org.example.visitor.dto.ParsedXml;

public interface XmlMapper {

    ParsedXml parse(String body);
}
