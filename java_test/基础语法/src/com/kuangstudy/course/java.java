package com.kuangstudy.course;

/**
 * 这是一个Javadoc测试程序
 *
 * @author niconiconi
 * @version 1.0
 * @since 1.5
 */
public class java {
    public String name;

//    /**  使用/** + Enter自动生成下列文档注释，再填参数即可；下面的为填写好的结果
//     *
//     * @param name
//     * @return
//     * @throws Exception
//     */

    /**
     * @param name 姓名
     * @return 返回name姓名
     * @throws Exception 无异常抛出
     */
    public String function(String name) throws Exception {
        return name;
    }
}
