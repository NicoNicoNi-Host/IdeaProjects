package com.fly.pojo;

import gnu.io.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

//串口工具类
public class SerialUtil {
    public static void main(String[] args) {

    }
    /**
     * 获得系统可用的端口名称列表(COM0、COM1、COM2等等)
     */
    public static List<String> getSerialPortList() {
        List<String> systemPorts = new ArrayList<>();
        //获得系统可用的端口
        Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();
        while (portList.hasMoreElements()) {
            String portName = portList.nextElement().getName();//获得端口的名字
            systemPorts.add(portName);
        }
        return systemPorts;
    }


    /**
     * 打开串口
     */
    public static SerialPort openSerialPort(SerialVo serialVo, int timeout) throws Exception {
        //通过端口名称得到端口
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(serialVo.getSerialPortName());
        //打开端口，（自定义名字，打开超时时间）
        CommPort commPort = portIdentifier.open(serialVo.getSerialPortName(), timeout);
        //判断是不是串口
        if (commPort instanceof SerialPort) {
            SerialPort serialPort = (SerialPort) commPort;
            //设置串口参数（波特率，数据位8，停止位1，校验位无）
            serialPort.setSerialPortParams(serialVo.getBaudRate(), serialVo.getDataBits(), serialVo.getStopBits(), serialVo.getParity());
            System.out.println("开启串口成功，串口名称：" + serialVo.getSerialPortName());
            return serialPort;
        } else {
            //是其他类型的端口
            throw new NoSuchPortException();
        }
    }


    /**
     * 关闭串口
     */
    public static void closeSerialPort(SerialPort serialPort) {
        if (serialPort != null) {
            serialPort.close();
            System.out.println("关闭了串口：" + serialPort.getName());
        }
    }


    /**
     * 向串口发送数据
     */
    public static void sendData(SerialPort serialPort, byte[] data) {
        OutputStream os = null;
        try {
            //获得串口的输出流
            os = serialPort.getOutputStream();
            os.write(data);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 从串口读取数据
     */
    public static byte[] readData(SerialPort serialPort) {
        InputStream is = null;
        byte[] bytes = null;
        try {
            //获得串口的输入流
            is = serialPort.getInputStream();
            //获得数据长度
            int bufflenth = is.available();
            while (bufflenth != 0) {
                //初始化byte数组
                bytes = new byte[bufflenth];
                is.read(bytes);
                bufflenth = is.available();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytes;
    }


    /**
     * 给串口设置监听
     */
    public static void setListenerToSerialPort(SerialPort serialPort, SerialPortEventListener listener) throws Exception {
        //给串口添加事件监听
        serialPort.addEventListener(listener);
        //串口有数据监听
        serialPort.notifyOnDataAvailable(true);
        //中断事件监听
        serialPort.notifyOnBreakInterrupt(true);
    }

}