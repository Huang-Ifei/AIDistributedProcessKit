package com.tabnote.ai.distributed.process;

import com.sun.management.OperatingSystemMXBean;
import com.tabnote.ai.distributed.process.component.ComputerInfo;
import com.tabnote.ai.distributed.process.component.ConnectToAPI;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("TabNote分布式AI计算 算力贡献工具\n");
        System.out.println("本程序将会获取您电脑的部分信息，并占用您的电脑资源，有可能影响到您正常的电脑使用；\n您将贡献您电脑的算力，用于TabNote的分布式AI计算功能，在计算期间，您有权利查看任意一条信息的请求与响应，并有权力随时终止本程序进程来终止算力贡献，在符合“TabNote分布式AI计算算力贡献守则”的前提下，您不需要对在您电脑上计算的请求及响应内容负责，TabNote平台也不对分配给您的内容负责，请求由另一名用户提出，由ollama及其对应AI大模型生成答案。如果您发现违规请求内容，您应当与TabNote平台管理员取得联系，我们将会对对应IP及账户其进行相应的处罚，如果有违反相关法律的行为，其也可能受到法律的追责！");
        System.out.println("请您遵守“TabNote分布式AI计算算力贡献守则”：每一位算力贡献者应该遵循ollama及其开源大模型的相关规定，必须遵循其计算结果，禁止对计算结果进行篡改，不应该使用其他工具占用本机的11434端口，禁止使用除“TabNote官方分布式AI计算算力贡献工具箱”以外的方式私自发送处理计算请求，如果您的计算结果受到用户举报，并经过我们的核实确有违规情况，那么您的IP以及账号将会面临封禁，如果违反中华人民共和国及您所在地的相关法律法规，您的行为还可能被追加法律责任\n");
        System.out.println("请认真阅读以上信息，7秒后开始测试连接，一旦测试连接开始，将默认您认可以上内容，并遵守上述规定");
        Thread.sleep(7000);
        ConnectToAPI connectToAPI = new ConnectToAPI();
        if (!connectToAPI.connectTest("hello"))
            return;
        System.out.println("连接API成功");
        System.out.println("3秒后开始向服务器发送请求，这将需要您连接到互联网");
        Thread.sleep(3000);
        while (true) {
            OutputStream os = null;
            BufferedReader br = null;
            Socket socket = null;
            try {
                System.out.println("请求服务器连接中...");
                socket = new Socket("101.42.31.139", 11714);
                //socket = new Socket("127.0.0.1", 11714);
                os = socket.getOutputStream();
                br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                System.out.println("服务器连接成功");
                ComputerInfo com = new ComputerInfo();
                os.write((com.getInfoJSON() + "\n").getBytes());
                os.flush();
                String s;
                while (null != (s = br.readLine())) {
                    if (s.equals("队列为空")) {
                        System.out.println("等待计算请求...");
                    } else if (s.equals("请求处理")) {
                        System.out.println("正在处理中...");
                        s = "";
                        String temp = "";
                        while (null != (temp = br.readLine())) {
                            s+=temp;
                        }
                        connectToAPI.connect(s, os);
                        System.out.println("发送结束，衷心的感谢您对TabNote平台做出的贡献，我们将尽快上线“TabNote分布式AI计算算力贡献激励计划”，届时，您将获得对应激励");
                    } else {
                        System.out.println("错误内容："+s+",等待5秒后发送下一次请求");
                        Thread.sleep(5000);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (os != null) {
                    os.close();
                }
                if (br != null) {
                    br.close();
                }
                if (socket != null) {
                    socket.close();
                }
                Thread.sleep(1000);
            }
        }
    }
}