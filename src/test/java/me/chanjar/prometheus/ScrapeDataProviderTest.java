package me.chanjar.prometheus;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class ScrapeDataProviderTest {

  @Test
  public void testNext() {
    ScrapeDataProvider scrapeDataProvider = new ScrapeDataProvider(Arrays.asList("a", "b", "c", "d"));
    assertEquals(scrapeDataProvider.next(), "a");
    assertEquals(scrapeDataProvider.next(), "b");
    assertEquals(scrapeDataProvider.next(), "c");
    assertEquals(scrapeDataProvider.next(), "d");
    assertEquals(scrapeDataProvider.next(), "a");
    assertEquals(scrapeDataProvider.next(), "b");
    assertEquals(scrapeDataProvider.next(), "c");
    assertEquals(scrapeDataProvider.next(), "d");
  }

}
