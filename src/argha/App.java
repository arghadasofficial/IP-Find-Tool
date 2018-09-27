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
package argha;

import argha.Utils.NetworkUtil;
import argha.Utils.ParseUtil;
import argha.Utils.QueryUtil;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Argha Das
 */
public class App {

    private String defaultIp = "google.com";
    private QueryUtil queryUtil;
    private ParseUtil parseUtil;
    private NetworkUtil networkUtil;
    private ArrayList<InfoModel> infoModels = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    private boolean active = true;

    public App() {
        queryUtil = new QueryUtil();
        networkUtil = new NetworkUtil();
        parseUtil = new ParseUtil();

        String ip;
        String url;
        String data;
        while (active) {
            ip = printsMenu();
            if (ip != null) {
                url = getURL(ip);
                if (url != null) {
                    data = getData(url);
                    infoModels = parseUtil.parseJson(data);
                    System.out.println("\n~~~~Information~~~~\n");
                    executeData();
                }
                active = decision();
            }
        }
    }

    public static void main(String[] args) {
        new App();
    }

    private void executeData() {
        for(InfoModel info : infoModels){
            System.out.println(info.getType() + " : " + info.getValue());
        }
    }

    private String printsMenu() {
        System.out.print("Enter IP : ");
        String ip = scan.nextLine();
        if (!ip.isEmpty()) {
            return ip;
        }
        return defaultIp;
    }

    private boolean decision() {
        System.out.println("");
        System.out.print("Continue ? (C) : ");
        String input = scan.nextLine();
        if (input.equalsIgnoreCase("C")) {
            return true;
        }
        System.out.println("Thank you for using our Service");
        return false;
    }

    private String getURL(String ip) {
        if (ip.isEmpty() || ip == null) {
            queryUtil.buildURL("");
        } else {
            queryUtil.buildURL(ip);
            String url = queryUtil.getUrl();
            if (!url.isEmpty() && url != null) {
                return url;
            }
        }
        return null;
    }

    private String getData(String url) {
        String data = networkUtil.getData(url);
        if (data != null && !data.isEmpty()) {
            return data;
        }
        return null;
    }

}
