package temp;

import spired.test;

import java.util.*;

public class Test03 {
    enum Suit{CLUB,DIAMOND,HEART,SPADE}
    enum Rank{ACE,DEUCE,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING}
    enum Face{ONE,TWO,THREE,FOUR,FIX,SIX}
    static class Card{
        Suit suit;
        Rank rank;
        public Card(){

        }

        public Card(Suit suit, Rank rank) {
            this.suit=suit;
            this.rank=rank;
        }

        @Override
        public String toString() {
            return suit.toString()+","+rank.toString();
        }
    }
    public static void main(String[] args) {
        /*int[] num={1,2,3,4,5};
        for(int n:num){
            System.out.println(n);

        }*/

        Collection<Suit> suits= Arrays.asList(Suit.values());
        Collection<Rank> ranks= Arrays.asList(Rank.values());
        List<Card> deck=new ArrayList<>();
        for(Suit suit:suits){
            for(Rank rank:ranks){
                deck.add(new Card(suit,rank));
            }
        }
//        for(Iterator<Suit> i=suits.iterator();i.hasNext();){
//            for(Iterator<Rank> j=ranks.iterator(); j.hasNext();){
//                deck.add(new Card(i.next(),j.next()));
//            }
//        }
        for(Card card:deck){
            System.out.println(card.toString());
        }


    }
}
