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
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Requests {

    public static List<String> getPostContent(List<String> domainList, int count) {

        String api_url = "https://api.vk.com/method/";
        String api_version = "5.65";

        List<String> responseList = new ArrayList<>();

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
        for (String aDomainList : domainList) {
            httpPost = new HttpPost(api_url + "wall.get?" +
                    "domain=" + aDomainList +
                    "&count=" + count +
                    "&v=" + api_version);
            try {
                HttpResponse response = httpClient.execute(httpPost);
                responseList.add(EntityUtils.toString(response.getEntity()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        httpPost.abort();
        return responseList;
    }

    public static List<String> getPostContentHtml(List<String> domainList) {

        List<String> responseList = new ArrayList<>();
        String api_url = "https://vk.com/";

        ConnectionKeepAliveStrategy myStrategy = (resp, context) -> {
            HeaderElementIterator it = new BasicHeaderElementIterator
                    (resp.headerIterator(HTTP.CONN_KEEP_ALIVE));
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
        for (String aDomainList : domainList) {
            httpPost = new HttpPost(api_url + aDomainList);
            try {
                HttpResponse response = httpClient.execute(httpPost);
                responseList.add(EntityUtils.toString(response.getEntity()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        httpPost.abort();
        return responseList;
    }

    static String getUserInfo(String domainID) {

        String api_url = "https://api.vk.com/method/";
        String api_version = "5.65";

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

        HttpPost httpPost = new HttpPost(api_url + "users.get?" +
                "user_ids=" + domainID +
                "&fields=photo_id%2Cverified%2Csex%2Cbdate%2Ccity%2Ccountry%2Chome_town%2Chas_photo%2Cphoto_50%2Cphoto_100%2Cphoto_200_orig%2Cphoto_200%2Cphoto_400_orig%2Cphoto_max%2Cphoto_max_orig%2Conline%2Cdomain%2Chas_mobile%2Ccontacts%2Csite%2Ceducation%2Cuniversities%2Cschools%2Cstatus%2Clast_seen%2Cfollowers_count%2Coccupation%2Cnickname%2Crelatives%2Crelation%2Cpersonal%2Cconnections%2Cexports%2Cwall_comments%2Cactivities%2Cinterests%2Cmusic%2Cmovies%2Ctv%2Cbooks%2Cgames%2Cabout%2Cquotes%2Ccan_post%2Ccan_see_all_posts%2Ccan_see_audio%2Ccan_write_private_message%2Ccan_send_friend_request%2Cis_favorite%2Cis_hidden_from_feed%2Ctimezone%2Cscreen_name%2Cmaiden_name%2Ccrop_photo%2Cis_friend%2Cfriend_status%2Ccareer%2Cmilitary%2Cblacklisted%2Cblacklisted_by_me&name_case=Nom" +
                "&v=" + api_version);
        String responseString = null;
        try {
            HttpResponse response = httpClient.execute(httpPost);
            responseString = String.valueOf(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        httpPost.abort();
        return responseString;
    }

    static String getUserShortInfo(String domainID) {

        String api_url = "https://api.vk.com/method/";
        String api_version = "5.65";

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

        HttpPost httpPost = new HttpPost(api_url + "users.get?" +
                "user_ids=" + domainID +
                "&fields=photo_50" +
                "&v=" + api_version);
        String responseString = null;
        try {
            HttpResponse response = httpClient.execute(httpPost);
            responseString = String.valueOf(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        httpPost.abort();
        return responseString;
    }

    static String getCommutityInfo(String domainID) {

        String api_url = "https://api.vk.com/method/";
        String api_version = "5.65";

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

        HttpPost httpPost = new HttpPost(api_url + "groups.getById?" +
                "group_id=" + domainID +
                "&fields=city%2Ccountry%2Cplace%2Cdescription%2Cwiki_page%2Cmembers_count%2Ccounters%2Cstart_date%2Cfinish_date%2Ccan_post%2Ccan_see_all_posts%2Cactivity%2Cstatus%2Ccontacts%2Clinks%2Cfixed_post%2Cverified%2Csite%2Cban_info%2Ccover" +
                "&v=" + api_version);
        String responseString = null;
        try {
            HttpResponse response = httpClient.execute(httpPost);
            responseString = String.valueOf(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        httpPost.abort();
        return responseString;
    }

    static String getCommutityShortInfo(String domainID) {

        String api_url = "https://api.vk.com/method/";
        String api_version = "5.65";

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

        HttpPost httpPost = new HttpPost(api_url + "groups.getById?" +
                "group_id=" + domainID +
                "&v=" + api_version);
        String responseString = null;
        try {
            HttpResponse response = httpClient.execute(httpPost);
            responseString = String.valueOf(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        httpPost.abort();
        return responseString;
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
