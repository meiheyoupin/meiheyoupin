package com.meiheyoupin.common.pay;

import java.io.*;

public class WXPayConfig implements com.github.wxpay.sdk.WXPayConfig {

    private byte[] certData;

    public WXPayConfig() throws IOException {
        String certPath = this.getClass().getResource("/").getPath() + "apiclient_cert.p12";
        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }

    @Override
    public String getAppID() {
        return "wx4a300c4010f4be69";
    }

    @Override
    public String getMchID() {
        return "1414743002";
    }

    @Override
    public String getKey() {
        return "66fb35add2f7242f24102a9380115abb";
    }

    @Override
    public InputStream getCertStream() {
        return new ByteArrayInputStream(this.certData);
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 10000;
    }
}
