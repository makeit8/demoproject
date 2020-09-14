package com.example.aopdemo.aop;

import com.example.aopdemo.service.DemoSecondService;
import com.example.aopdemo.service.impl.DemoFirstImpl;
import com.example.entry.Person;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @version V1.0
 * @Description aop
 * @Author sunpeng93
 * @Date 2020/7/13
 */
@Aspect
@Component
public class DemoAop {
    @Resource
    private DemoSecondService demoSecondService;

//    private static final String pointCutString = "execution(* com.example.aopdemo.service.DemoFirstService.*(..))";
    private static final String pointCutString = "@annotation(com.example.aopdemo.service.DemoAopAnnotation)";


//    @Pointcut(pointCutString)
    public void executeService(){
        System.out.println("executeService");
    }

//    @Before("executeService()")
    public void beforeMethod(JoinPoint joinPoint){
        Object methodName = joinPoint.getSignature().getName();
        Object[] obj = joinPoint.getArgs();
        for (Object argItem : obj) {
            //参数处理
            if("zhang".equals(String.valueOf(argItem))){
            }
        }
    }

//    @AfterReturning(value = pointCutString, returning = "keys")
    public void afterReturnMethod(JoinPoint joinPoint, Object keys){
        System.out.println("第一个后置返回通知的返回值：" + keys);
        if (keys instanceof String) {
            String resultVO = (String) keys;
            resultVO = keys + " be changed!";
            System.out.println("修改完毕-->返回方法为:" + resultVO);
        }
    }

//    @After("executeService()")
    public void afterMethod(JoinPoint joinPoint){
        System.out.println("after method");
    }


    @Around(pointCutString)
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("环绕通知的目标方法名：" + proceedingJoinPoint.getSignature().getName());
        Class clazz = proceedingJoinPoint.getTarget().getClass();
        System.out.println(clazz);
        Signature signature = proceedingJoinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature)signature;
        Method targetMethod = methodSignature.getMethod();
        System.out.println(methodSignature.getParameterTypes());
        targetMethod.getParameters();
        for(Class clazza : methodSignature.getParameterTypes()){
            System.out.println(clazza);
            System.out.println(clazza.equals(Person.class));
        }

        Object object = null;
        try {
            if(1==1){
                Person param = processInputArg(proceedingJoinPoint.getArgs());
                return demoSecondService.getRealName(param);
            } else {
                object = proceedingJoinPoint.proceed();//调用执行目标方法
                String name = processOutPutObj(object);
                System.out.println(name);
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return object;
    }

    private Person processInputArg(Object[] args) {
        System.out.println(args);
        Person newParam = null;
        for (Object argItem : args) {
            newParam = (Person)argItem;
            //参数处理
        }
        System.out.println(newParam.toString());
        return newParam;
    }

    private String processOutPutObj(Object object){
        if(object instanceof List){
            List<Person> list = (List<Person>) object;
            return list.get(0).getName();
        }
        return "";
    }
}
