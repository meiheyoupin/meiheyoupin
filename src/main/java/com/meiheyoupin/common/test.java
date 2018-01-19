package com.meiheyoupin.common;

import com.aliyuncs.exceptions.ClientException;
import com.meiheyoupin.utils.VoiceCallUtils;

/**
 * Created by w2tto on 2018/1/19.
 */
public class test {

    public static void main(String[] args) throws ClientException {
        VoiceCallUtils.runCall("15988786205");
    }
}
