package com.example.Lesbarkeit;

import com.example.Lesbarkeit.Domain.Readibility;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String text ="Das Verfahren und die genauen Kriterien lauten in Worten: Eine Textstelle mit mindestens 100 Wörtern Länge wird ausgewählt und die genaue Anzahl der darin enthaltenen Wörter bestimmt. Selbstverständlich kann auch der ganze Text bearbeitet werden, was allerdings in einem erheblichen Mehraufwand resultieren kann.";
      /*  System.out.println(Arrays.toString(Spell.spellWord(text)));*/
        Readibility readibility = new Readibility(text);

        System.out.println(" Symbols: "+readibility.getNumberOfCharacters(text));
        System.out.println(" Sentences: "+readibility.getNumberOfSentences(text));
        System.out.println(" Words: "+readibility.getNumberOfWords(text));
        System.out.println(" Hard words: "+readibility.getNumbersOfComplexWords(text));
        System.out.println(" Syllables: "+ Readibility.getNumberOfSyllables(text));
        System.out.println(" FLESCH EASE: "+ readibility.getFleschReadingEase());
        readibility.wordsPerSentence(text);

    }
}
