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

    ChooseWinner() {

        int i = 2;
        for (String rank : ranks) {
            RankDict.put(rank, i);
            i++;
        }
        i = 1;
        for (String hand : hands) {
            RankDict.put(hand, i);
            i++;
        }
    }

    player getWinner(List<player> players) {
        List<player> greatestNumbers = new ArrayList<>();
        getHandRank(players);
        int maxNumber = 0;
        for (player p : players) {
            if (p.HandValue > maxNumber) {
                maxNumber = p.HandValue;
                greatestNumbers.clear(); // Clear previous greatest numbers
                greatestNumbers.add(p); // Add the new greatest number
            } else if (p.HandValue == maxNumber) {
                greatestNumbers.add(p); // Add the number with the same value as maxNumber
            }

        }
        if (greatestNumbers.size() > 1) {
            // must compare players who have got same card hand value and check in that who
            // has better cards
        }
        return players.get(0);

    }

    player ComparePlayers(player p1, player p2) {
        // has to compare btw 2 players are return player with better hand , if both
        // have same hand rank

        return p1;
    }

    void getHandRank(List<player> players) {
        for (player p : players) {
            if (checkStrightFlush(p.Hand)) {
                p.HandValue = HandRankDict.get("StraightFlush");
                System.out.println("player has : ");
            } else if (checkFoak(p.Hand)) {
                p.HandValue = HandRankDict.get("FOAK");
                System.out.println("player has : Four of a Kind ");
            } else if (checkFullhouse(p.Hand)) {
                p.HandValue = HandRankDict.get("Fullhouse");
                System.out.println("player has : Fullhouse");
            } else if (checkFlush(p.Hand)) {
                p.HandValue = HandRankDict.get("Flush");
                System.out.println("player has : Flush");
            } else if (checkStright(p.Hand)) {
                p.HandValue = HandRankDict.get("Stright");
                System.out.println("player has : Stright");
            } else if (checkToak(p.Hand)) {
                p.HandValue = HandRankDict.get("TOAK");
                System.out.println("player has : Three of a Kind ");
            } else if (checkTwoPair(p.Hand)) {
                p.HandValue = HandRankDict.get("TwoPair");
                System.out.println("player has : TwoPair");
            } else if (checkPair(p.Hand)) {
                p.HandValue = HandRankDict.get("OnePair");
                System.out.println("player has : OnePair");
            } else {
                p.HandValue = HandRankDict.get("Highcard");
                System.out.println("player has : Highcard");
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
        for (int i = 1; i < card_rank_values.length; i++) {
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
        for (int i = 0; i < card_rank_values.length; i++) {
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
            freq[card_rank_values[i]]++;
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
        for (int i = 1; i < card_rank_values.length; i++) {
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
        for (int i = 0; i < card_rank_values.length; i++) {
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
            freq[card_rank_values[i]]++;
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
            card_rank_values[i] = RankDict.get(c.suit);
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
