package com.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String REGEX_FILE = "/Users/puruagarwal/Downloads/Emails/classification_dataset - Transactional Mails - Regex - Sheet1.csv";
    private static final String INPUT_FILE = "/Users/puruagarwal/Downloads/Emails/classification_dataset-input.csv";
    private static final String OUTPUT_FILE = "/Users/puruagarwal/Downloads/Emails/classification_dataset-input-final.csv";
    private static final String OUTPUT_TEST_FILE = "/Users/puruagarwal/Downloads/Emails/classification_dataset-input-test.csv";
    private static final List<String[]> result = new ArrayList<>();

    /*public static void verifyRegex(String email, List<String[]> criteriaData){
        for (String[] criteriaRow : criteriaData) {
            if(Pattern.matches(criteriaRow[2], email)) {
                System.out.println(true);
                break;
            }
        }
    }*/

    public static void checkOutput() {
        try (FileReader outputReader = new FileReader(OUTPUT_FILE)) {
            CSVReader outputCSVReader = new CSVReaderBuilder(outputReader)
                    .withSkipLines(1)
                    .build();

            List<String[]> outputData = outputCSVReader.readAll();
            int countUnknown = 0;
            int countRes = 0;

            for (String[] row : outputData) {
                if (row[2].equalsIgnoreCase("PROMOTIONAL"))
                    countUnknown++;
                else
                    countRes++;
            }

            System.out.println("Final List: " + result.size());
            System.out.println("PROMOTIONAL: " + countUnknown);
            System.out.println("TRANSACTIONAL_ORDER: " + countRes);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateEntityType(){
        for (String[] row: result){
            if(row[3].equalsIgnoreCase("unknown"))
                row[2] = "PROMOTIONAL";
            else row[2] = "TRANSACTIONAL_ORDER";
        }
    }

    public static void saveFile() {
        File file = new File(OUTPUT_FILE);
        try {
            FileWriter outputFile = new FileWriter(file);

            CSVWriter writer = new CSVWriter(outputFile);

            String[] header = {"Email", "Sender", "Category", "Entity"};
            writer.writeNext(header);

            /*int count = 0;
            List<Integer> list = new ArrayList<>();
            List<String[]> finalResult = new ArrayList<>();

            for (int i=0;i< result.size();i++) {
                if(!result.get(i)[2].equalsIgnoreCase("PROMOTIONAL")) {
                    finalResult.add(result.get(i));
                    count++;
                }
                else list.add(i);
            }

            Collections.shuffle(list);
            for(int i=0;i<count;i++)
                finalResult.add(result.get(list.get(i)));

            Collections.shuffle(finalResult);
            for(String[]  row: finalResult)
                writer.writeNext(row);
                */

            Collections.shuffle(result);
            for(String[] row: result){
                writer.writeNext(row);
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void classifyRegex(List<String[]> criteriaData, List<String[]> inputData) {
        for (String[] inputRow : inputData) {
            String[] resultRow = new String[4];
            resultRow[0] = inputRow[0];
            resultRow[1] = inputRow[1];
            resultRow[2] = inputRow[2];

            int added = 0;
            for (String[] criteriaRow : criteriaData) {
                Pattern pattern = Pattern.compile(criteriaRow[0].toLowerCase());
                Matcher matcher = pattern.matcher(inputRow[0].toLowerCase());

                if (matcher.find()) {
                    resultRow[3] = criteriaRow[2];
                    added = 1;
                    break;
                }
            }

            if (added == 0)
                resultRow[3] = "unknown";

            result.add(resultRow);
        }

        updateEntityType();
        saveFile();
    }

    /*
    public static void main(String[] args) {
        try (FileReader criteriaReader = new FileReader(REGEX_FILE);
             FileReader inputReader = new FileReader(INPUT_FILE)) {

            CSVReader criteriaCSVReader = new CSVReaderBuilder(criteriaReader)
                    .withSkipLines(1)
                    .build();
            CSVReader inputCSVReader = new CSVReaderBuilder(inputReader)
                    .withSkipLines(1)
                    .build();

            List<String[]> criteriaData = criteriaCSVReader.readAll();
            List<String[]> inputData = inputCSVReader.readAll();

            classifyRegex(criteriaData, inputData);

        } catch (Exception e) {
            e.printStackTrace();
        }

        checkOutput();
    }

     */

    /*public static String toRegex(Iterable<String> strings) {
        return StreamSupport.stream(strings.spliterator(), false)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }*/
}
