package me.chanjar.prometheus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricsEndpoint {

  @Autowired
  private ScrapeDataProvider scrapeDataProvider;

  @RequestMapping(path = "/metrics", produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
  public String get() {
    return scrapeDataProvider.next();
  }

}
