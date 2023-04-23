package com.example.OOadp;

import java.util.*;

public class Dealer {
    int no_players;
    // deck dealer_Deck = new deck(52);
    Table t1; // every dealer dels to a particular table
    ArrayList<card> dealer_Deck = new ArrayList<card>();
    String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
    String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };

    Dealer(int no_players, Table t1) {
        this.no_players = no_players;
        this.t1 = t1;
        for (String rank : ranks) {
            for (String suit : suits) {
                dealer_Deck.add(new card(suit, rank));
            }
        }

    }

    // shuffles the deck
    void ShuffleDeck() {
        Collections.shuffle(dealer_Deck);
    }

    // deals card to a given deck d
    // card Deal(deck d) this is correct for temp commented
    void Deal(ArrayList<card> d) {
        card c = dealer_Deck.get(dealer_Deck.size() - 1);
        dealer_Deck.remove(dealer_Deck.size() - 1);
        d.add(c);
        // return c ;
        

        // must include as dealer will directly deal cards to a deck
        // return c; // temp return card to see if the dealing feature is working
    }

    // burns he cards or removes the top most card
    void Burn() {
        dealer_Deck.remove(dealer_Deck.size() - 1);
    }

    // void Flop(Table t) {
    // card flop1 = dealer_Deck.RemoveCards();
    // card flop2 = dealer_Deck.RemoveCards();
    // card flop3 = dealer_Deck.RemoveCards();
    // t.addFlop(flop1);
    // t.addFlop(flop2);
    // t.addFlop(flop3);

    // }

    // void Turn(Table t) {
    // card turn = dealer_Deck.RemoveCards();
    // t.addTurn(turn);
    // }

    // void River(Table t) {
    // card river = dealer_Deck.RemoveCards();
    // t.addRiver(river);
    // }
}
