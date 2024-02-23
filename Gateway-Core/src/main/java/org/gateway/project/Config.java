package org.gateway.project;

import com.lmax.disruptor.*;
import lombok.Data;

/**
 * 基本配置类
 */
@Data
public class Config {
    //服务器端口
    private int port = 8088;
    //监控端口
    private int Prometheus = 18000;
    //应用名称
    private String applicationName = "api-gateway";
    //注册中心地址
    private String registryAddress = "127.0.0.1:8848";
    //环境信息
    private String env = "dev";
    /**
     * netty
     */
    //boss线程数量
    private int eventLoopGroupBossNum = 1;
//    worker线程数量
    private int eventLoopGroupWorkerNum = 1;
//    最大内容长度，默认为64MB
    private int maxContentLength = 64 * 1024 * 1024;
//    是否开启异步模式，默认为开启
    private Boolean whenComplete = true;
//    Http默认连接超时时间
    private int httpConnectTimeout = 30 * 1000;
//    Http请求超时时间
    private int httpRequestTimeout = 30 * 1000;
//    客户端默认请求重试次数
    private int httpMaxRequestRetry = 2;
//    客户端请求最大连接数
    private int httpMaxConnections = 10000;
//    客户端每个地址支持的最大连接数
    private int httpConnectionPerHost = 8000;
//    客户端空闲连接超时时间
    private int httpPooledConnectionIdleTimeout = 60 * 1000;
//    默认缓冲区类型，默认为"default"
    private String defaultBufferType = "default";
//    并行缓冲区类型，默认为"parallel"
    private String parallelBufferType = "parallel";
    // 缓冲区大小，默认为16KB
    private int bufferSize = 1024 * 16;
    // 处理线程数，默认为当前系统可用处理器数量
    private int processThread = Runtime.getRuntime().availableProcessors();
//    等待策略，默认为阻塞等待
    private String waitStrategy ="blocking";
    /**
     * 获取等待策略对象
     * netty的等待策略有四种，分别是：阻塞、自旋、让步、睡眠
     */
    public WaitStrategy getWaitStrategy(){
        switch (waitStrategy){
            case "blocking":
                return new BlockingWaitStrategy();
            case "busySpin":
                return new BusySpinWaitStrategy();
            case "yielding":
                return new YieldingWaitStrategy();
            case "sleeping":
                return new SleepingWaitStrategy();
            default:
                return new BlockingWaitStrategy();
        }
    }
}
