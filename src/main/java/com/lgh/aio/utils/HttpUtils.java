package com.lgh.aio.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * @author lu shun zhi
 * @version 2.0.0
 * @date 2019/2/28 17:16
 */
public class HttpUtils {
    /**
     * 方法3，接收url的请求，返回类型是JSON数据，大致同上
     */
    public static JSONObject getRequestFromUrl(String url) throws IOException, JSONException {
        //新建参数为url的URL对象realUrl
        URL realUrl = new URL(url);
        URLConnection conn = realUrl.openConnection();
        InputStream instream = conn.getInputStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(instream, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            instream.close();
        }
    }

    /**
     * 方法1，readAll，读所有数据
     */
    private static String readAll(Reader rd) throws IOException {
        //新建StringBuilder对象sb
        StringBuilder sb = new StringBuilder();
        int cp; //用来判断读取状态
        //每个字节读取rd对象，若读到最后就会返回-1，来判断是否文件读完
        while ((cp = rd.read()) != -1) {
            //若读完了，把数据都添加进StringBuilder对象sb里面
            sb.append((char) cp);
        }
        //返回String格式的sb对象
        return sb.toString();
    }
}
