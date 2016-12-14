package com.ways2u.json.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huanglong on 2016/12/14.
 */
public class JsonUtils {
    /**
     * 对象转化为json fastjson 使用方式
     *
     * @return
     */
    public static String objectToJsonForFastJson(Object object) {
        if (object == null) {
            return "";
        }
        try {
            return JSON.toJSONString(object);
        } catch (JSONException e) {
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * json转化为对象  fastjson 使用方式
     *
     * @return
     */
    public static <T> T jsonToObjectForFastJson(String jsonData, Class<T> clazz) {
        if (TextUtils.isEmpty(jsonData)) {
            return null;
        }
        try {
            return JSON.parseObject(jsonData, clazz);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * json转化为List  fastjson 使用方式
     */
    public static List jsonToListForFastJson(String jsonData) {
        if (TextUtils.isEmpty(jsonData)) {
            return null;
        }
        List arrayList = null;
        try {
            arrayList = JSON.parseObject(jsonData, new TypeReference<ArrayList<Person>>() {});
        } catch (Exception e) {
        }
        return arrayList;

    }

    /**
     * json转化为Map  fastjson 使用方式
     */
    public static Map jsonToMapForFastJson(String jsonData) {
        if (TextUtils.isEmpty(jsonData)) {
            return null;
        }
        Map map = null;
        try {
            map = JSON.parseObject(jsonData, new TypeReference<Map>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
//---------------------------------------------------------------------------------------------------------
    /**
     * 对象转化为json对象  Gson 使用方式
     *
     * @return
     */
    public static String objectToJsonForGson(Object object) {
        if (object == null) {
            return "";
        }
        Gson gson;
        try {
            gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
            return gson.toJson(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * json转化为对象  Gson 使用方式
     *
     * @return
     */

    public static <T> T jsonToObjectForGson(String jsonData, Class<T> clazz) {
        if (TextUtils.isEmpty(jsonData)) {
            return null;
        }
        T finalResult = null;
        try {
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
            finalResult = gson.fromJson(jsonData, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finalResult;
    }

    /**
     * json转化为集合  Gson 使用方式
     */
    public static List jsonToListForForGson(String jsonData) {
        if (TextUtils.isEmpty(jsonData)) {
            return null;
        }
        List list = null;
        try {
            Type listType = new TypeToken<ArrayList<Person>>() {}.getType();
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
            list = gson.fromJson(jsonData, listType);
        } catch (Exception e) {
        }
        return list;
    }

    /**
     * json转化为Map  fastjson 使用方式
     */
    public static Map jsonToMapForForGson(String jsonData) {
        if (TextUtils.isEmpty(jsonData)) {
            return null;
        }
        Map map = null;
        try {
            Type listType = new TypeToken<Map>() {
            }.getType();
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
            map = gson.fromJson(jsonData, listType);
        } catch (Exception e) {
        }
        return map;
    }

    //---------------------------------------------------------------------------------------------------------

    /**
     * 对象转化为json对象  Jackson 使用方式
     *
     * @return
     */
    public static String objectToJsonForJackson(Object object) {
        if (object == null) {
            return "";
        }
        ObjectMapper mapper =  new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * json转化为对象  Gson 使用方式
     *
     * @return
     */

    public static <T> T jsonToObjectForJackson(String jsonData, Class<T> clazz) {
        if (TextUtils.isEmpty(jsonData)) {
            return null;
        }
        T finalResult = null;
        ObjectMapper mapper =  new ObjectMapper();
        try {
            finalResult = mapper.readValue(jsonData, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finalResult;
    }

    /**
     * json转化为集合  Gson 使用方式
     */
    public static List jsonToListForForJackson(String jsonData) {
        if (TextUtils.isEmpty(jsonData)) {
            return null;
        }
        List list = null;
        ObjectMapper mapper =  new ObjectMapper();
        try {
            list = mapper.readValue(jsonData, new com.fasterxml.jackson.core.type.TypeReference<List<Person>>(){});
        } catch (Exception e) {
        }
        return list;
    }

    /**
     * json转化为Map  fastjson 使用方式
     */
    public static Map jsonToMapForForJackson(String jsonData) {
        if (TextUtils.isEmpty(jsonData)) {
            return null;
        }
        Map map = null;
        ObjectMapper mapper =  new ObjectMapper();
        try {
            map = mapper.readValue(jsonData, HashMap.class);
        } catch (Exception e) {
        }
        return map;
    }
}
