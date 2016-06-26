package concepts.json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pradeep on 21/6/16.
 */
public class JsonParser {

    public static void main(String[] args) throws IOException {

        String jsonString = "{\"a146a80\":[\"4BD14F\",28.08568,76.37415,27,17575,329,\"0652\",\"200\",\"B738\",\"TC-TJO\",1466410593,\"COK\",\"DEL\",\"SG562\",0,-192,\"SEJ562\",0]  ,\"a146a90\":[\"4BD150\",25.12602,55.67226,232,5075,216,\"5454\",\"200\",\"B738\",\"TC-TJP\",1466410592,\"DEL\",\"DXB\",\"SG11\",0,-1280,\"SEJ11\",0],\"a148ca0\":[\"8001D9\",16.33230,82.92186,219,37975,480,\"2675\",\"200\",\"B738\",\"VT-SPF\",1466410592,\"CCU\",\"MAA\",\"SG277\",0,0,\"SEJ277\",0],\"a149399\":[\"8007EF\",26.82967,82.23448,80,34975,459,\"0000\",\"200\",\"B738\",\"VT-SZI\",1466410593,\"DEL\",\"IXB\",\"SG675\",0,0,\"SEJ675\",0],\"a149718\":[\"8003AD\",16.39309,82.71318,46,27975,417,\"0216\",\"200\",\"B738\",\"VT-SPK\",1466410592,\"MAA\",\"VTZ\",\"SG502\",0,-2176,\"SEJ502\",0],\"a149925\":[\"800AF7\",15.42426,74.00916,226,2950,191,\"0350\",\"200\",\"B739\",\"VT-SZL\",1466410592,\"PNQ\",\"GOI\",\"SG514\",0,-448,\"SEJ514\",0],\"a14992c\":[\"80070F\",30.74967,76.53055,353,5000,206,\"3351\",\"200\",\"B738\",\"VT-SZA\",1466410134,\"DEL\",\"IXC\",\"SG130\",0,-1344,\"SEJ130\",0],\"a149b0a\":[\"800407\",29.49280,75.94823,132,22225,315,\"0502\",\"200\",\"B738\",\"VT-SPP\",1466410592,\"IXJ\",\"DEL\",\"SG161\",0,-1152,\"SEJ161\",0],\"a149c56\":[\"800B82\",24.06918,88.03504,340,27100,487,\"2646\",\"200\",\"B739\",\"VT-SLC\",1466410592,\"CCU\",\"IXB\",\"SG623\",0,1600,\"SEJ623\",0],\"a149f64\":[\"80070E\",12.11094,75.31346,335,37825,456,\"2765\",\"200\",\"B738\",\"VT-SGZ\",1466410594,\"COK\",\"BOM\",\"SG164\",0,832,\"SEJ164\",0],\"a14a1c2\":[\"800700\",32.91249,75.42059,344,23975,433,\"3364\",\"200\",\"B738\",\"VT-SGY\",1466410593,\"ATQ\",\"SXR\",\"SG438\",0,0,\"SEJ438\",0],\"a14a33f\":[\"8006E8\",29.61999,75.27158,317,18000,260,\"3360\",\"12305\",\"DH8D\",\"VT-SUI\",1466410553,\"DEL\",\"DHM\",\"SG2191\",0,0,\"SEJ2191\",0],\"a14a352\":[\"8005D5\",32.33678,75.60326,165,23475,359,\"3367\",\"200\",\"B738\",\"VT-SGG\",1466410594,\"SXR\",\"ATQ\",\"SG415\",0,-1280,\"SEJ415\",0],\"a14a467\":[\"800B81\",13.05232,80.13153,354,2525,233,\"0231\",\"200\",\"B737\",\"VT-SLB\",1466410592,\"MAA\",\"DEL\",\"SG104\",0,2496,\"SEJ104\",0],\"a14a6c8\":[\"80067F\",25.57357,91.54837,194,17975,363,\"0000\",\"200\",\"B738\",\"VT-SGV\",1466410594,\"GAU\",\"IXA\",\"SG152\",0,0,\"SEJ152\",0],\"a14a732\":[\"800B80\",29.94150,77.46079,239,14900,319,\"3341\",\"200\",\"B737\",\"VT-SLA\",1466410594,\"DEL\",\"MAA\",\"SG103\",0,1536,\"SEJ103\",0],\"a14a7d1\":[\"8006ED\",13.21874,77.65182,283,5900,194,\"0000\",\"12305\",\"DH8D\",\"VT-SUO\",1466410590,\"BLR\",\"CJB\",\"SG1077\",0,2944,\"SEJ1077\",0],\"full_count\":17,\"version\":4}";


        String[] strings = jsonString.substring(1, jsonString.length() - 1).split("][ ]*,");

        for (int index = 0; index < strings.length - 1; index++) {
            System.out.println(strings[index]);
            String[] strings1 = strings[index].split(":[ ]*\\[");
            Journey journey = new Journey();
            Flight flight = new Flight();
            flight.setId(strings1[1]);
            Map<String, String> stringStringMap = populateData(strings1[1]);
        }

    }

    private static Map<String, String> populateData(String s) {
        Map<String, String> stringStringMap = new HashMap<>();

        String[] strings = s.split(",");
        stringStringMap.put("airCraftId", strings[0]);
        stringStringMap.put("latitude", strings[1]);
        stringStringMap.put("longitude", strings[2]);
        stringStringMap.put("track", strings[3]);
        stringStringMap.put("altitude", strings[4]);
        stringStringMap.put("speed", strings[5]);
        stringStringMap.put("squawk", strings[6]);
        stringStringMap.put("radar_id", strings[7]);
        stringStringMap.put("type", strings[8]);
        stringStringMap.put("registration", strings[9]);
        stringStringMap.put("last_update", strings[10]);
        stringStringMap.put("origin", strings[11]);
        stringStringMap.put("destination", strings[12]);
        stringStringMap.put("flight", strings[13]);
        stringStringMap.put("onground", strings[14]);
        stringStringMap.put("vspeed", strings[15]);
        stringStringMap.put("callsign", strings[16]);
        stringStringMap.put("reserved", strings[17]);

        System.out.println(stringStringMap);
        return stringStringMap;
    }
}
