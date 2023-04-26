package com.example.OOadp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class ChooseWinner {

    String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
    String[] hands = { "Highcard", "OnePair", "TwoPair", "TOAK", "Stright", "Flush", "Fullhouse", "FOAK",
            "StraightFlush" };
    HashMap<String, Integer> RankDict = new HashMap<String, Integer>();
    HashMap<String, Integer> HandRankDict = new HashMap<String, Integer>();
    Table t ; 
    List<player> players;
    player winner;
    

    ChooseWinner(Table t,List<player> players) {

        int i = 2;
        for (String rank : ranks) {
            RankDict.put(rank, i);
            i++;
        }
        i = 1;
        for (String hand : hands) {
            HandRankDict.put(hand, i);
            i++;
        }
        this.t = t;
        this.players = players;
    }

    player getWinner(List<player> players) {

        List<player> greatestNumbers = new ArrayList<player>();
        greatestNumbers.addAll( this.players);
        for (player p :players){
            System.out.println(p);
        }
        getHandRank(this.players,this.t);
        int maxNumber = 0;
        for (player p : greatestNumbers) {
            System.out.println(p.HandValue+ " hand value greater ");
            if (p.HandValue > maxNumber) {
                System.out.println(p.HandValue+ " hand value greater ");
                maxNumber = p.HandValue;
                winner = p;
                System.out.println(winner.name);
                 // Clear previous greatest numbers
                // greatestNumbers.add(p); // Add the new greatest number
            } 

        }
        System.out.println(winner.name);
        // if (greatestNumbers.size() > 1) {
        //     // must compare players who have got same card hand value and check in that who
        //     // has better cards
        // }
        return winner;

    }

    player ComparePlayers(player p1, player p2) {
        // has to compare btw 2 players are return player with better hand , if both
        // have same hand rank

        return p1;
    }

    void getHandRank(List<player> players,Table table) {


        for (player p : players) {

            ArrayList<card> combine_deck = new ArrayList<card>();
            (combine_deck).addAll(table.table_Deck);
            combine_deck.addAll(p.Hand);
            System.out.println(p.name);
            if (checkStrightFlush(combine_deck)) {
                p.HandValue = HandRankDict.get("StraightFlush");
                System.out.println("player has : "+p.HandValue);
            } else if (checkFoak(combine_deck)) {
                p.HandValue = HandRankDict.get("FOAK");
                System.out.println("player has : Four of a Kind "+p.HandValue);
            } else if (checkFullhouse(combine_deck)) {
                p.HandValue = HandRankDict.get("Fullhouse");
                System.out.println("player has : Fullhouse"+p.HandValue);
            } else if (checkFlush(combine_deck)) {
                p.HandValue = HandRankDict.get("Flush");
                System.out.println("player has : Flush"+p.HandValue);
            } else if (checkStright(combine_deck)) {
                p.HandValue = HandRankDict.get("Stright");
                System.out.println("player has : Stright"+p.HandValue);
            } else if (checkToak(combine_deck)) {
                p.HandValue = HandRankDict.get("TOAK");
                System.out.println("player has : Three of a Kind "+p.HandValue);
            } else if (checkTwoPair(combine_deck)) {
                p.HandValue = HandRankDict.get("TwoPair");
                System.out.println("player has : TwoPair"+p.HandValue);
            } else if (checkPair(p.Hand)) {
                p.HandValue = HandRankDict.get("OnePair");
                System.out.println("player has : OnePair"+p.HandValue);
            } else {
                p.HandValue = HandRankDict.get("Highcard");
                System.out.println("player has : Highcard"+p.HandValue);
            }
        }

    }

    boolean checkStrightFlush(ArrayList<card> deck) {
        // first check if all the suits are same
        String common_suit = deck.get(0).suit;
        for (card c : deck) {
            if (c.suit.equals(common_suit)) {
                continue;
            } else {
                return false;
            }
        }
        int[] card_rank_values = getCardRanks(deck);
        // check for 5 consecutive cards out of the 7 cards
        int sequenceLength = 1;
        for (int i = 1; i < card_rank_values.length-1; i++) {
            if (card_rank_values[i] - card_rank_values[i - 1] == 1) {
                sequenceLength++;
                if (sequenceLength == 5) {
                    return true;
                }
            } else {
                sequenceLength = 1;
            }
        }

        // If no 5 consecutive numbers found, return false
        return false;
    }

    boolean checkFoak(ArrayList<card> deck) {

        int[] card_rank_values = getCardRanks(deck);
        for (int i = 0; i < card_rank_values.length-1; i++) {
            int count = 0; // initialize a count variable to 0
            for (int j = i + 1; j < card_rank_values.length; j++) {
                if (card_rank_values[i] == card_rank_values[j]) {
                    count++; // increment the count if a repeating number is found
                }
            }
            if (count >= 3) { // if at least 4 repeat numbers are found, set the flag to true and break out of
                              // the loop
                return true;

            }
        }

        return false;
    }

    boolean checkFullhouse(ArrayList<card> deck) {
        int[] card_rank_values = getCardRanks(deck);
        // Create a frequency map of the card numbers using an array
        int[] freq = new int[14];
        for (int i = 0; i < 7; i++) {
            freq[card_rank_values[i]-1]++;
        }

        boolean hasThreeOfAKind = false;
        boolean hasTwoPair = false;

        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 3) {
                hasThreeOfAKind = true;
            } else if (freq[i] == 2) {
                if (hasTwoPair) { // Check if we already found a pair
                    hasTwoPair = false;
                    break;
                } else {
                    hasTwoPair = true;
                }
            }
        }

        if (hasThreeOfAKind && hasTwoPair) {
            return true;
        } else {
            return false;
        }
    }

    boolean checkFlush(ArrayList<card> deck) {
        String common_suit = deck.get(0).suit;
        for (card c : deck) {
            if (c.suit.equals(common_suit)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    boolean checkStright(ArrayList<card> deck) {
        int[] card_rank_values = getCardRanks(deck);
        // check for 5 consecutive cards out of the 7 cards
        int sequenceLength = 1;
        for (int i = 1; i < card_rank_values.length-1; i++) {
            if (card_rank_values[i] - card_rank_values[i - 1] == 1) {
                sequenceLength++;
                if (sequenceLength == 5) {
                    return true;
                }
            } else {
                sequenceLength = 1;
            }
        }

        // If no 5 consecutive numbers found, return false
        return false;

    }

    boolean checkToak(ArrayList<card> deck) {
        int[] card_rank_values = getCardRanks(deck);
        for (int i = 0; i < card_rank_values.length-1; i++) {
            int count = 0; // initialize a count variable to 0
            for (int j = i + 1; j < card_rank_values.length; j++) {
                if (card_rank_values[i] == card_rank_values[j]) {
                    count++; // increment the count if a repeating number is found
                }
            }
            if (count >= 2) { // if at least 3 repeat numbers are found, set the flag to true and break out of
                              // the loop
                return true;

            }
        }

        return false;
    }

    boolean checkTwoPair(ArrayList<card> deck) {
        int[] card_rank_values = getCardRanks(deck);
        // Create a frequency map of the card numbers using an array
        int[] freq = new int[14];
        for (int i = 0; i < 7; i++) {
            freq[card_rank_values[i]-1]++;
        }

        boolean hasTwoPairs = false;

        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 2) {
                if (hasTwoPairs) { // Check if we already found two pairs
                    hasTwoPairs = false;
                    break;
                } else {
                    hasTwoPairs = true;
                }
            }
        }
        if (hasTwoPairs) {
            return true;
        } else {
            return false;
        }
    }

    boolean checkPair(ArrayList<card> deck) {
        int[] card_rank_values = getCardRanks(deck);
        for (int i = 0; i < card_rank_values.length; i++) {
            int count = 0; // initialize a count variable to 0
            for (int j = i + 1; j < card_rank_values.length; j++) {
                if (card_rank_values[i] == card_rank_values[j]) {
                    count++; // increment the count if a repeating number is found
                }
            }
            if (count >= 1) { // if at least 3 repeat numbers are found, set the flag to true and break out of
                              // the loop
                return true;

            }
        }

        return false;
    }

    int[] getCardRanks(ArrayList<card> deck) {
        int[] card_rank_values = new int[7];
        int i = 0;
        for (card c : deck) {
            card_rank_values[i] = RankDict.get(c.value);
            i++;
        }
        Arrays.sort(card_rank_values);

        return card_rank_values;

    }

    // public static void main(String[] args) {
    // ChooseWinner c = new ChooseWinner();
    // for (String rank : c.ranks) {
    // System.out.println(rank + " " + c.RankDict.get(rank));
    // }
    // //
    // }

}
