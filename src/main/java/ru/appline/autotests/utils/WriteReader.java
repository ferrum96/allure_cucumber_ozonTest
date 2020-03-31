package ru.appline.autotests.utils;

import ru.appline.autotests.pages.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static ru.appline.autotests.pages.BasePage.products;

public class WriteReader {


    public static class WriterReader {

        public static void write() throws IOException {

            FileOutputStream output = null;
            try {
                output = new FileOutputStream("src/main/resources/Products.txt");
                List<String> lines = new ArrayList<>();
                for (Product product : products)
                    lines.add(product.toString());
                final String LINE_SEPARATOR = System.getProperty("line.separator");
                for (String line : lines) {
                    if (line != null) {
                        output.write(line.getBytes());
                        output.write(LINE_SEPARATOR.getBytes());

                    }
                }
            } finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException ignore) {
                    }
                }
            }
        }
    }
}
