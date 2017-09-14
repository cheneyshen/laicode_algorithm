package laicode;

import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

public class login {
	private String csrfName="";
	private String csrfValue="";
	private BasicCookieStore cookieStore;
    private static CloseableHttpClient httpclient;

	public void init() {
		cookieStore = new BasicCookieStore();
		httpclient = HttpClients.custom()
	            .setDefaultCookieStore(cookieStore)
	            .build();
	}
	
	public void firstGet() throws Exception {
		try {
	        HttpGet httpget = new HttpGet("https://code.laioffer.com/accounts/login/?next=/plan");
	        CloseableHttpResponse response1 = httpclient.execute(httpget);
	        try {
	            HttpEntity entity = response1.getEntity();
	            //System.out.println("Login form get: " + response1.getStatusLine());
	            //String html = IOUtils.toString(entity.getContent(), "utf-8");
	            //System.out.println(html);
	            EntityUtils.consume(entity);
	            //System.out.println("Initial set of cookies:");
	            List<Cookie> cookies = cookieStore.getCookies();
	            if (cookies.isEmpty()) {
	                System.out.println("None");
	            } else {
	                for (int i = 0; i < cookies.size(); i++) {
	                	//System.out.println("- " + cookies.get(i).toString());
	                	csrfName=cookies.get(i).getName();
	                	csrfValue=cookies.get(i).getValue();
	                }
	            }
	        } finally {
	        	response1.close();
	        }
		}
		finally {
			
		}
	}
	
	public void firstPost() throws Exception {
        HttpUriRequest login = RequestBuilder.post()
                .setUri(new URI("https://code.laioffer.com/accounts/login/?next=/plan"))
                .addParameter("username", "feishen201702")
                .addParameter("password", "laioffer")
                .addParameter("csrfmiddlewaretoken", csrfValue)
                .addHeader("Host", "code.laioffer.com")
                .addHeader("Connection", "keep-alive")
                .addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:54.0) Gecko/20100101 Firefox/54.0")
                .addHeader("Referer", "https://code.laioffer.com/accounts/login/?next=/plan")
                .addHeader("Accept", "text/html,application")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Charset", "utf-8, utf-8;q=0.5, *;q=0.5")
                .addHeader("Accept-Language", "zh-CN,en-US;q=0.7,en;q=0.3")
                .addHeader("Cookie", csrfName+"="+csrfValue)
                .addHeader("Upgrade-Insecure-Requests", "1")
                .build();

        CloseableHttpResponse response2 = httpclient.execute(login);
        try {
            HttpEntity entity2 = response2.getEntity();
//          System.out.println("Login form post: " + response2.getStatusLine());
//			String html = IOUtils.toString(entity2.getContent(), "utf-8");
//			System.out.println(html);
            EntityUtils.consume(entity2);
//            System.out.println("Post logon cookies:");
            List<Cookie> cookies2 = cookieStore.getCookies();
            if (cookies2.isEmpty()) {
                System.out.println("None");
            } else {
                for (int i2 = 0; i2 < cookies2.size(); i2++) {
//                    System.out.println("- " + cookies2.get(i2).toString());
                }
            }
        } finally {
            response2.close();
        }   
	}
	
	public int secondGet(String link) throws Exception {
            HttpGet httpget = new HttpGet(link);
            CloseableHttpResponse response3 = httpclient.execute(httpget);
            try {
                HttpEntity entity3 = response3.getEntity();
//                System.out.println("Visit " + link + " get: " + response3.getStatusLine());
                return response3.getStatusLine().getStatusCode();
//    			String html = IOUtils.toString(entity3.getContent(), "utf-8");
//    			System.out.println(html);
//                EntityUtils.consume(entity3);
//                //System.out.println("Initial set of cookies:");
//                List<Cookie> cookies = cookieStore.getCookies();
//                if (cookies.isEmpty()) {
//                    System.out.println("None");
//                } else {
//                    for (int i = 0; i < cookies.size(); i++) {
////                        System.out.println("- " + cookies.get(i).toString());
//                    	csrfName=cookies.get(i).getName();
//                    	csrfValue=cookies.get(i).getValue();
//                    }
//                }
            } finally {
                response3.close();
            }
	}
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		login hi = new login();
		String location= "/Users/fshen/Documents/workspace/laicode/src/laicode/";
		try {
			hi.init();
			hi.firstGet();
			hi.firstPost();
			String link="http://code.laioffer.com/editor/";
			for(int i=1;i<600;i++) {
				int code = hi.secondGet(link+i);
				if(code==200) {
					String target=location + "Solution" + String.format("%03d", i) + ".java";
					System.out.println(target);
					List<String> lines = Arrays.asList("package laicode;", "", "import java.util.*;", "", "public class Solution"+String.format("%03d", i)+ " {", "", "\tpublic static void main(String[] args) {", "", "", "\t}", "}");
					Path file = Paths.get(target);
					Files.write(file, lines, Charset.forName("UTF-8"));
				}
			}
		}  finally {
            httpclient.close();
        }
	}
}
