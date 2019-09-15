package com.tej.DesignPatterns.BuilderPattern.CoffeeShop;

public class CoffeeShopAccount {
    public String name;
    public String email;
    public String number;
    public boolean news;
    public CoffeeShopAccount(CoffeeShopAccountBuilder builder){
        this.name = builder.name;
        this.email = builder.email;
        this.number = builder.number;
        this.news = builder.news;
    }


    public static class CoffeeShopAccountBuilder{
        public String name;
        public String email;
        public String number;
        public boolean news;

        public CoffeeShopAccountBuilder(String name, String email){
            this.name = name;
            this.email = email;
        }

        public CoffeeShopAccountBuilder withNumber(String number){
            this.number = number;
            return this;
        }

        public CoffeeShopAccountBuilder wantNews(){
            this.news = true;
            return this;
        }

    }

}
