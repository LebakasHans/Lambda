package net.htlgr.WintersteigerJ190225.hue2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class HalloJavamitForEach {

    public void differentForEach(){
        List<String> list = Arrays.asList("test1", "test2");
         for(var s : list){
             System.out.println(s);
         }
         //list.forEach(s -> System.out.println(s));
         list.forEach(System.out::println);
     }
}
