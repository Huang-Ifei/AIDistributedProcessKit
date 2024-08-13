package com.tabnote.ai.distributed.process.component;

import com.alibaba.fastjson2.JSONObject;
import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.text.DecimalFormat;

public class ComputerInfo {
    private String computerName;
    private String memory;
    private String arch;
    private String memoryUsage;
    public ComputerInfo() throws Exception {
        String computerName = InetAddress.getLocalHost().getHostName();
        //System.out.println("Computer Name: " + computerName);
        this.computerName = computerName;
        //System.out.println(System.getProperty("os.arch"));
        arch = System.getProperty("os.arch");

        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        // 总内存，单位：字节
        long total = osmxb.getTotalPhysicalMemorySize();
        // 空闲内存，单位：字节
        long free = osmxb.getFreePhysicalMemorySize();
        // 可用内存，单位：字节
        long usable = osmxb.getFreePhysicalMemorySize();
        // 已使用内存，单位：字节
        long used = total - free;
        // 内存使用率
        double useRate = used * 1.0 / total;
        //System.out.println("总共内存：" + new DecimalFormat("#.##").format(total * 1.0 / Math.pow(1024, 3)) + "G");
        //System.out.println("空闲内存：" + new DecimalFormat("#.##").format(free * 1.0 / Math.pow(1024, 3)) + "G");
        //System.out.println("已用内存：" + new DecimalFormat("#.##").format(used * 1.0 / Math.pow(1024, 3)) + "G");
        //System.out.println("可用内存：" + new DecimalFormat("#.##").format(usable * 1.0 / Math.pow(1024, 3)) + "G");
        //System.out.println("内存使用率：" + new DecimalFormat("#.##%").format(useRate));
        this.memory=new DecimalFormat("#.##").format(total * 1.0 / Math.pow(1024, 3)) + "G";
        this.memoryUsage = new DecimalFormat("#.##%").format(useRate)+"";
    }
    public String getInfoJSON(){
        JSONObject info = new JSONObject();
        info.put("computerName", computerName);
        info.put("memory", memory);
        info.put("arch", arch);
        info.put("memoryUsage", memoryUsage);
        System.out.println(info);
        return info.toString();
    }
}
