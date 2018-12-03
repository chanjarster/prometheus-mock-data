package me.chanjar.prometheus;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.List;

@Configuration
public class ComponentConfiguration {

  public static String filePath;

  @Bean
  public ScrapeDataProvider scrapeDataProvider() throws IOException {

    ScrapeDataReader metricDataReader = new ScrapeDataReader(filePath);
    List<String> metrics = metricDataReader.read();
    return new ScrapeDataProvider(metrics);
  }
}
