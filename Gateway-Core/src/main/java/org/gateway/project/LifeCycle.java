package org.gateway.project;

/**
 * 一个生命周期内基本的行为
 */
public interface LifeCycle {
    /**
     * 初始化
     */
    void init();
    /**
     * 关闭
     */
    void shutdown();
    /**
     * 启动
     */
    void start();
}
