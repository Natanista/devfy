package br.com.devfy.devfy.model;

public class SlackService  implements Notificacao{

    public void notificarEmpresa(){
        System.out.println("Slack bot: Nova ação relacionada a sua empresa!");
    }


    public  void notificarCliente(){
        System.out.println("Slack bot: Nova ação relacionada a você!");

    }
}
