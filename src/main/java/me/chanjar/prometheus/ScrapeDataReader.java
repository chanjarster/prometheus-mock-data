package me.chanjar.prometheus;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ScrapeDataReader {

  private final String filePath;

  private final Pattern splitter = Pattern.compile("^-{3,}$");

  public ScrapeDataReader(String filePath) {
    this.filePath = filePath;
  }

  public List<String> read() throws IOException {

    File file = new File(filePath);

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

      List<String> scrapeDatas = new ArrayList<>();

      StringBuffer currentScrapeData = new StringBuffer();

      while (true) {

        String line = bufferedReader.readLine();
        if (line == null) {
          scrapeDatas.add(currentScrapeData.toString());
          return scrapeDatas;
        }

        if (splitter.matcher(line).matches()) {
          scrapeDatas.add(currentScrapeData.toString());
          currentScrapeData.delete(0, currentScrapeData.length());
          continue;
        }

        if (currentScrapeData.length() > 0) {
          currentScrapeData.append('\n');
        }
        currentScrapeData.append(line);
      }

    } catch (FileNotFoundException e) {

      throw new FileNotFoundException(file.getAbsolutePath());

    }

  }

}
