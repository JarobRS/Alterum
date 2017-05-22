package ex.methods;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class Requests {
    public static String getData(String domain, int count) {
        String api_url = "https://api.vk.com/method/";
        HttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setCookieSpec(CookieSpecs.STANDARD).build())
                .build();
        HttpPost httpPost = new HttpPost(api_url + "wall.get?" +
                "domain=" + domain +
                "&count=" + count);
        String response_text = null;
        try {
            HttpResponse response = httpClient.execute(httpPost);
            response_text = org.apache.http.util.EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
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
