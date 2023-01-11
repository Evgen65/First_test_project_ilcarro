package manager;

import models.Find;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderForFindCar {
    @DataProvider
    public Iterator<Object[]> findCarModelDto() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Find.builder()
                .city("Tel-Aviv")
                .firstDates("3/11/2023")
                .lastDates("4/13/2023")
                .build()});
        list.add(new Object[]{Find.builder()
                .city("Haifa")
                .firstDates("3/12/2023")
                .lastDates("4/15/2023")
                .build()});
        list.add(new Object[]{Find.builder()
                .city("Bat Yam")
                .firstDates("3/12/2023")
                .lastDates("4/19/2023")
                .build()});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> findCarModelDtoFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader
                (new FileReader(new File("C:\\repositoris\\First_test_project_ilcarro\\src\\test\\resources\\data.csv")));
        String line = bufferedReader.readLine();//Tel-Aviv,10/9/2023,12/13/2023
        while (line != null) {
            String[] split = ",".split(line);
            list.add(new Object[]{Find.builder()
                    .city(split[0])
                    .firstDates(split[1])
                    .lastDates(split[2])
                    .build()});
        }
        return list.iterator();
    }
}