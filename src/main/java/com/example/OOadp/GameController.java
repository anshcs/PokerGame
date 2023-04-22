package com.example.OOadp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public void PlacedBet(){
        game.table.Pot = game.table.Pot + 1;
    }
    @GetMapping("/game/fold")
    public String PlayerFold(){
       player  p = game.Players.get(0);
        return p.getName();
    }

    

    

    // other request mappings for your application
}