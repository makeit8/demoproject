package com.example.test;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @version V1.0
 * @Description 1
 * @Author sunpeng93
 * @Date 2020/9/10
 */
public class StreamTest {

    public static void main(String[] args) {
        Fruit a1 = new Fruit(1,"apple",new BigDecimal(1));
        Fruit a2 = new Fruit(1,"apple",new BigDecimal(2));
        Fruit a3 = new Fruit(2,"banana",new BigDecimal("3.4"));
        List<Fruit> fruitList = new ArrayList<>();
        fruitList.add(a1);
        fruitList.add(a2);
        fruitList.add(a3);

        //转map
        Map<Integer,Fruit> fruitMap = fruitList.stream()
                .collect(Collectors.toMap(Fruit::getId,a->a,(k1,k2)->k1));


        for(Map.Entry<Integer,Fruit> entry: fruitMap.entrySet()){
            System.out.println(entry.getKey()+ entry.getValue().toString());
        }

        Double d = 3.2;
        Float f = 3.2f;
        BigDecimal bigDecimal = new BigDecimal(f);
        System.out.println(d.toString());
        System.out.println(f.toString());
        System.out.println(bigDecimal.toString());

    }
}
class Fruit {
    private Integer id;
    private String name;
    private BigDecimal price;

    public Fruit() {
    }

    public Fruit(Integer id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
