package concepts.json;

import java.util.List;
import java.util.Map;

/**
 * Created by pradeep on 21/6/16.
 */
public class LiveFeed {

    Map<String, List<String>> stringListMap;

    public Map<String, List<String>> getStringListMap() {
        return stringListMap;
    }

    public void setStringListMap(Map<String, List<String>> stringListMap) {
        this.stringListMap = stringListMap;
    }

    @Override
    public String toString() {
        return stringListMap.toString();
    }
}
