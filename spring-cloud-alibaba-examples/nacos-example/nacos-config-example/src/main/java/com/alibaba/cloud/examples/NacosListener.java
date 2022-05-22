package com.alibaba.cloud.examples;

import com.alibaba.nacos.api.config.listener.Listener;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import java.util.concurrent.Executor;

public class NacosListener implements Listener {

    /**
     * Callback with latest config data.
     * @param configInfo latest config data for specific dataId in Nacos
     * server
     */
    @Override
    public void receiveConfigInfo(String configInfo) {
        Properties properties = new Properties();
        try {
            properties.load(new StringReader(configInfo));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("config changed: " + properties);
    }

    @Override
    public Executor getExecutor() {
        return null;
    }

}
