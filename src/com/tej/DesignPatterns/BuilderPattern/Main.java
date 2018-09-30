package com.tej.DesignPatterns.BuilderPattern;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount
                .BankAccountBuilder("Ricky","1212981729")
                //.withEmail("tharangd95@gmail.com")
               // .wantNewsLetter(true)
                .build();
        bankAccount.print();
    }
}
