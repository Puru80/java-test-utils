package com.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String REGEX_FILE = "/Users/puruagarwal/Downloads/Emails/classification_dataset - Transactional Mails - Regex - Sheet1.csv";
    private static final String INPUT_FILE = "/Users/puruagarwal/Downloads/Emails/classification_dataset-input.csv";
    private static final String OUTPUT_FILE = "/Users/puruagarwal/Downloads/Emails/classification_dataset-input-final.csv";
    private static final String OUTPUT_TEST_FILE = "/Users/puruagarwal/Downloads/Emails/classification_dataset-input-test.csv";
    private static final String MERCHANT_FILE = "/Users/puruagarwal/Downloads/PromotionalClassificationMaster-ExclusionMerchants.csv";
    private static final String AVATAR_FILE = "/Users/puruagarwal/Downloads/Rewards-Shopping-Report-Summary.csv";
    private static final List<String[]> result = new ArrayList<>();

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

    public static void updateEntityType() {
        for (String[] row : result) {
            if (row[3].equalsIgnoreCase("unknown"))
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

            Collections.shuffle(result);
            for (String[] row : result) {
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

    public static void main(String[] args) {
        try (FileReader inputReader = new FileReader(AVATAR_FILE)) {

            CSVReader inputCSVReader = new CSVReaderBuilder(inputReader)
//                    .withSkipLines(2)
                    .build();

            List<String[]> inputData = inputCSVReader.readAll();

            String outPut = "INSERT INTO public.classification_strategy (sender, criteria, strategy) VALUES('%s', '{}', 'TRANSACTIONAL_FIRST');";

            String output = "INSERT INTO public.avatar\n" +
                    "(\"name\", display_name, image_name, description)\n" +
                    "VALUES('%s', '%s', '%s', '%s');";

            int i=0;
            for (String[] arr : inputData) {
//                System.out.println(++i);
                System.out.println(String.format(output, arr[1].toUpperCase(Locale.ROOT), arr[1], arr[1], arr[4]));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
