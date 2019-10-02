/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.damienevrard.tp4;

import bowling.SinglePlayerGame;
import java.awt.Frame;
import sun.security.util.Length;

/**
 *
 * @author damie
 */
public class MultiplayerBowling implements bowling.MultiPlayerGame {
    
    private SinglePlayerGame players[];
    private String playersName[];
    private int nPlayer;
    private int score;
    private int nbL;
    

    @Override
    public String startNewGame(String[] playerName) throws Exception {
        this.players=new SinglePlayerGame[playerName.length];
        this.playersName=playerName;
        for(int i=0; i< playerName.length;i++){
            this.players[i]=new SinglePlayerGame();
        }
        this.nPlayer=0;
        this.score=0;
        this.nbL=0;
        
        return "partie initialisé avec "+playersName.length+" joueurs";
    }

    @Override
    public String lancer(int nombreDeQuillesAbattues) throws Exception {
        String message="";
        players[nPlayer % players.length].lancer(nombreDeQuillesAbattues);
        if (nombreDeQuillesAbattues==10){
            message="joueur "+playersName[(nPlayer) % players.length]+" a fait un Strike \nprochain joueur "+playersName[(nPlayer+1) % players.length]+"\n";
            nPlayer++;
        }else if(score==10){
            message="joueur "+playersName[(nPlayer) % players.length]+" a fait un Spear \nprochain joueur "+playersName[(nPlayer+1) % players.length]+"\n";
            nPlayer++;
            score=0;
            nbL=0;
        }else if(nbL==1){
            message="joueur "+playersName[(nPlayer) % players.length]+" a fait tomber "+nombreDeQuillesAbattues+" quilles à sa 2eme boule pour un total de "+(score+nombreDeQuillesAbattues)+" \nprochain joueur "+playersName[(nPlayer+1) % players.length]+"\n";
            nPlayer++;
            score=0;
            nbL=0;
            
        }else{
            message="joueur "+playersName[(nPlayer) % players.length]+" a fait tomber "+nombreDeQuillesAbattues+" quillesà sa 1ere boule";
            score+=nombreDeQuillesAbattues;
            nbL+=1;
        }
        
        return message;
    }

    @Override
    public int scoreFor(String playerName) throws Exception {
        int val=0;
        int numPlayer=0;
        for(String name : playersName){
            if (name==playerName){
                val=players[numPlayer].score();
                break;
            }
            numPlayer++;
        }
        return val;
    }
}
