package com.tej.DesignPatterns.BuilderPattern;

public class BankAccount {
    private String name;
    private String number;
    private String email;
    private boolean newsletter;

    private BankAccount(BankAccountBuilder bankAccountBuilder){
        this.name = bankAccountBuilder.name;
        this.email = bankAccountBuilder.email;
        this.number = bankAccountBuilder.number;
        this.newsletter = bankAccountBuilder.newsletter;
    }

    public void print(){
        System.out.print("Name      :" + this.name);
        System.out.print("Number    :" + this.number);
        System.out.print("Email     :" + this.email);
        System.out.print("Newsletter :" + this.newsletter);
    }
    public static class BankAccountBuilder{
        private String name;
        private String number;
        private String email;
        private boolean newsletter;

        public BankAccountBuilder(String name, String number){
            this.name = name;
            this.number = number;
        }

        public BankAccountBuilder withEmail(String email){
            this.email = email;
            return this;
        }

        public BankAccountBuilder wantNewsLetter(boolean newsletter){
            this.newsletter = newsletter;
            return this;
        }

        public BankAccount build(){
            return new BankAccount(this);
        }
    }
}
