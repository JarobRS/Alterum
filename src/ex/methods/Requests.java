package ex.methods;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Requests {

    public static List<String> getData(List<String> domainList, int count) {

        String api_url = "https://api.vk.com/method/";
        List<String> response_text = new ArrayList<>();

        ConnectionKeepAliveStrategy myStrategy = (response, context) -> {
            HeaderElementIterator it = new BasicHeaderElementIterator
                    (response.headerIterator(HTTP.CONN_KEEP_ALIVE));
            while (it.hasNext()) {
                HeaderElement he = it.nextElement();
                String param = he.getName();
                String value = he.getValue();
                if (value != null && param.equalsIgnoreCase
                        ("timeout")) {
                    return Long.parseLong(value) * 1000;
                }
            }
            return 40 * 1000;
        };

        HttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES).build())
                .setKeepAliveStrategy(myStrategy)
                .build();

        HttpPost httpPost = new HttpPost();
        for (int i = 0; i < domainList.size(); i++) {
            httpPost = new HttpPost(api_url + "wall.get?" +
                    "domain=" + domainList.get(i) +
                    "&count=" + count);
            System.out.println(i);
            try {
                HttpResponse response = httpClient.execute(httpPost);
                response_text.add(org.apache.http.util.EntityUtils.toString(response.getEntity()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        httpPost.abort();
        return response_text;
    }

    public static String getDomain(String domain) {
        domain = domain.toLowerCase();
        domain = domain.trim();
        if (domain.matches("^((https|http)(:)(/)(/)(www.vk.com|vk.com)(/)(?:[a-z0-9_]*))|((www.vk.com|vk.com)(/)(?:[a-z0-9_]]*))$")) {
            domain = domain.replaceFirst("^((https|http)(:)(/)(/)(www.vk.com|vk.com)(/))|((www.vk.com|vk.com)(/))$","");
            domain = domain.replaceFirst("^((www.vk.com|vk.com)(/))|((https|http)(:)(/)(/)(www.vk.com|vk.com)(/))$","");
            return domain;
        } else
            return null;
    }
}
