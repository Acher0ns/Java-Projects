package activities;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class PrintHostInfo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();
        System.out.println(host.getHostName() + ":");
        System.out.println("  " + host.getHostAddress());
    }
}