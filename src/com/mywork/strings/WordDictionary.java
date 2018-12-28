package com.mywork.strings;

/**
 * @author ManiKanta Kandagatla
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * Given a Paragraph, Construct a dictionary implementing
 * 
 * 1. add method adds a word at position p to the dictionary. We do not distinguish the same word
 * with different cases. You should convert all words to lower cases first.
 * 
 * 
 * 2. toString returns the string representation of the dictionary (see the sample output).
 * 
 * 
 * 3. most method returns the most frequently used word. If there are more than one, then pick the
 * first one.
 * 
 * 
 * 4. print method reconstructs the text that the dictionary is generated from except that all
 * occurrences of the most frequently used word are all capitalized (see the sample output). You
 * don't have to recover commas or periods in the original text. All words are lower cases except
 * the most frequently used word.
 */
public class WordDictionary
{

    public static void main(String[] args)
    {

        String lyrics = "Again and again and again and again\n" +

                "Do it again, do it again\n" +

                "Again and again\n" +

                "It's a shame, it's a shame\n" +

                "It's a perfect shame\n" +

                "Creep under my door and we do it again, oh oh";

        String[] sentences = lyrics.split("\n");

        List<List<String>> words = new ArrayList<>();

        for (String s : sentences)
        {

            String[] ws = s.split(" ");

            List<String> l = new ArrayList<>();

            words.add(l);

            for (String w : ws)
            {

                w = w.replace(",", "").replace(".", "");

                l.add(w);

            }

        }

        Dictionary d = new Dictionary();

        for (int i = 0; i < words.size(); i++)
        {

            List<String> l = words.get(i);

            for (int j = 0; j < l.size(); j++)
            {

                d.add(l.get(j), new Position(i, j));

            }

        }
        System.out.println(d);

        System.out.println("most frequent word: " + d.most() + "\n");

        System.out.println(d.print());

    }

}

class Position
{

    // x is line position, and y is word position in a line

    final int x, y;

    Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public String toString()
    {
        return "(" + x + "," + y + ")";
    }

}

class Dictionary
{

    private Map<String, List<Position>> map = new HashMap<>();

    // add a word at position p to this dictionary

    void add(String word, Position p)
    {
        // Word not in dictionary
        word = word.toLowerCase();
        if (this.map.get(word) == null)
        {
            // create a new position list for the word as it is not in dictionary
            List<Position> positions = new ArrayList<>();
            positions.add(p);
            this.map.put(word, positions);
        }
        // word in dictionary
        else
        {
            // add the new position to the existing position list of the word
            this.map.get(word).add(p);
        }

    }

    // return the string representation of the dictionary

    public String toString()
    {
        return this.map.toString().replaceAll("[{}]", "").replace("=", " ").replace("], ", "]\n");
    }

    // return the most frequently used word

    public String most()
    {
        int mostCount = 0, tempCount = 0;
        String mostFrequentWord = null;
        for (String word : this.map.keySet())
        {
            tempCount = this.map.get(word).size();
            if (tempCount > mostCount)
            {
                mostCount = tempCount;
                mostFrequentWord = word;
            }
        }
        return mostFrequentWord;
    }

    // return the paragraph that the dictionary is generated from

    // with the most frequently used word capitalized
    public String print()
    {
        String paragraph = "";
        TreeMap<Position, String> reverseLookup = new TreeMap<Position, String>(
                new Comparator<Position>()
                {
                    @Override
                    public int compare(Position a, Position b)
                    {
                        if (a.x == b.x)
                            return a.y - b.y;
                        return a.x - b.x;
                    }
                });
        for (String word : this.map.keySet())
        {
            for (Position p : this.map.get(word))
            {
                reverseLookup.put(p, word);
            }
        }
        String mostFrequentWord = most();
        for (String word : reverseLookup.values())
        {
            if (mostFrequentWord.equals(word))
            {
                paragraph = paragraph + " " + word.toUpperCase();
            }
            else
                paragraph = paragraph + " " + word;
        }
        return paragraph;
    }
}