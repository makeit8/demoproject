package com.example.strategyfactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sunpeng93
 * @description 用户类型工厂策略
 * @date 2019/12/29
 */
public class StrategyFactory {
    private Map<Integer,Strategy> map;
    // 构造方法私有化
    private StrategyFactory(){
        List<Strategy> strategyList = new ArrayList<Strategy>();

        strategyList.add(new OrdinaryStrategy());
        strategyList.add(new SliverStrategy());
        strategyList.add(new GoldStrategy());
        strategyList.add(new DiamondStrategy());

        map = strategyList.stream().collect(Collectors.toMap(Strategy::getType,strategy->strategy));
    }
    // 静态私有内部类 单例模式 获得策略
    // 只有在第一次调用getInstance()方法时，JVM才会加载Holder类，并初始化静态变量instance，这实现了延迟加载，该方式是线程安全的
    private static class Holder{
        public static final StrategyFactory instance = new StrategyFactory();
    }
    // 公开的静态的获得该实例分方法
    public static StrategyFactory getInstance(){
        return Holder.instance;
    }

    public Strategy getStrategy(Integer type){
        return map.get(type);
    }

    public static double getResult(long money,int type){
        if(money < 1000){
            return money;
        }

        Strategy strategy = StrategyFactory.getInstance().getStrategy(type);
        if(strategy == null)
            throw new IllegalArgumentException("please input right type");
        return strategy.compute(money);
    }


}
