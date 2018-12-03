package com.neusoft.gofmodel;

public class proxyModel {

    public static void main(String[] args) {

        BuyHouseProxy bp = new BuyHouseProxy(new BuyHouseImpl());
        bp.buyHosue();
    }

}

interface BuyHouse{

    void buyHosue();

}

class BuyHouseImpl implements BuyHouse{

    @Override
    public void buyHosue() {
        System.out.println("买房子");
    }
}

class BuyHouseProxy implements BuyHouse{

    private BuyHouse by;

    public BuyHouseProxy(BuyHouse by) {
        this.by = by;
    }

    @Override
    public void buyHosue() {
        System.out.println("我是代理中介代理你去买房...");
        by.buyHosue();
        System.out.println("代理中介买完房子...");
    }
}