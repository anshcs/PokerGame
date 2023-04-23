package com.example.OOadp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @Autowired
    Pokesh game;

    int pot = 0 ;

    

    @GetMapping("/game/pot")
    public int getPot() {
        // game.table.Pot = 0;
        return game.table.Pot;
    }

    @GetMapping("/game/bet")
    public void PlacedBet(@RequestParam String id,@RequestParam String Betamt){
        int i = Integer.parseInt(id);
        // game.Players.get(i);
        int BetAmount =  Integer.parseInt(Betamt);
        game.Players.get(i).setIsturn(false);
        game.table.Pot = game.table.Pot + game.Players.get(i).Bet(BetAmount);
    }

    @GetMapping("/game/fold")
    public String PlayerFold(){
       player  p = game.Players.get(0);
        return p.getName();
    }

    @GetMapping("/game/turn")
    public String CheckTurn(@RequestParam String id){

        int i = Integer.parseInt(id);
        // System.out.println("turn of "+game.Players.get(i).name);
        if (game.Players.get(i).isturn){
            return "true";
        }
        else{return "false";}

        
    }

    



    

    

    // other request mappings for your application
}