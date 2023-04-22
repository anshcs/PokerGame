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

    @Autowired
    private JdbcTemplate JdbcTemplate;

    @GetMapping("/")
    public String greetingForm(Model model) {
        model.addAttribute("player", new player());
        return "Login";
    }

    @PostMapping("/")
    public String greetingSubmit(@ModelAttribute player player, Model model) {
        PlayerList.add(player);
        player comp = new player();
        PlayerList.add(comp);
        
        // Pokesh game = new Pokesh(2);
        game.setPlayers(PlayerList);
        game.setNo_players(2);
        // game
        game.StartGame();
        model.addAttribute("player", player);

        return "display";
    }

    @GetMapping("/startgame")
    public String CheckStart(@RequestParam("p") String p,Model model) {
        System.out.println(p);
        player player = new player();
        player.setName(p);
        model.addAttribute("player", player);
        return "startgame";
    }

}
