package me.chanjar.prometheus;

import java.util.Collections;
import java.util.List;

public class ScrapeDataProvider {

  private final List<String> scrapeDatas;

  private int iterationCount = 0;

  public ScrapeDataProvider(List<String> scrapeDatas) {
    this.scrapeDatas = Collections.unmodifiableList(scrapeDatas);
  }

  public synchronized String next() {

    if (scrapeDatas.isEmpty()) {
      return "";
    }

    String result = scrapeDatas.get(iterationCount % scrapeDatas.size());
    iterationCount++;
    return result;

  }

}
