package ru.job4j.io.searchfiles;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor  extends SimpleFileVisitor<Path> {
    private boolean isPartOfName;
    List<Path> foundfiles = new ArrayList<>();
    private String partOfName;

    public List<Path> getFoundfiles() {
        return foundfiles;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
        isPartOfName = true;
    }
    
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (isPartOfName && file.getFileName().toString().contains(this.partOfName)) {
            foundfiles.add(file);
        }
        return super.visitFile(file, attrs);
    }
}
