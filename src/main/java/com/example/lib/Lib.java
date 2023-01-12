package com.example.lib;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public record Lib(
  Class<?> klass
) {
  public BufferedReader getResource(String name) throws IOException {
    var loader = klass.getClassLoader();
    var resource = loader.getResourceAsStream(name);
    if (resource == null) throw new IOException("%s not found".formatted(name));
    var reader = new InputStreamReader(resource, StandardCharsets.UTF_8);
    return new BufferedReader(reader);
  }
}

