package win.likie.jna;

import sun.net.util.IPAddressUtil;

/**
 * 校验ipv4
 *
 * @author huahui.wu. (;￢＿￢)
 * Created on 2018/4/25.
 */
public class IPv4Check {
    private static boolean internalIp(byte[] addr) {
        final byte b0 = addr[0];
        final byte b1 = addr[1];
        //10.x.x.x/8
        final byte SECTION_1 = 0x0A;
        //172.16.x.x/12
        final byte SECTION_2 = (byte) 0xAC;
        final byte SECTION_3 = (byte) 0x10;
        final byte SECTION_4 = (byte) 0x1F;
        //192.168.x.x/16
        final byte SECTION_5 = (byte) 0xC0;
        final byte SECTION_6 = (byte) 0xA8;
        switch (b0) {
            case SECTION_1:
                return true;
            case SECTION_2:
                if (b1 >= SECTION_3 && b1 <= SECTION_4) {
                    return true;
                }
            case SECTION_5:
                switch (b1) {
                    case SECTION_6:
                        return true;
                }
            default:
                return false;

        }
    }

    /**
     * 校验ip是否是有效的ipv4，并且如果是内网ip返回true,外网ip返回true
     *
     * @param ip
     * @return
     * @throws Exception
     */
    private static boolean internalIp(String ip) throws Exception {
        boolean isIpv4 = IPAddressUtil.isIPv4LiteralAddress(ip);
        if (!isIpv4) {
            throw new Exception(ip + "该ip不是有效的ip地址");
        }
        byte[] addr = IPAddressUtil.textToNumericFormatV4(ip);
        return internalIp(addr);
    }

    public static void main(String[] args) throws Exception {
        //外网
        System.out.println(internalIp("172.12.25.25"));
        System.out.println(internalIp("119.28.188.114"));
        System.out.println(internalIp("72.11.150.248"));
        System.out.println(internalIp("88.198.50.201"));
        System.out.println(internalIp("115.236.172.148"));
        System.out.println(internalIp("192.169.1.1"));
        System.out.println("---------------------");

        //内网
        System.out.println(internalIp("172.16.2.2"));
        System.out.println(internalIp("192.168.1.1"));
        System.out.println(internalIp("192.168.254.254"));
        System.out.println(internalIp("10.25.25.25"));

        System.out.println("--------------------");
        //无效ip
        System.out.println(internalIp("192.169.255.256"));

    }
}
