package com.neusoft.gofmodel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DinamicProxyModel {

    public static void main(String[] args) {

        IGamePlayer gp = new GamePlayer("张三");
        InvocationHandler gpHandler = new GamePlayerInvocationHandler(gp);
        //获取真实主题类的ClassLoader
        ClassLoader classLoader = gp.getClass().getClassLoader();
        //动态产生一个代理者。
        Class<?>[] cls = new Class[]{IGamePlayer.class};
        IGamePlayer proxyGp = (IGamePlayer) Proxy.newProxyInstance(classLoader, cls, gpHandler);
        proxyGp.login("zhangsan", "123456");
        proxyGp.killBoss();
        proxyGp.upGrade();

    }

}

interface IGamePlayer {
    //登录游戏
    public void login(String username, String password);

    //击杀Boss
    public void killBoss();

    //升级
    public void upGrade();
}

class GamePlayer implements IGamePlayer {

    private String name = "";

    public GamePlayer(String name){
        this.name = name;
    }

    public void login(String username, String password) {
        System.out.println("登录名为 "+username+" 进入游戏，" + name + " 登录成功！");
    }

    public void killBoss() {
        System.out.println(this.name + " 击杀了Boss！");
    }

    public void upGrade() {
        System.out.println(this.name + "升级了！");
    }

}

class GamePlayerInvocationHandler implements InvocationHandler {

    //被代理的对象
    private Object obj;

    //将需要代理的实例通过处理器类的构造方法传递给代理。
    public GamePlayerInvocationHandler(Object obj){
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object result = null;
        if("login".equalsIgnoreCase(method.getName())){
            //这个在主题方法不受任何影响的情况下，在主题方法前后添加新的功能，或者增强主题方法，
            //从侧面切入从而达到扩展的效果的编程，就是面向切面编程(AOP Aspect Oriented Programming)。
            //AOP并不是新技术，而是相对于面向对象编程的一种新的编程思想。在日志，事务，权限等方面使用较多。
            System.out.println("代理登录游戏！");
            result = method.invoke(this.obj, args);
            return result;
        }
        result = method.invoke(this.obj, args);
        return result;
    }

}