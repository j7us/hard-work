package org.example.parent.mapper;

import org.example.parent.dto.ParsedXml;

public interface XmlMapper {

    ParsedXml parse(String body);
}
