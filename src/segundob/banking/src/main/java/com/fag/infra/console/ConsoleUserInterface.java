package com.fag.infra.console;

import java.util.Scanner;

import com.fag.domain.repositories.IUserInterface;

public class ConsoleUserInterface implements IUserInterface{

    private Scanner input = new Scanner(System.in);

    @Override
    public Integer showInitialScreenMenu() {
        System.out.println("==========BANCO PIKA==========\n");
        System.out.println("[1] Login\n");
        System.out.println("[2] Cadastro\n");
        System.out.println("[3] Sair\n");

        //return 1;
        Integer escolha = input.nextInt();
        
        return escolha;
    }
    

}
