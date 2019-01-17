package ru.job4j.ip;

import org.junit.Test;

import java.util.List;

public class RangeIpTest {
    @Test
    public void rangeTest() {
        String startIp = "192.168.2.1";
        String endIp = "192.168.4.3";
        RangeIP rip = new RangeIP();
        List<String> rst = rip.range(startIp, endIp);
    }
}
