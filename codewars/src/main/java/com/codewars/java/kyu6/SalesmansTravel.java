package com.codewars.java.kyu6;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A traveling salesman has to visit clients. He got each client's address e.g. "432 Main Long Road St.
 * Louisville OH 43071" as a list.
 * The basic zipcode format usually consists of two capital letters followed by a white space and five digits.
 * The list of clients to visit was given as a string of all addresses, each separated from the others by a comma, e.g. :
 * "123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432".
 * To ease his travel he wants to group the list by zipcode.
 *
 * Task
 * The function travel will take two parameters r (addresses' list of all clients' as a string) and zipcode and returns
 * a string in the following format:
 * zipcode:street and town,street and town,.../house number,house number,...
 * The street numbers must be in the same order as the streets where they belong.
 * If a given zipcode doesn't exist in the list of clients' addresses return "zipcode:/"
 *
 * Examples
 * r = "123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432"
 * travel(r, "OH 43071") --> "OH 43071:Main Street St. Louisville,Main Long Road St. Louisville/123,432"
 * travel(r, "NY 56432") --> "NY 56432:High Street Pollocksville/786"
 * travel(r, "NY 5643") --> "NY 5643:/"
 */
public class SalesmansTravel {

    private static class AddressesByZip {

        public static final Addresses DEFAULT_VALUE = new Addresses();
        private final Map<String, Addresses> map = new HashMap<>();

        public static class Addresses {

            private StringJoiner streets = new StringJoiner(",");
            private StringJoiner houseNumbers = new StringJoiner(",", "/", "");

            public Addresses setStreet(String street) {
                streets.add(street);
                return  this;
            }

            public Addresses setHouseNumber(String houseNumber) {
                houseNumbers.add(houseNumber);
                return  this;
            }

            @Override
            public String toString() {
                return "" + streets + houseNumbers;
            }
        }

        public void load(String input) {
            String[] addresses = input.split(",");
            Pattern pattern = Pattern.compile("^(\\d{1,4}) (.+) ([A-Z]{2} \\d{5})$");
            for (String adders : addresses) {
                Matcher matcher = pattern.matcher(adders);
                if (matcher.find()) {
                    String houseNumber = matcher.group(1);
                    String street = matcher.group(2);
                    String zip = matcher.group(3);
                    map.computeIfAbsent(zip, K -> new Addresses())
                            .setStreet(street)
                            .setHouseNumber(houseNumber);
                }
            }
        }

        public String get(String key) {
            return key + ":" + map.getOrDefault(key, DEFAULT_VALUE);
        }
    }

    public static String travel(String r, String zipcode) {
        AddressesByZip mapTut = new AddressesByZip();
        mapTut.load(r);
        return mapTut.get(zipcode);
    }

    String r = "123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432";
    String ad = "123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432,"
            + "54 Holy Grail Street Niagara Town ZP 32908,3200 Main Rd. Bern AE 56210,1 Gordon St. Atlanta RE 13000,"
            + "10 Pussy Cat Rd. Chicago EX 34342,10 Gordon St. Atlanta RE 13000,58 Gordon Road Atlanta RE 13000,"
            + "22 Tokyo Av. Tedmondville SW 43098,674 Paris bd. Abbeville AA 45521,10 Surta Alley Goodtown GG 30654,"
            + "45 Holy Grail Al. Niagara Town ZP 32908,320 Main Al. Bern AE 56210,14 Gordon Park Atlanta RE 13000,"
            + "100 Pussy Cat Rd. Chicago EX 34342,2 Gordon St. Atlanta RE 13000,5 Gordon Road Atlanta RE 13000,"
            + "2200 Tokyo Av. Tedmondville SW 43098,67 Paris St. Abbeville AA 45521,11 Surta Avenue Goodtown GG 30654,"
            + "45 Holy Grail Al. Niagara Town ZP 32918,320 Main Al. Bern AE 56215,14 Gordon Park Atlanta RE 13200,"
            + "100 Pussy Cat Rd. Chicago EX 34345,2 Gordon St. Atlanta RE 13222,5 Gordon Road Atlanta RE 13001,"
            + "2200 Tokyo Av. Tedmondville SW 43198,67 Paris St. Abbeville AA 45522,11 Surta Avenue Goodville GG 30655,"
            + "2222 Tokyo Av. Tedmondville SW 43198,670 Paris St. Abbeville AA 45522,114 Surta Avenue Goodville GG 30655,"
            + "2 Holy Grail Street Niagara Town ZP 32908,3 Main Rd. Bern AE 56210,77 Gordon St. Atlanta RE 13000";

    private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        System.out.println("Fixed Tests: travel");
        testing(travel(r, "OH 43071"), "OH 43071:Main Street St. Louisville,Main Long Road St. Louisville/123,432");
        testing(travel(r, "NY 5643"), "NY 5643:/");
        testing(travel(ad, "AA 45522"), "AA 45522:Paris St. Abbeville,Paris St. Abbeville/67,670");
        testing(travel(ad, "EX 34342"), "EX 34342:Pussy Cat Rd. Chicago,Pussy Cat Rd. Chicago/10,100");
        testing(travel(ad, "EX 34345"), "EX 34345:Pussy Cat Rd. Chicago/100");
        testing(travel(ad, "AA 45521"), "AA 45521:Paris bd. Abbeville,Paris St. Abbeville/674,67");
        testing(travel(ad, "AE 56215"), "AE 56215:Main Al. Bern/320");
    }
}
