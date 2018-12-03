package me.chanjar.prometheus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {

    if (args.length == 0) {
      System.out.println("Prometheus mock metrics client.");
      System.out.println("Usage:");
      System.out.println("java -jar mock-metrics-client.jar <path-to-scrape-data>");
      System.exit(1);
    }
    ComponentConfiguration.filePath = args[0];
    SpringApplication.run(Application.class, args);
  }

}
