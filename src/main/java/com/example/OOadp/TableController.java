package com.example.OOadp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TableController {

    @Autowired
    Pokesh game;

    @GetMapping("/table/Flop1rank")
    public String Flop1rank(){
        return game.table.Flop1rank;
    }

    @GetMapping("/table/Flop2rank")
    public String Flop2rank(){
        return game.table.Flop2rank;
    }

    @GetMapping("/table/Flop3rank")
    public String Flop3rank(){
        return game.table.Flop3rank;
    }

    @GetMapping("/table/Flop1suit")
    public String Flop1suit(){
        return game.table.Flop1suit;
    }

    @GetMapping("/table/Flop2suit")
    public String Flop2suit(){
        return game.table.Flop2suit;
    }

    @GetMapping("/table/Flop3suit")
    public String Flop3suit(){
        return game.table.Flop3suit;
    }
    @GetMapping("/table/Turnsuit")
    public String Turnsuit(){
        return game.table.turnsuit;
    }
    @GetMapping("/table/Turnrank")
    public String Turnrank(){
        return game.table.turnrank;
    }
    @GetMapping("/table/Riversuit")
    public String Riversuit(){
        return game.table.riversuit;
    }
    @GetMapping("/table/Riverrank")
    public String Riverrank(){
        return game.table.riverrank;
    }


    // for player cards on table 
    @GetMapping("/player/Hole1suit")
    public String Hole1suit(@RequestParam String id){
        int i = Integer.parseInt(id);

        return game.Players.get(i).card1Suit;
    }
    @GetMapping("/player/Hole2suit")
    public String Hole2suit(@RequestParam String id){
        int i = Integer.parseInt(id);

        return game.Players.get(i).card2Suit;
    }
    @GetMapping("/player/Hole1rank")
    public String Hole1rank(@RequestParam String id){
        int i = Integer.parseInt(id);

        return game.Players.get(i).card1Value;
        // return id;
    }

    @GetMapping("/player/Hole2rank")
    public String Hole2rank(@RequestParam String id){
        int i = Integer.parseInt(id);

        return game.Players.get(i).card2Value  ;
        
    }


    
}
