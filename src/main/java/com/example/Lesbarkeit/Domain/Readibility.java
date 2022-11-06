package com.example.Lesbarkeit.Domain;

import com.example.Lesbarkeit.Spell;

import java.math.BigDecimal;
import java.util.Arrays;

public class Readibility {

    private static Sentence se = new Sentence();
    int sentences;
    int complex;
    int words;
    int syllables;
    int characters;

/*    public double getMetrics(MetricsType t) throws IllegalArgumentException{
        switch (t){
            case COMPLEXWORDS -> getComplex();
        }
    }*/

    public Readibility(String text){
        this.sentences = getNumberOfSentences(text + ".");
        this.words = getNumberOfWords(text);
        this.syllables = getNumberOfSyllables(text);
        this.complex = getNumbersOfComplexWords(text);
    }

    public int getCharacters() {
        return characters;
    }

    public int getComplex() {
        return complex;
    }

    public int getSyllables() {
        return syllables;
    }

    public int getSentences() {
        return sentences;
    }

    public int getWords() {
        return words;
    }

    private static boolean isComplex(String w){
        int syllables = Syllabify.syllable(w);
        return (syllables>2);
    }

    public int getNumberOfCharacters(String text){
        String[] word = text.split("");

        int characters = 0;
        for(String w:word){
            characters+=w.length();
        }
        return characters;
    }
    public int getNumbersOfComplexWords(String text){
        String cleanText = cleanLine(text);
        String[] words = cleanText.split(" ");
        for(String w:words){
            if (isComplex(w)){
                complex++;
            }
        }
        return complex;
    }


    public static int getNumberOfSyllables(String text){
        String[] words = Spell.spellWord(text);
        int countSyllables = 0;
        for(String w: words){
                countSyllables++;
        }
        return countSyllables;
    }

    public void wordsPerSentence(String text) {
        text = text.trim();
        String[] tokens = text.split("[.?!]");
        int numsToken = tokens.length;
        String[] words = text.split(" ");

        for (int i=0;i<numsToken;i++){
            String[] wordPerSentence = tokens[i].split("[ ]+");
/*            System.out.println(Arrays.toString(wordPerSentence));*/
            int numWordspersentence = wordPerSentence.length;
            System.out.println("Number of words Per Sentence: " + numWordspersentence);
            if(numWordspersentence<getNumberOfWords(text)*0.3){
                System.out.println("Short sentences: " + numWordspersentence);
            }else {
                System.out.println("Long sentences: " + numWordspersentence);
            }
        }

    }

    public int getNumberOfSentences(String text){
        int l = se.getSentences(text).length;
        if(l>0){
            return l;
        }else if(text.length()>0){
            return 1;
        }
        return 0;
    }

    public int getNumberOfWords(String text){
        String[] word = text.split(" ");
        words = 0;
        for(String w: word){
            if(w.length() > 0){
                words++;
            }
        }
        return words;
    }

    public String cleanLine(String line) {
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i<line.length();i++) {
            char c = line.charAt(i);
            if(c<128 && Character.isLetter(c)){
                buffer.append(c);
            }else {
                buffer.append(' ');
            }

        }
        return buffer.toString().toLowerCase();
    }

    public double getFleschReadingEase(){
        double score = 180 - (double) words/sentences - 58.5 * syllables/words;
        return round(score, 3);
    }

    private static Double round(double d, int decimalPlace) {
        // see the Javadoc about why we use a String in the constructor
        // http://java.sun.com/j2se/1.5.0/docs/api/java/math/BigDecimal.html#BigDecimal(double)
        BigDecimal bd = new BigDecimal(Double.valueOf(d).longValue());
        bd = bd.setScale(3, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }
}
