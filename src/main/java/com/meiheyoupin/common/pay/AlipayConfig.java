package com.meiheyoupin.common.pay;

public class AlipayConfig {

    //应用ID
    public static String app_id = "2017102709554092";

    //服务器异步通知页面路径
    public static String notify_url = "http://www.meiheyoupin.com/aliPay/notify";

    //页面跳转同步通知页面路径
    public static String return_url = "http://www.meiheyoupin.com/pay/success";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.aliPay.com/gateway.do";

    //商户私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCe4+s+V4in0Lo6U2N+ra" +
            "Cd4aKn+MrmjNUs7fTIMBPnBDtxeGH/0yeYS3HLgunSe7x3rFNeN3+7N9Dh4TrKeJOqke3mk+gOoW0yl5HS+OJFyhK8lNz6fdHUsmUrZAl3" +
            "C7t0MBTtxP/cQhUcN5b8kzo6qfLno6PsvrVFesyEZwCabAB37CHoa/PwXv9Ie4GfpUWrm6HZOPHXLArhot5CnnKDe2qXwpMrTid3sm7Qef" +
            "MWKOad7O+TMi5nrSgOQ0dgMgWhQzHRdLvL5H05hva6A4qJjE7RDYs4RpmCDa5vkpCo0MOzfmqC1Bhq3QwWB3P1AG+vUJ6WOD93bS/LaB/5" +
            "5+pvAgMBAAECggEAOzMsWQQANJZ+bHDZZz+F0o1ZL0BxSMk8PAtE4rmXEMHw6+wwh0LDQ+kIMw1J1VSo+eXJAhenjbfUKfTjFMEsM6c/fm" +
            "OpWJoot2rluDdnBx2tMXo9g08RuS/mpe4V4LcMVtP7WEPIGOa+Os8zgFPSpDzh9hBwaSr9GzAPt10xSldQ4Y5XPVQZDV5FDJmhVh6tk79T" +
            "OojYN4paAmrArLupmH7XFsnh3FYOM3LeEONHNsE1SCSX69eNsbsMeKShSj+FyzlGkw+IZ+bnYci3S6uL8Jos3JYJOqbhc0ggkBoRp7dzxa" +
            "LZuteZjY3+s4GnHzQdIPovngRSIr8YPOWbGvK90QKBgQDLk4d06kfd3Ng1wOvE6R3QMH+pn/9mUglapSyIkoJc5c0uOeAdQUvWtnoGcvb9" +
            "pDCi8AG5JFoUbdA9fzKQKFgzunm76NThC7wae1wrutFAAgwaB0jTN2amEPODSi/JHaiy04AiBTC33cKAS3/VYLDFe1rupXKE0YPJaDmyn1" +
            "ex1QKBgQDHzogag0ZNX/ZlcIKnWV4Xigdz2mf16IobpdxwJ7VbqzixWhRGKtfpiKh3bEeuR2vHB9TcI73lapnQ6wUe+vNr7PYalsOBhCIa" +
            "T8oz0AJiDdJNVXg/+X4s6ezQ6vDncDjIayxbWCd453BtynvvAQ9aIprzr7rYU+nUeGG8dfMJMwKBgQC7bHLsh/lsYLPKIXivTHQ/RTdzwr" +
            "NPz71+780lW8Wbo5KYuX4FUSVyY4PKxjNxZ6XDjTX472fjoQp0Y9P4drxlu4vyHbVIEBa5RtOgCxo1VO0xVX2NwFbIE5kuSbHe9mhnY2N3" +
            "btHgpdE5bskdeSymVCBu0HGzqHUti8B7HEqPlQKBgQCVVNnKHvTrHV6VIAq2MoetRh8dyk1Kr9qQoVzogfT8pzJ+8pkWfCzUwKtQXiAQtB" +
            "ZsMYE4aoohrZN6Xjx8lAhcUET7SFSkNvIaAipYoQ025aeY3tk5zykrPkYdOoqEHw6BVABZ4L/Xj/oqRFxuG7eyoQx4No2J4uVvQ+2gIfNb" +
            "mwKBgQC0iw5fcQgplSystzlp7n6S6EBGqMiYr/hzPYkK9hd9xbl6Y4HSxpoEkR0F/lulc1BuVYxJklcIbfOGcvjinI+zPeGr/OtTbKKBQv" +
            "6WNyHDoE3ehg/rajyDvuKSlbf3x0cOw/0fTV+Oe8v9vOhtm86g0E3ndUxU6gnBbKfudSa1Jw==";

    //支付宝公钥
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwvyB9yXjjOPhsBvpGJumhrkRb/jw" +
            "Quefungor6Y96eGlhDLz/9WjLHqZ18CnOKh10pmy9hkDu5sPEr2LoMhVkRZd/29UvALXHtJQdyL1/VjhzNTFwhk7tkIQ8dn/S7+6K3bkP" +
            "XLxuxap6vTw7sydxW0xMJUUp8rJSgP8GsJblqfdF9xsn9iGA8Rj+rKHT4gVr6au4UDTkM15NDeS7tSimWn53yJwrPH0+Y6gyUw00UKLqm" +
            "AQzcjNcWNcuUSUI7PmHc1OuoKQFj9WSDqigoHyOGNsGWILxddaJm8CReO8+KoDvCauC57kzR7S+/1iMbrgow3szktwZBl/KKN/sDz+wwIDAQAB";

}
