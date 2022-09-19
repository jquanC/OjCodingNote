package Qiu.WanMei;

import java.util.*;

public class Main {
    public static class Item{
        public final String name;
        public int num;

        public Item(String name,int num) {
            this.name = name;
            this.num = num;
        }

        @Override
        public String toString(){
            return "[" + name + "," + num + "]";
        }
    }
    public static Comparator<Item>  itemComparator = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            if(o1.name.compareTo(o2.name)==0){
                return o2.num-o1.num;
            }
            return o1.name.compareTo(o2.name);
        }
    };

    public List<Item> tryAddAndPack(List<Item> itemList, List<Item> itemAddList, Map<String, Integer> confMap, int capacity) {
        //TODO

        HashMap<String,Integer> couMap = new HashMap();
        for(Item e:itemList){
            couMap.put(e.name,(couMap.getOrDefault(e.name,0)+e.num));
        }
        for(Item e:itemAddList){
            couMap.put(e.name,(couMap.getOrDefault(e.name,0)+e.num));
        }
        //快速计算是否超出容量
        int needCou =0;
        for(String name:couMap.keySet()){
            int cou = couMap.get(name);
            int oneUp = confMap.get(name);
            needCou += cou/oneUp;
            if(cou%oneUp!=0) needCou++;
            if(needCou>capacity){
                itemList = rePack(itemList,confMap);
                itemAddList.sort(itemComparator);
                return itemList;
            }
        }
        //说明可以添加不会超
        List<Item> afAddAndPack = new ArrayList();

        for(String name:couMap.keySet()){
            int cou = couMap.get(name);
            int oneUp = confMap.get(name);
            for(int i=0;i<cou/oneUp;i++){
                afAddAndPack.add(new Item(name,oneUp));
            }
            if(cou%oneUp!=0) afAddAndPack.add(new Item(name,cou%oneUp));
        }
        //显然不需要对afAddAndPack 是整理好的，直接排序返回即可
        afAddAndPack.sort(itemComparator);
        return afAddAndPack;

    }
    /**该方法用于重新整理背包*/
    public List<Item> rePack(List<Item> bfPack,Map<String, Integer> confMap){
        HashMap<String,Integer> couMap = new HashMap();
        for(Item e:bfPack){
            couMap.put(e.name,(couMap.getOrDefault(e.name,0)+e.num));
        }
        List<Item> afPack = new ArrayList();
        for(String name:couMap.keySet()){
            int cou = couMap.get(name);
            int oneUp = confMap.get(name);
            for(int i=0;i<cou/oneUp;i++){
                afPack.add(new Item(name,oneUp));
            }
            if(cou%oneUp!=0) afPack.add(new Item(name,cou%oneUp));
        }
        return afPack;
    }

}
