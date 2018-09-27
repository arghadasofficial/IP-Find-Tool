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

import argha.InfoModel;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Argha Das
 */
public class ParseUtil {

    public ArrayList<InfoModel> parseJson(String data) {
        ArrayList<InfoModel> infoModels = new ArrayList<>();
        infoModels.clear();
        
        try {
            JSONObject jsonObject = new JSONObject(data);
            String ip = jsonObject.getString("query");
            String city = jsonObject.getString("city");
            String region = jsonObject.getString("region");
            String regionName = jsonObject.getString("regionName");
            String countryCode = jsonObject.getString("countryCode");
            String country = jsonObject.getString("country");
            String timezone = jsonObject.getString("timezone");
            String zip = jsonObject.getString("zip");
            String lat = jsonObject.getString("lat");
            String lon = jsonObject.getString("lon");
            String isp = jsonObject.getString("isp");
            String org = jsonObject.getString("org");
            String as = jsonObject.getString("as");
            String mobile = jsonObject.getString("mobile");
            String proxy = jsonObject.getString("proxy");

            infoModels.add(new InfoModel("Ip", ip));
            infoModels.add(new InfoModel("City", city));
            infoModels.add(new InfoModel("Region", region));
            infoModels.add(new InfoModel("Region Name", regionName));
            infoModels.add(new InfoModel("Country Code", countryCode));
            infoModels.add(new InfoModel("Country Name", country));
            infoModels.add(new InfoModel("Timezone", timezone));
            infoModels.add(new InfoModel("Zip", zip));
            infoModels.add(new InfoModel("Latitude", lat));
            infoModels.add(new InfoModel("Longitude", lon));
            infoModels.add(new InfoModel("Isp", isp));
            infoModels.add(new InfoModel("Org", org));
            infoModels.add(new InfoModel("As", as));
            infoModels.add(new InfoModel("Mobile ?", mobile));
            infoModels.add(new InfoModel("Proxy ?", proxy));
        } catch (JSONException ex) {
            ex.getCause();
        }
        return infoModels;
    }
}
