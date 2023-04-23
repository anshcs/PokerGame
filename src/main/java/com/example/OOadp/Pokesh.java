package com.example.OOadp;

import java.util.*;

import org.springframework.stereotype.Component;


@Component
public class Pokesh {
    static public int MinBet = 25;
    static public int RiseMultiple = 2;
    int currentBet = MinBet;
    Table table;
    Dealer dealer;
    int no_players;
    List<player> Players = new ArrayList<player>();
    Scanner sc = new Scanner(System.in);

    public int getNo_players() {
        return no_players;
    }

    public void setNo_players(int no_players) {
        this.no_players = no_players;
    }

    public List<player> getPlayers() {
        return Players;
    }

    public void setPlayers(List<player> players) {
        Players = players;
    }

    

    

    public Pokesh() {
        this.table = new Table(0);
        this.dealer = new Dealer(2, this.table);
        dealer.ShuffleDeck();
    }

    Pokesh(int no_players) {
        // this.Players = Players;
        this.no_players = no_players;
        this.table = new Table(0);
        this.dealer = new Dealer(2, this.table);
        dealer.ShuffleDeck();
        // setPlayers();

    }

    // void setPlayers() {
    // // Scanner sc = new Scanner(System.in);
    // for (int i = 0; i < this.no_players; i++) {
    // String playerName;
    // System.out.println("enter the player name ");
    // playerName = sc.next();
    // Players.add(new player());
    // System.out.println("enter the the amount of money this player has ");
    // int amount = sc.nextInt();
    // Players.get(i).addAmount(amount);

    // }
    // }
    // // sc.close();
    // for (player p : Players) {
    // p.DisplayAmount();
    // }
    // }

    // Constantly display the betting options to the player , if isturn is false
    // then
    // pop up cannot bet wait for turn then change the betting algorithm to help
    // adjust to this "ISTURN" mehanism
    void PlaceBet(List<player> Players, Table t) {
        // Scanner sc = new Scanner(System.in);
        boolean isBetting;
        for (player p : Players) {
            // isBetting = true;
            p.setIsturn(true);
            while (p.isturn) { 

                
                
                // checks whether a player has finished placing his bets
                // The choice part can be shown contineously on the screen, if player turn is
                // true he can access and use the choices , for each choice create mapping that
                // alters the pot value or player playing r not for fold condn
                // once a single player finishes an action make isturn false so that he while
                // loop ends and the next players isturn is true and repeat
                // also cotineously show the table cards so after every ettinng round how pot
                // gets updated evey second update table cards
                // if (p.isPlaying) { // checks wehter player is playing or not
                //     String ans;
                //     System.out.println("would you like to place a bet? " + p.name + "\ny/n");
                //     ans = sc.next();
                //     System.out.println(ans);
                //     // String ans = "yes";
                //     if (ans.equals("y")) {
                //         System.out.println("how much would you list to bet? " + p.name + "\nCurrent bet :" + currentBet
                //                 + " 1:Call 2:Raise 3:Custom 4:Check"); // can place same amount as current bet or can
                //                                                        // raise if
                //         // raised then the previous players have to match raised
                //         // amount that functionality must be added must add
                //         // check functionality also
                //         int choice = sc.nextInt();
                //         if (choice == 1) {
                //             int amt = p.Bet(currentBet);
                //             t.addPot(amt);
                //             if (amt > currentBet)
                //                 currentBet = amt;
                //             {
                //             }

                //             isBetting = false;
                //         } else if (choice == 2) {
                //             int amt = p.Bet(currentBet * RiseMultiple);
                //             t.addPot(amt);
                //             if (amt > currentBet) {
                //                 currentBet = amt;
                //             }

                //             isBetting = false;
                //         } else if (choice == 3) {
                //             System.out.println("How much would you like to bet " + "Current bet : " + currentBet);
                //             int amt = sc.nextInt();
                //             if (amt > currentBet * RiseMultiple) {
                //                 t.addPot(p.Bet(amt));
                //                 if (amt > currentBet) {
                //                     currentBet = amt;
                //                 }
                //                 isBetting = false;
                //             } else {
                //                 System.out.println("enter amount greater than : " + currentBet * RiseMultiple);
                //             }

                //         } else if (choice == 4) {
                //             isBetting = false;

                //         }
                //     } else if (ans.equals("n")) {
                //         p.fold();
                //         isBetting = false;
                //         // player chooses to not bet that round and folds
                //     }

                // } else {
                //     isBetting = false;
                //     // p.isPlaying = false;
                // }
            }
            displayPot(t); // displays pot after every round of betting

        }
        // sc.close();

    }

    void displayPot(Table t) {
        System.out.println("Current pot size : " + t.Pot);
    }

    void HoleCards(List<player> Players, Dealer dealer) {
        for (player p : Players) {
            dealer.Deal(p.Hand);
            dealer.Deal(p.Hand);
            p.DisplayHand();
            p.Set_cards();
        }
    }

    void Flop(Table table, Dealer dealer) {
        

        dealer.Burn();

        for (int i = 0; i < 3; i++) {
            dealer.Deal(table.table_Deck);
        }
        table.setFlop1rank(table.table_Deck.get(0).value);
        table.setFlop1suit(table.table_Deck.get(0).suit);
        table.setFlop2rank(table.table_Deck.get(1).value);
        table.setFlop2suit(table.table_Deck.get(1).suit);
        table.setFlop3rank(table.table_Deck.get(2).value);
        table.setFlop3suit(table.table_Deck.get(2).suit);
        showFlop(table);
    }

    void showFlop(Table table) {
        table.DisplayDeck();
    }

    void Turn(Table table, Dealer dealer) {
        dealer.Burn();
        dealer.Deal(table.table_Deck);
        table.setTurnrank(table.table_Deck.get(3).value);
        table.setTurnsuit(table.table_Deck.get(3).suit);
        showTurn(table);
    }

    void showTurn(Table table) {
        table.DisplayDeck();
    }

    void River(Table table, Dealer dealer) {
        dealer.Burn();
        dealer.Deal(table.table_Deck);
        table.setRiverrank(table.table_Deck.get(4).value);
        table.setRiversuit(table.table_Deck.get(4).suit);
        showTurn(table);
    }

    void showRiver(Table table) {
        table.DisplayDeck();
    }

    void StartGame() {

        // Pokesh game1 = new Pokesh(3);
        // System.out.println("curretn cards with the dealer : \n");
        // for (int i = 0; i < game1.dealer.dealer_Deck.size(); i++) {
        // System.out.println(
        // game1.dealer.dealer_Deck.get(i).value + " of " +
        // game1.dealer.dealer_Deck.get(i).suit + "\n");
        // }
        this.HoleCards(this.Players, this.dealer);
        this.PlaceBet(this.Players, this.table);
        this.Flop(this.table, this.dealer);
        // this.PlaceBet(this.Players, this.table);
        this.Turn(this.table, this.dealer);
        // this.PlaceBet(this.Players, this.table);
        this.River(this.table, this.dealer);
        // this.PlaceBet(this.Players, this.table);

        // for (int i = 0; i < game1.dealer.dealer_Deck.size(); i++) {
        // System.out.println(
        // game1.dealer.dealer_Deck.get(i).value + " of " +
        // game1.dealer.dealer_Deck.get(i).suit + "\n");
        // }

    }

}
