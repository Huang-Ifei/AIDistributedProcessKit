package com.tabnote.ai.distributed.process.component;

import com.alibaba.fastjson2.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectToAPI {

    public boolean connectTest(String s) {
        try{

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("model","gemma2:2b");
            jsonObject.put("prompt",s);

            URL url = new URL("http://localhost:11434/api/generate");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(180000);
            OutputStream os = connection.getOutputStream();
            os.write(jsonObject.toString().getBytes());
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String temp;
            while (null != (temp = br.readLine())) {
                if (temp.isEmpty()){
                    return false;
                }
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void connect(String s,OutputStream bos) {
        try{

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("model","gemma2:2b");
            jsonObject.put("prompt",s);

            URL url = new URL("http://localhost:11434/api/generate");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(180000);
            OutputStream os = connection.getOutputStream();
            System.out.println(jsonObject.toJSONString());
            os.write(jsonObject.toString().getBytes());
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String temp;
            while (null != (temp = br.readLine())) {
                System.out.println(temp);
                bos.write((temp+"\n").getBytes());
                bos.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
