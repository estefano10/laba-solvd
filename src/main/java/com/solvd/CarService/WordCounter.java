package com.solvd.CarService;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class WordCounter {
    public static void main(String[] args) {
        //Read file
        File inputFile = new File("src/main/resources/text.txt");
        List<String> lines;
        try {
            lines = FileUtils.readLines(inputFile, StandardCharsets.UTF_8);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        //Counter
        String[] wordsToFind = {"QA", "programming", "Java"};

        StringBuilder result = new StringBuilder();
        for (String word : wordsToFind){
            int count = 0;
            for (String line : lines){
                count += StringUtils.countMatches(line, word);
            }
            result.append(word + ": " + count + "\n");
        }
        File output = new File("src/main/resources/output.txt");
        try {
            FileUtils.writeStringToFile(output, result.toString(), StandardCharsets.UTF_8, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
