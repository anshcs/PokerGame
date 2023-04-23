package com.example.OOadp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.*;

@Controller
public class PlayerController {

    List<player> PlayerList = new ArrayList<player>();
    @Autowired
    Pokesh game;
    int i = 0;

    @Autowired
    private JdbcTemplate JdbcTemplate;

    @GetMapping("/")
    public String greetingForm(Model model) {
        model.addAttribute("player", new player());
        // player comp = new player();
        // PlayerList.add(comp);
        return "Login";
    }

    @PostMapping("/")
    public String greetingSubmit(@ModelAttribute player player, Model model) {

        if (PlayerList.size() == 2){
            GameThread myThread = new GameThread();
            Thread thread = new Thread( myThread);
            thread.start();
        }

        else if(PlayerList.size() > 2){
            return "tableFull";
        }
        
        PlayerList.add(player);
        
        player.setId(i);
        i = i+ 1;
        // Pokesh game = new Pokesh(2);
        game.setPlayers(PlayerList);
        game.setNo_players(PlayerList.size());
        // game
        // game.StartGame();
        model.addAttribute("player", player);

        
        // should display the cards on table contineously
        // when another tab is opened then it deals more cards and has a new player some
        // how have to figure out how to pass other player as para for fold
        //  pot value keeps changing as the game is a component and shows all the time 

        return "trialDisplay";
    }
    public class  GameThread implements Runnable{

        @Override
        public void run(){

            game.StartGame();
            

        }

    }
    

}
