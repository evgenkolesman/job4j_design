package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Map<Long, String> fileProp = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.getFileName().toString());
        if (!(fileProp.containsKey(fileProperty.getSize())
                && fileProp.containsValue(fileProperty.getName()))) {
            fileProp.put(fileProperty.getSize(), fileProperty.getName());
        } else {
            System.out.println(file.toAbsolutePath());
        }
        return super.visitFile(file, attrs);
    }
}