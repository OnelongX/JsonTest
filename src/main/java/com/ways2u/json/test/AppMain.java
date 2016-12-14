package com.ways2u.json.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by huanglong on 2016/12/14.
 */
public class AppMain {
/**
 * 大于10w :
 * 解析 Jackson>>Gson>>FastJson
 * 生成 Jackson>>Gson>>FastJson
 * 小于10w :
 * 解析 FastJson>>Jackson>>Gson
 * 生成 Jackson>>Gson>>FastJson
 * 小于1w :
 * 解析 FastJson>>Gson>>Jackson
 * 生成 Gson>>FastJson>>Jackson
 *
 * */
    public static void main(String[] agvs){
        List<Person> personList=new ArrayList<Person>();
        //int testMaxCount=1000000;//测试的最大数据条数
        int testMaxCount=1000000;
        //添加测试数据
        for(int i=0;i<testMaxCount;i++){
            Person person =new Person();
            person.setAge(i);
            person.setName(String.valueOf(i));
            person.prop = new Prop();
            personList.add(person);
        }

        //FastJson生成json数据
        long start=System.currentTimeMillis();
        String jsonData=JsonUtils.objectToJsonForFastJson(personList);
        long end=System.currentTimeMillis();
        System.out.println("FastJson生成json数据 cost time---->"+(end-start));


        //FastJson解析json数据
        start=System.currentTimeMillis();
        List<Person> tempPersons=JsonUtils.jsonToListForFastJson(jsonData);
        System.out.println(tempPersons.get(0).prop.getClass());
        end=System.currentTimeMillis();
        System.out.println("FastJson解析json数据 cost time---->"+(end-start));

        //Gson生成json数据
        start=System.currentTimeMillis();
        jsonData=JsonUtils.objectToJsonForGson(personList);
        end=System.currentTimeMillis();
        System.out.println("Gson生成json数据 cost time---->"+(end-start));

        //Gson解析json数据
        start=System.currentTimeMillis();
        List<Person> tempPersons1=JsonUtils.jsonToListForForGson(jsonData);
        System.out.println(tempPersons1.get(0).prop.getClass());
        end=System.currentTimeMillis();
        System.out.println("Gson解析json数据 cost time---->"+(end-start));


        //Jackson生成json数据
        start=System.currentTimeMillis();
        jsonData=JsonUtils.objectToJsonForJackson(personList);
        end=System.currentTimeMillis();
        System.out.println("Jackson生成json数据 cost time---->"+(end-start));

        //Jackson解析json数据
        start=System.currentTimeMillis();
        List<Person> tempPersons2=JsonUtils.jsonToListForForJackson(jsonData);
        System.out.println(tempPersons2.get(0).prop.getClass());
        end=System.currentTimeMillis();
        System.out.println("Jackson解析json数据 cost time---->"+(end-start));

    }



}
