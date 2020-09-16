package com.example.hongbao;

import java.util.*;

/**
 * @version V1.0
 * @Description 红包
 * @Author sunpeng93
 * @Date 2020/9/16
 */
public class RedEnvelop {
    public static double nextDouble(final double min, final double max) {
        double redA = min + ((max - min) * new Random().nextDouble());
        return redA;
    }

    public static String format(double value) {
        return new java.text.DecimalFormat("0.00").format(value); // 保留两位小数
    }
    /**
     * @Description 顺序领取
     * @Date  2020/9/16
     * @param money: 总金额
     * @param userList: 用户列表
     * @return java.util.List<java.lang.Double>
     */
    public static List<Double> doubleMeanMethodXu(double money, int number, LinkedList<User> userList){
        List<Double> result = new ArrayList<>();
        if(money<0||number<1)
            return result;
        int remainingNumber=number;
        double amount,sum=0;
        while(remainingNumber>=1){
            amount= nextDouble(0.01,2*(money/remainingNumber));
            sum+=amount;
            System.out.println(userList.pop().getName()+"领取的红包金额为："+format(amount));
            money -= amount;
            remainingNumber--;
            result.add(amount);
        }
        result.add(money);
        sum+=money;
        System.out.println("验证发出的红包总金额为："+format(sum));
        return result;
    }

    public static List<Double> doubleMeanMethodRandom(double money, int number, List<User> userList){
        List<Double> result = new ArrayList<>();
        if(money<0||number<1)
            return null;
        double amount,sum=0;
        int remainingNumber=number;
        while(remainingNumber>=1){
            if(remainingNumber == 1){
                amount = new Double(format(money));
                System.out.println(getUserName(userList)+"领取的红包金额为："+format(amount));
            }else{
                amount= new Double(format(nextDouble(0.01,2*(money/remainingNumber))));
                System.out.println(getUserName(userList)+"领取的红包金额为："+format(amount));
            }
            sum+=amount;
            money = new Double(format(money - amount));
            remainingNumber--;
            result.add(amount);
        }
        result.add(money);
        sum+=money;
        System.out.println("验证发出的红包总金额为："+format(sum));
        return result;
    }

    public static String getUserName(List<User> userList){
        while (true){
            int index = (int) (Math.random() * userList.size());
            if(!userList.get(index).getDrawFlag()){
                userList.get(index).setDrawFlag(true);
                return userList.get(index).getName();
            }
        }
    }


    public static void main(String[] args) {
        LinkedList<User> userLinkedList = new LinkedList();
        userLinkedList.add(new User("马晓莹","Maria0919"));
        userLinkedList.add(new User("小河马的长颈鹿","LY-DQQ"));
        userLinkedList.add(new User("萤火虫","yinghuochong8482"));
        userLinkedList.add(new User("A宋军明","jessensone"));
        userLinkedList.add(new User("sv","shaow999"));
        userLinkedList.add(new User("我不是王小胖","wangbubu622"));
        userLinkedList.add(new User("我心情不好ing","mayixinenjoylife"));

        List<User> userList = new ArrayList<>();
        userList.add(new User("马晓莹","Maria0919"));
        userList.add(new User("小河马的长颈鹿","LY-DQQ"));
        userList.add(new User("A宋军明","jessensone"));
        userList.add(new User("萤火虫","yinghuochong8482"));
        userList.add(new User("我不是王小胖","wangbubu622"));
        userList.add(new User("sv","shaow999"));
        userList.add(new User("我心情不好ing","mayixinenjoylife"));
        // 指定红包个数，顺序抢红包
//        doubleMeanMethodXu(10,7, userLinkedList);
        // 指定红包个数，随机抢红包
        doubleMeanMethodRandom(10,3,userList);
    }
}

class User{
    private String name;
    private String code;
    private Boolean drawFlag = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getDrawFlag() {
        return drawFlag;
    }

    public void setDrawFlag(Boolean drawFlag) {
        this.drawFlag = drawFlag;
    }

    public User(String name, String code) {
        this.name = name;
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(code, user.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
