package com.tabnote.ai.distributed.process;

import com.alibaba.fastjson2.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class SendTest {
//    public static void main(String[] args) throws Exception {
//        Socket socket = new Socket("127.0.0.1", 11713);
//        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
//        String s = "(2023.7~今) Java、Kotlin、Vue3(TS)全栈全平台开发：Google Gemini AI赋能的Tab Note智慧学习交流平台：\n" +
//                "特点：① 分布式计算（微服务），在富文本AI笔记中体验算力贡献AI计算时，将请求发给分配计算的微服务，微服务分别维护请求、处理两个线程池，他们的线程将共同操作一个线程安全的队列，将服务器的计算请求分配给贡献算力的个人电脑。\n" +
//                "② 动态订阅RSA公钥加密敏感传输信息，即使是HTTP明码传输亦可保护敏感信息安全。\n" +
//                "③ 使用Redis缓存查询较慢的数据（如：计数），多次查询速度提升一倍以上，并在大量请求时保护数据库安全；\n" +
//                "④ 使用RabbitMQ作为点赞微服务的中间件，点赞是高写入量的操作，我将其拆分为单独的微服务，使用RabbitMQ作为中间件，排队执行，限制并发量以保护数据库的安全。\n" +
//                "项目上线地址：http://101.42.31.139/      服务器源代码：https://github.com/Huang-Ifei/TabNoteServerBoot\n" +
//                "客户端源代码：https://github.com/Huang-Ifei/tab_note_web_view（网页）  https://github.com/Huang-Ifei/TabNote （安卓）\n" +
//                "服务器端：语言: Java; 数据库: MySQL, Redis; 使用框架: SpringBoot, MyBatis；部署: 腾讯云Ubuntu Server; \n" +
//                "客户端：网页: Vue3+TypeScript\n" +
//                "安卓: 语言: Java+Kotlin; UI: Jetpack Compose+网页; 键值对: DataStore, 数据库: ROOM  \n" +
//                "功能：① 对话式AI助手（接入Gemini）② 富文本AI笔记，划词即搜，轻触即记。③ 注册、登录，修改个人账户。\n" +
//                "④ 编辑，发布，查看，搜索，点赞贴文。⑥ 添加、删除，点赞留言。⑦ 增、删、改、完成待办，云端同步待办计划(App)\n" +
//                "简单描述一下这个项目（！！！注意！！！如果不是英语问题，请使用中文回答）";
//        bos.write(s.getBytes());
//        bos.flush();
//        socket.shutdownOutput();
//        System.out.println("发送成功");
//        System.out.println(br.readLine());
//        String temp;
//        while (null != (temp = br.readLine())) {
//            //System.out.println(temp);
//            JSONObject json = JSONObject.parseObject(temp);
//            System.out.print(json.getString("response"));
//        }
//        bos.close();
//        br.close();
//        socket.close();
//    }
}