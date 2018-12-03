package me.chanjar.prometheus;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ScrapeDataReaderTest {

  @Test
  public void testRead() throws IOException {
    String filePath = "src/test/resources/mock-scrape-data.txt";
    ScrapeDataReader reader = new ScrapeDataReader(filePath);
    List<String> scrapeDatas = reader.read();

    assertEquals(scrapeDatas.size(), 5);

    assertEquals(scrapeDatas.get(0), "# HELP jvm_buffer_pool_used_bytes Used bytes of a given JVM buffer pool.\n"
        + "# TYPE jvm_buffer_pool_used_bytes gauge\n"
        + "jvm_buffer_pool_used_bytes{pool=\"direct\",} 40960.0\n"
        + "jvm_buffer_pool_used_bytes{pool=\"mapped\",} 0.0\n"
        + "# HELP jvm_buffer_pool_capacity_bytes Bytes capacity of a given JVM buffer pool.\n"
        + "# TYPE jvm_buffer_pool_capacity_bytes gauge\n"
        + "jvm_buffer_pool_capacity_bytes{pool=\"direct\",} 40960.0\n"
        + "jvm_buffer_pool_capacity_bytes{pool=\"mapped\",} 0.0");

    assertEquals(scrapeDatas.get(1), "# HELP jvm_buffer_pool_used_buffers Used buffers of a given JVM buffer pool.\n"
        + "# TYPE jvm_buffer_pool_used_buffers gauge\n"
        + "jvm_buffer_pool_used_buffers{pool=\"direct\",} 5.0\n"
        + "jvm_buffer_pool_used_buffers{pool=\"mapped\",} 0.0\n"
        + "# HELP jvm_info JVM version info\n"
        + "# TYPE jvm_info gauge\n"
        + "jvm_info{version=\"1.8.0_181-b13\",vendor=\"Oracle Corporation\",runtime=\"OpenJDK Runtime Environment\",} 1.0");

    assertEquals(scrapeDatas.get(2), "# HELP jmx_config_reload_success_total Number of times configuration have successfully been reloaded.\n"
        + "# TYPE jmx_config_reload_success_total counter\n"
        + "jmx_config_reload_success_total 0.0");

    assertEquals(scrapeDatas.get(3), "");
    assertEquals(scrapeDatas.get(4), "");
  }
}


