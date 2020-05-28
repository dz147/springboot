package com.dbcoding.mall.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.regex.Matcher;

/**
 * @ClassName: AAA
 * @Description: TODO
 * @Author: Stephen.Zhang
 * @CreateDate: 2020-05-15 10:18
 * @Version: 1.0
 **/
@Slf4j
public class RequestUtil {
    public static int getPageid(HttpServletRequest request, String name) {
        int pageid = NumberUtils.toInt(request.getParameter(name));
        if (pageid <= 0) {
            return 1;
        }
        return pageid;
    }

    public static String getUrl(HttpServletRequest request) {
        StringBuffer sb = request.getRequestURL();
        String queryString = request.getQueryString();
        if (StringUtils.isNotEmpty(queryString)) {
            sb.append('?').append(queryString);
        }
        return sb.toString();
    }

    public static String getReferer(HttpServletRequest request) {
        return request.getHeader("referer");
    }

    public static String getRequestUri(HttpServletRequest request) {
        return request.getRequestURI();
    }

    private static final java.util.regex.Pattern IS_LICIT_IP_PATTERN = java.util.regex.Pattern.compile("^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$");

    public static boolean isLicitIp(final String ip) {
        if (StringUtils.isEmpty(ip)) {
            return false;
        }

        Matcher m = IS_LICIT_IP_PATTERN.matcher(ip);
        if (!m.find()) {
            return false;
        }
        return true;
    }

    public static boolean isSsl(HttpServletRequest request) {
        boolean isSsl = "true".equalsIgnoreCase(request.getHeader("ssl"));
        return isSsl;
    }

    public static String getProtocol(HttpServletRequest request) {
        boolean isSsl = RequestUtil.isSsl(request);
        String protocol;
        if (isSsl) {
            protocol = "https";
        } else {
            protocol = "http";
        }
        return protocol;
    }

    public static String getRedirect(HttpServletRequest request, String url) {
        if (StringUtils.isEmpty(url)) {
            log.error("url parameters can not be null.");
            throw new NullPointerException("url parameters can not be null.");
        }
        if (url.startsWith("http")) {
            return url;
        }
        boolean isSsl = RequestUtil.isSsl(request);
        if (!isSsl) {
            return url;
        }
        if (!url.startsWith("/")) {
            String path = request.getServletPath();
            int index = path.lastIndexOf('/');
            if (index != -1) {
                url = path.substring(0, index + 1) + url;
            }
        }
        String serverName = request.getServerName();

        return "https://" + serverName + url;
    }

    @SuppressWarnings("unchecked")
    public static void printHeaders(HttpServletRequest request) {
        Enumeration<String> e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            String value = request.getHeader(name);
            log.info(name + ":" + value);
        }
    }

    /**
     * 获取真实客户端IP
     *
     * @param request
     * @return
     */
    public static String getRealIp(HttpServletRequest request) {

        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        int index = ip.lastIndexOf(',');
        if(index <= 0) {
            index = ip.length();
        }
        String lastip = ip.substring(0, index).trim();

        if ("127.0.0.1".equals(lastip) || !isLicitIp(lastip)) {
            return request.getRemoteAddr();
        }

        return lastip;
    }
}
