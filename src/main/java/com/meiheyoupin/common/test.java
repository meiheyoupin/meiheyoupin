package com.meiheyoupin.common;

import com.aliyuncs.exceptions.ClientException;
import com.meiheyoupin.utils.VoiceCallUtils;


public class test {

    public static void main(String[] args) throws ClientException, InterruptedException {
        VoiceCallUtils.runCall("15988786205");
    }
}
