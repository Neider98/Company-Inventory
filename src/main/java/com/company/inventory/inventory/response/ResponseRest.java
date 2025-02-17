package com.company.inventory.inventory.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;

@Data
public class ResponseRest {

    private ArrayList<HashMap<String, String>> metadata = new ArrayList<>();

    public void setMetadata(String type, String code, String date) {
        HashMap<String, String> map = new HashMap<>();
        map.put("type", type);
        map.put("code", code);
        map.put("date", date);

        metadata.add(map);
    }
}
