# prometheus-mock-data

Prometheus functions are hard to learn, it will be better if you can provide artificial data to test with. 
This tool comes to the rescue. 

## Build

```bash
mvn clean package
```

## Usage

Create a file containing scrape data you want to provide:

```txt
<1st time scrape data>
---
<2nd time scrape data>
---
<3rd time scrape data>
---
<4th time scrape data>
...
```

Example:

```txt
# HELP jvm_buffer_pool_used_bytes Used bytes of a given JVM buffer pool.
# TYPE jvm_buffer_pool_used_bytes gauge
jvm_buffer_pool_used_bytes{pool="direct",} 40960.0
jvm_buffer_pool_used_bytes{pool="mapped",} 0.0
---
# HELP jvm_buffer_pool_used_bytes Used bytes of a given JVM buffer pool.
# TYPE jvm_buffer_pool_used_bytes gauge
jvm_buffer_pool_used_bytes{pool="direct",} 41960.0
jvm_buffer_pool_used_bytes{pool="mapped",} 0.0
```

Run jar:

```bash
java -jar prometheus-mock-data.jar <path-to-scrape-data-file>
``` 

Open browser, navigate to [http://localhost:8080/metrics][metrics-endpoint], refresh browser and you'll see program 
provide metrics from scrape data file cyclicly.

Configure prometheus to scrape, [see doc][p8s-scrape-config]

## Using Docker

Example:

```bash
docker run \
  -v $(pwd)/scrape-data.txt:/home/java-app/etc/scrape-data.txt \
  -p 8080:8080 \
  chanjarster/prometheus-mock-data:latest
```

[p8s-scrape-config]: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#%3Cscrape_config%3E
[metrics-endpoint]: http://localhost:8080/metrics
