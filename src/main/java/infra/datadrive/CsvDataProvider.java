package infra.datadrive;

import static utiles.ResourceUtils.getResourceAsString;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.DataProvider;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CsvDataProvider {

    @DataProvider(name = "dp")
    public static Object[][] createData(Method method) throws IOException, CsvValidationException {
        DataProviderSource source = method.getAnnotation(DataProviderSource.class);
        String csvContent = getResourceAsString("testData/" + source.name() + ".csv");
        List<String[]> data = csvStringToList(csvContent);
        return convertToObjectArray(data);
    }

    private static String cleanTextContent(String text)
    {
        // erases all the ASCII control characters
        text = text.replaceAll("[\\p{Cntrl}&&[^\r\n\t]]", "");

        // removes non-printable characters from Unicode
        text = text.replaceAll("\\p{C}", "");

        return text.trim();
    }

    private static List<String[]> csvStringToList(String csvContent) throws IOException, CsvValidationException {
        List<String[]> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new StringReader(csvContent))) {
            int lineIndex = 0;
            String[] line = reader.readNext();
            final int descriptionIndex = ArrayUtils.indexOf(line, "תיאור בדיקה");
            final int enabledIndex = ArrayUtils.indexOf(line, "Enabled");
            while ((line = reader.readNext()) != null) {
                for (int i = 0; i < line.length; i++) {
                    //line[i] = line[i].trim();
                    line[i] = cleanTextContent(line[i]);
                }
                if (descriptionIndex > -1) {
                    line[descriptionIndex] = (++lineIndex + 1) + " : " + line[descriptionIndex];
                }
                if (enabledIndex > -1) {
                    String isEnabled = line[enabledIndex];
                    if (isEnabled != null && isEnabled.toLowerCase().equals("false")) {
                        continue;
                    }
                    final List<String> lineAsList = new ArrayList<String>(Arrays.asList(line));
                    lineAsList.remove(enabledIndex);
                    data.add(lineAsList.toArray(new String[] {}));
                } else {
                    data.add(line);
                }
            }
        }
        return data;
    }

    private static Object[][] convertToObjectArray(List<String[]> data) {
        Object[][] dataAsArray = new Object[data.size()][];
        for (int i = 0; i < dataAsArray.length; i++) {
            dataAsArray[i] = data.get(i);
        }
        return dataAsArray;
    }

}
