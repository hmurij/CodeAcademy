package lt.codeacademy;

import lt.codeacademy.model.DnsProvider;
import lt.codeacademy.model.DnsServer;
import lt.codeacademy.model.Map;

public class App
{
    public static void main( String[] args )
    {
        Map<DnsProvider, DnsServer> dnsMap = new Map<>();
        dnsMap.addPair(DnsProvider.GOOGLE, new DnsServer("8.8.8.8", "8.8.4.4"));
        dnsMap.addPair(DnsProvider.CLOUDFLARE, new DnsServer("1.1.1.1", "1.0.0.1"));

        System.out.println(dnsMap.getPairValue(DnsProvider.GOOGLE));
        System.out.println(dnsMap.getPairValue(DnsProvider.CLOUDFLARE));

        Map<String, String> dictionaryMap = new Map<>();
        dictionaryMap.addPair("Labas", "Hello");
        dictionaryMap.addPair("Pasaulis", "World");

        System.out.println(dictionaryMap.getPairValue("Labas"));
        System.out.println(dictionaryMap.getPairValue("Pasaulis"));
    }
}
