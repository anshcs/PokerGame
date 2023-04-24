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
    public String PlacedBet(@RequestParam String id,@RequestParam String Betamt){
        int i = Integer.parseInt(id);
        // game.Players.get(i);
        int BetAmount =  Integer.parseInt(Betamt);
        if(game.Players.get(i).isturn){
            if (BetAmount>game.table.MinBet){
                System.out.println(game.Players.get(i).name + "isturn : "+ game.Players.get(i).isturn );
                game.Players.get(i).setIsturn(false);
                game.table.MinBet = BetAmount;
                game.table.Pot = game.table.Pot + game.Players.get(i).Bet(BetAmount);
                System.out.println(game.Players.get(i).name + "isturn : "+ game.Players.get(i).isturn );
                game.Players.get(i).setIsturn(false);
                return "true";
            }
            else{
                System.out.println(game.Players.get(i).name + "isturn1 : "+ game.Players.get(i).isturn );
                return "false";
            }
        }
        else{
            System.out.println(game.Players.get(i).name + "isturn2 : not his chance  "+ game.Players.get(i).isturn );
            return "not";
        }
        
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
        else{
            return "false";
    }
    }

    @GetMapping("/game/amount")
    public String ShowAmount(@RequestParam String id){
        int i = Integer.parseInt(id);
        String amount = Integer.toString(game.Players.get(i).Amount);
        return amount;


    }

    @GetMapping("/game/minbet")
    public String ShowMinBet(){
        String minbet = Integer.toString(game.table.MinBet);
        return minbet;
    }

    



    

    

    // other request mappings for your application
}