package com.meiheyoupin.common.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BaseController {
    public static final Logger logger = LoggerFactory.getLogger(BaseController.class);
    String[] emos_arr = new String[]{"e001", "e002", "e003", "e004", "e005", "e00d", "e00e", "e00f", "e010", "e011", "e012", "e022", "e023", "e036", "e037", "e038", "e03b", "e03e", "e04d", "e04e", "e056", "e057", "e058", "e059", "e05a", "e105", "e106", "e107", "e108", "e10c", "e111", "e115", "e11a", "e11c", "e11d", "e122", "e13c", "e146", "e14c", "e14d", "e152", "e153", "e155", "e156", "e157", "e158", "e201", "e22e", "e22f", "e230", "e231", "e253", "e31d", "e31e", "e31f", "e326", "e327", "e328", "e329", "e32a", "e32b", "e32c", "e32d", "e32e", "e330", "e331", "e334", "e335", "e336", "e337", "e401", "e402", "e403", "e404", "e405", "e406", "e407", "e408", "e409", "e40a", "e40b", "e40c", "e40d", "e40e", "e40f", "e410", "e411", "e412", "e413", "e414", "e415", "e416", "e417", "e418", "e419", "e41a", "e41b", "e41c", "e41d", "e41e", "e41f", "e420", "e421", "e422", "e423", "e424", "e425", "e426", "e427", "e428", "e429", "e43d", "e449", "e44a", "e44b", "e501", "e504", "e505", "e506", "e508", "e509", "e50a", "e515", "e516", "e517", "e518", "e519", "e51a", "e51b", "e51c", "e51d", "e51e", "e51f", "e536"};

    public BaseController() {
    }

    public JSONArray getData(ArrayList<Map<String, Object>> list) {
        JSONArray aryobj = new JSONArray();
        if(list != null && list.size() > 0) {
            Iterator var3 = list.iterator();

            while(var3.hasNext()) {
                Map map = (Map)var3.next();
                HashMap arymap = new HashMap();
                Set key = map.keySet();
                Iterator iterator = key.iterator();

                while(iterator.hasNext()) {
                    String keyName = (String)iterator.next();
                    Object valueName = map.get(keyName);
                    arymap.put(keyName, valueName.toString());
                }

                aryobj.add(arymap);
            }
        }

        return aryobj;
    }

    public void echoJSON(HttpServletResponse response, JSONObject obj) {
        try {
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(obj.toString());
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }

    public void echo(HttpServletResponse response, JSONObject obj) {
        try {
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(obj.toString());
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }

    public void echo(HttpServletResponse response, String obj) {
        try {
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(obj);
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }

    public String getPath() throws UnsupportedEncodingException {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        String fullPath = URLDecoder.decode(path, "UTF-8");
        String[] pathArr = fullPath.split("/WEB-INF/classes/");
        fullPath = pathArr[0];
        String reponsePath = "";
        reponsePath = (new File(fullPath)).getPath();
        return reponsePath;
    }

    public static String getExtention(String fileName) {
        int pos = fileName.lastIndexOf(".");
        return fileName.substring(pos + 1).toLowerCase();
    }

    public void setCookie(HttpServletResponse response, String key, String value, int time) {
        Cookie c = new Cookie(key, URLEncoder.encode(value));
        c.setMaxAge(time);
        c.setPath("/");
        response.addCookie(c);
    }

    public void delCookie(HttpServletResponse response, String key) {
        Cookie c = new Cookie(key, (String)null);
        c.setMaxAge(0);
        c.setPath("/");
        response.addCookie(c);
    }

    public String getCookie(HttpServletRequest request, String key) {
        String res = "";
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for(int i = 0; i < cookies.length; ++i) {
                Cookie c = cookies[i];
                if(c.getName().equals(key)) {
                    res = URLDecoder.decode(c.getValue());
                    return res;
                }
            }
        }

        return res;
    }


    public Map<String, Object> getConditionParam(HttpServletRequest request,int size) {
        HashMap param = new HashMap();
        Enumeration e = request.getParameterNames();

        while(e.hasMoreElements()) {
            String keyName = e.nextElement().toString();
            String keyValue = request.getParameter(keyName);
            if(keyValue != null && !keyValue.equals("") && !keyName.equals("file")) {
                param.put(keyName, keyValue);
            }
        }

        param.put("size", size);
        if(param.get("page") != null && !param.get("page").equals("")) {
            param.put("start", Integer.valueOf((Integer.parseInt(param.get("page").toString()) - 1) * size));
        } else {
            param.put("start", "0");
            param.put("page", "1");
        }

        return param;
    }

    public String getRegionIDs(HttpServletRequest request) {
        return "";
    }

}