/*
 * Copyright (C) 2018 Argha Das
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package argha.Utils;

/**
 *
 * @author Argha Das
 */
public class QueryUtil {

    private final String baseUrl = "http://ip-api.com/json/";
    private final String fields = "fields=country,countryCode,region,regionName,city,zip,lat,lon,timezone,isp,org,as,mobile,proxy,query";
    private final String command = "?";
    private String ip;
    private String url;

    public void buildURL(String IP) {
        this.ip = IP;
        if (ip.isEmpty()) {
            System.out.println("No Input found so we are printing out Your IP information");
            url = baseUrl + command + fields;
        } else if (!ip.isEmpty()) {
            System.out.println("Now printing information of " + IP);
            url = baseUrl + this.ip + command + fields;
        }
    }

    public String getUrl() {
        return url;
    }
}
