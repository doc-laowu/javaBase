package com.neusoft.MuiltThread;

import java.util.LinkedList;

public class ComsumerProducer01 {

    public static void main(String[] args) {

        int[] arr = {2,345,6768};

        String str = "assagds";
        Storage storage=new Storage();

        for(int i=1;i<6;i++)
        {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    storage.produce(String.format("生成者%d:", finalI));
                }
            }).start();
        }

        for(int i=1;i<4;i++)
        {
            int finalI = i;
            new Thread(()-> storage.consume(String.format("消费者%d:", finalI))).start();
        }
    }

}

class Storage
{
    // 仓库最大存储量
    private final int MAX_SIZE = 100;

    // 仓库存储的载体
    private LinkedList<Object> list = new LinkedList<Object>();

    // 生产产品
    public void produce(String producer) {
        while (true) {
            synchronized (list) {
                // 如果仓库已满
                while (list.size() == MAX_SIZE) {
                    System.out.println("仓库已满，【" + producer + "】： 暂时不能执行生产任务!");
                    try {
                        // 由于条件不满足，生产阻塞
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 生产产品
                list.add(new Object());

                System.out.println("【" + producer + "】：生产了一个产品\t【现仓储量为】:" + list.size());

                list.notifyAll();
            }
        }
    }

    // 消费产品
    public void consume(String consumer)
    {
        while(true){
            synchronized (list) {
                //如果仓库存储量不足
                while (list.size() == 0) {
                    System.out.println("仓库已空，【" + consumer + "】： 暂时不能执行消费任务!");
                    try {
                        // 由于条件不满足，消费阻塞
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                list.remove();
                System.out.println("【" + consumer + "】：消费了一个产品\t【现仓储量为】:" + list.size());
                list.notifyAll();
            }
        }
    }

    public LinkedList<Object> getList()
    {
        return list;
    }

    public void setList(LinkedList<Object> list)
    {
        this.list = list;
    }

    public int getMAX_SIZE()
    {
        return MAX_SIZE;
    }
}