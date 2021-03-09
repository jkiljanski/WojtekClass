package com.sciamus;

public class LambdaFun {

    public LambdaFun() {
    }

    public void execute(String blabla){

        System.out.println("Does:");
        System.out.println(blabla);
    }

    public void execute(DoSomething doSomething){

        doSomething.execute();
    }

    public void execute(DoSomethingWithArg doSomethingWithArg, String arg){

        doSomethingWithArg.doSomething(arg);
    }


    private String getNoise() {
        return "Waaaaaaa";
    }

    public void bark(){
        System.out.println("Bark! Bark!");
    }

    private void callBee() {
        System.out.println("Beeeeee");
    }


    public DoSomething getBeeeeee() {
        return () -> callBee();
    }

    public static void main(String[] args) {

        LambdaFun lambdaFun = new LambdaFun();

        //lambdaFun.execute(lambdaFun.getNoise());




        lambdaFun.execute(new Shout());

        DoSomething beeeeee = lambdaFun.getBeeeeee();
        DoSomething ceeeeee = new DoSomething(){

            @Override
            public void execute() {
                System.out.println("Ceeeeeee");
            }
        };

        lambdaFun.execute(beeeeee);
        lambdaFun.execute(ceeeeee);

        lambdaFun.execute(lambdaFun::bark);
        lambdaFun.execute(lambdaFun::callBee);

        DoSomethingWithArg doSomethingWithArg = s -> System.out.println(s);
        lambdaFun.execute(doSomethingWithArg, "krowa");

    }


}
