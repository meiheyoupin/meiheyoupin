package com.meiheyoupin.common.utils;

import javax.servlet.http.HttpServletRequest;

public class CommonUtil {
    public CommonUtil() {
    }

    public static int getIntFromString(String str) {
        int ret = 0;
        if(str != null) {
            try {
                ret = Integer.parseInt(str);
            } catch (NumberFormatException var3) {
                ret = 0;
            }
        }
        return ret;
    }

    /**
     * 得到请求参数
     * @param request request
     * @param name 请求参数key
     * @param def 默认值
     * @return 请求参数value
     */
    public static String GetRequestParam(HttpServletRequest request, String name, String def) {
        if(request == null) {
            return def;
        } else {
            String value = request.getParameter(name);
            return value != null && !value.equals("")?value:def;
        }
    }

    public static String getExtention(String fileName) {
        int pos = fileName.lastIndexOf(".");
        return fileName.substring(pos + 1).toLowerCase();
    }

}