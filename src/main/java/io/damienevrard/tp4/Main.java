/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.damienevrard.tp4;

/**
 *
 * @author damie
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String players[] = {"Pierre","Paul","Jack"};
       MultiplayerBowling game = new MultiplayerBowling();
       try{
           System.out.println(game.startNewGame(players));
           for(int i =0;i<36;i++){
               System.out.println(game.lancer(10));
           }
           System.out.println("pierre "+game.scoreFor("Pierre"));
           System.out.println("paul "+game.scoreFor("Paul"));
           System.out.println("jack "+game.scoreFor("Jack"));
       }catch(Exception e){
           
       }
               
    }
    
}
