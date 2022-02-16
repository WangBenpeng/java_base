package com.pengo.internet;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Map;

/**
 * @author pengo
 * @description:
 * @date 2022/2/16 14:45
 */
public class HttpDemo {
    public static void main(String[] args) throws Exception{
        test2();
    }

    static HttpClient httpClient = HttpClient.newBuilder().build();
    static void test2() throws URISyntaxException, IOException, InterruptedException {
        String url = "https://store.ybsjds.com/";
        HttpRequest request = HttpRequest.newBuilder(new URI(url))
                .header("User-Agent", "Java HttpClient")
                .header("Accept", "*/*")
                .timeout(Duration.ofSeconds(5))
                .version(HttpClient.Version.HTTP_2)
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        Map<String, List<String>> headers = response.headers().map();
        for (String header : headers.keySet()) {
            System.out.println(header + " : " + headers.get(header).get(0));
        }
        System.out.println(response.body().substring(0, 1024) + "...");
    }

    static void test1() throws IOException {
        URL url = new URL("https://www.baidu.com");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setUseCaches(false);
        connection.setConnectTimeout(5000);
        connection.setRequestProperty("Accept", "*/*");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 11; Windows NT 5.1)");
        connection.connect();
        if (connection.getResponseCode() != 200) {
            throw new RuntimeException("bad request");
        }
        Map<String, List<String>> map = connection.getHeaderFields();
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
        InputStream inputStream = connection.getInputStream();
        byte[] bytes = new byte[1024];
        int n;
        while ((n = inputStream.read(bytes)) != 0) {
            String s = new String(bytes, StandardCharsets.UTF_8);
            System.out.println(s);
        }
    }
}
