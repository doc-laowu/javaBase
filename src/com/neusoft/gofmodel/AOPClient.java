package com.neusoft.gofmodel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AOPClient {

    public static void main(String[] args) {

        Subject realSubject = new RealSubject();
        InvocationHandler handler = new MyInvocationHandler(realSubject);
        ClassLoader classLoader = realSubject.getClass().getClassLoader();
        Class<?>[] interfaces = realSubject.getClass().getInterfaces();
        Subject proxySubect = DynamicProxy.newProxyInstance(classLoader, interfaces, handler);
        proxySubect.doSomething("这是一个Dynamic AOP示例！！！");

    }

}

interface Subject {
    public void doSomething(String str);
    //...可以多个逻辑处理方法。。。
}

class RealSubject implements Subject{

    public void doSomething(String str) {
        //do something...
        System.out.println("do something..." + str);
    }

}

//通知接口及定义、
interface IAdvice {
    public void exec();
}

class BeforeAdvice implements IAdvice {
    //在被代理的方法前来执行，从而达到扩展功能。
    public void exec() {
        System.out.println("前置通知被执行！");
    }
}

class AfterAdvice implements IAdvice {

    //在被代理的方法后来执行，从而达到扩展功能。
    public void exec() {
        System.out.println("后置通知被执行！");
    }
}

class MyInvocationHandler implements InvocationHandler {

    //被代理的对象
    private Subject realSubject;
    //通过MyInvocationHandler的构造方法将被代理对象传递过来。
    public MyInvocationHandler(Subject realSubject){
        this.realSubject = realSubject;
    }
    //执行被代理类的方法。
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在执行方法前，执行前置通知。
        IAdvice beforeAdvice = new BeforeAdvice();
        beforeAdvice.exec();
        Object result = method.invoke(this.realSubject, args);
        //在执行方法后，执行后置通知。
        IAdvice afterAdvice = new AfterAdvice();
        afterAdvice.exec();
        //前置通知，和后置通知，都是要看具体实际的业务需求来进行添加。
        return result;
    }

}

class DynamicProxy {

    /**
     * public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,InvocationHandler handler)
     * loader：
     *             一个ClassLoader对象，定义了由哪个ClassLoader对象，来对生产的代理进行加载。
     * interfaces：
     *             一个Interfaces数组，表示我将要给我所代理的对象提供一组什么样的接口，
     *             如果提供一组接口给它，那么该代理对象就宣称实现了该接口，从而可以调用接口中的方法。
     *             即，查找出真是主题类的所实现的所有的接口。
     * handler：
     *             一个InvocationHandler对象，表示当我这个动态代理对象在调用方法时，会关联到该InvocationHandler对象。
     *             该InvocationHandler与主题类有着关联。
     */
    public static <T> T newProxyInstance(ClassLoader classLoader, Class<?>[] interfaces, InvocationHandler handler){
        @SuppressWarnings("unchecked")
        T t = (T) Proxy.newProxyInstance(classLoader, interfaces, handler);
        return t;
    }
}






















