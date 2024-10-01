package org.example;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Path filePath = Paths.get("data.txt");  // Especifica la ruta de tu archivo

        // Leer el archivo usando streams
        try (Stream<String> lines = Files.lines(filePath)) {
            lines.forEach(linea -> {
                String[] campos = linea.split("\\|");

            });  // Procesa e imprime cada línea
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}