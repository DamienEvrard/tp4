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
    
    

    @Override
    public String startNewGame(String[] playerName) throws Exception {
        this.players=new SinglePlayerGame[playerName.length];
        this.playersName=playerName;
        for(int i=0; i< playerName.length;i++){
            this.players[i]=new SinglePlayerGame();
        }
        this.nPlayer=0;
        
        return "partie initialisé avec "+playersName.length+" joueurs";
    }

    @Override
    public String lancer(int nombreDeQuillesAbattues) throws Exception {
        String message="";
        players[nPlayer % players.length].lancer(nombreDeQuillesAbattues);
        if (nombreDeQuillesAbattues==10){
            message="joueur "+playersName[(nPlayer-1) % players.length]+" a fait unStrike";
            nPlayer++;
        }/*else if(players[nPlayer % players.length]){
            
        }*/
        
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
