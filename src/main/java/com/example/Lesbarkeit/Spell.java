package com.example.Lesbarkeit;

import java.util.*;

/**
 * Silbentrennung in Java
 */
public class Spell {

/*  public static void main(String[] args) {
    test("Lattenrost"         , "Lat-ten-rost") ;
    test("Genossenschaft"     , "Ge-nos-sen-schaft") ;
    test("Kücker"             , "Kük-ker") ;
    test("Mellouk"            , "Mel-louk") ;
    test("Hut"                , "Hut") ;
    test("Sack"               , "Sack") ;
    test("Tante"              , "Tan-te") ;
    test("Supermann"          , "Su-per-mann") ;
    test("Filzlaus"           , "Filz-laus") ;
    test("Karton"             , "Kar-ton") ;
    test("Projektmitarbeiter" , "Pro-jekt-mit-ar-bei-ter") ;
    test("Ecke"               , "Ek-ke") ;
    test("Anwendung"          , "An-wen-dung") ;
    test("Anwendungen"        , "An-wen-dungen") ;
    test("Errungenschaften"   , "Er-rungen-schaf-ten") ;
    test("Baumstruktur"       , "Baum-struk-tur") ;
    test("Datenbankverbindungen"       , "Da-ten-bank-ver-bin-dungen") ;
    test("resultierenden"       , "re-sul-tie-ren-den") ;
    test("Seitengestaltung"       , "Sei-ten-ge-stal-tung") ;
    test("Autorennen",           "Au-to-ren-nen");
    test("Autorengemeinschaft" , "Au-to-ren-ge-mein-schaft") ;
    test("Musik" , "Mu-sik") ;
    test("Aufgabe" , "Auf-ga-be") ;
    test("Aufgaben" , "Auf-ga-ben") ;
    test("Schaftränke" , "Schaf-trän-ke") ;
    test("Gesamtautorengemeinschaft" , "Ge-samt-au-to-ren-ge-mein-schaft") ;
    test("Betreten" , "Be-tre-ten") ;
    test("Beschreibung" , "Be-schrei-bung") ;
    test("Beschreibungen" , "Be-schrei-bungen") ;
    test("Entwurf" , "Ent-wurf") ;
    test("Ablaufbeschreibung", "Ab-lauf-be-schrei-bung") ;
    test("Ablaufbeschreibungen", "Ab-lauf-be-schrei-bungen") ;
    test("Artikelbezeichnung" , "Ar-ti-kel-be-zeich-nung") ;
    test("Artikelbezeichnungen" , "Ar-ti-kel-be-zeich-nungen") ;
    test("Begründung" , "Be-grün-dung") ;
    test("Lieferantenname" , "Lie-fe-ran-ten-na-me") ; // leider falsch
    test("Lieferantennummer" , "Lie-fe-ran-ten-num-mer") ; // leider falsch
    test("Anforderungstext" , "An-for-de-rungs-text") ; // leider falsch
    test("Listungsinformation" , "Lis-tungs-in-for-ma-tion") ; // leider falsch
    test("Sortiment" , "Sor-ti-ment") ;
    test("Aktion" , "Ak-tion") ;
    test("Bezugsweg" , "Be-zugs-weg") ;
    test("Preis" , "Preis") ;
    test("Auflistung" , "Auf-lis-tung") ;
    test("Benutzer" , "Be-nut-zer") ;
    test("Kontakt" , "Kon-takt") ;
    test("Zeilen" , "Zei-len") ;
    test("Zeichen" , "Zei-chen") ;
    test("Änderungstext" , "Än-de-rungs-text") ;// leider falsch
    test("Ablehnungstext" , "Ab-leh-nungs-text") ;
    test("Bearbeitung" , "Be-ar-bei-tung") ;
    test("Zurücksetzen" , "Zu-rück-set-zen") ;
    test("Freigeben","Frei-ge-ben") ;
    test("Prüfen" , "Prü-fen") ;
    test("Löschen" , "Lö-schen") ;
    test("Datum" , "Da-tum") ;
    test("Vorbelegung","Vor-be-le-gung") ;
    test("folgende","fol-gen-de");
    test("Kenntnis","Kennt-nis");
    test("extern","ex-tern");
    test("externe","ex-ter-ne");
    test("Herr","Herr");
    test("Herren","Her-ren");
    test("Geschäftsbereichsleitung","Ge-schäfts-be-reichs-lei-tung");
    test("Bereich","Be-reich");
    test("freundlich","freund-lich");
    test("freundlichen","freund-li-chen");
    test("Anwendungsentwicklung","An-wen-dungs-ent-wick-lung");
    test("Beauftragung","Be-auf-tra-gung");
    test("Geheimhaltung","Ge-heim-hal-tung");
    test("zugeteilten","zu-ge-teil-ten");
    test("Informationen","In-for-ma-tio-nen");
    test("Empfang","Emp-fang");
    test("Beratung","Be-ra-tung");
    // test( "","");
    // test( "","");
    // test( "","");

    String strText = // ...
        "Alle meine Entchen schwimmen auf dem See, Köpfchen unters Wasser, Schwänzchen in die Höh.";

    System.out.println(formatText(strText , 25)) ;

  }*/


  public static void test(String paStr, String paStrExpected) {
    System.out.println("=====================================================================");

    System.out.println(paStr);
    String strResult = arr2Str(spellWord(paStr) , "-") ;

    System.out.println(" -> " + strResult) ;
    if (!strResult.equals(paStrExpected)) {
      throw new RuntimeException("expected was " + paStrExpected) ;
    }
  }

  public static String formatText(String paStr , int paIntWidth) {
    StringBuffer retStrBuff = new StringBuffer();
    StringTokenizer strTok = new StringTokenizer(paStr , "\n") ;

    while (strTok.hasMoreElements()) {
      retStrBuff.append(formatLine(strTok.nextToken().trim() , paIntWidth) + "\n");
    }

    return retStrBuff.toString();
  }


  public static String formatLine(String paStr , int paIntWidth) {
    StringBuffer retStrBuff = new StringBuffer();
    StringBuffer lineStrBuff = new StringBuffer();
    StringTokenizer strTok = new StringTokenizer(paStr , " ") ;

    while (strTok.hasMoreElements()) {
      String[] strArrWord = spellWord(strTok.nextToken().trim()) ;

      for (int i = 0 ; i < strArrWord.length ; i++) {

        if ((lineStrBuff.length() + strArrWord[i].length()) > paIntWidth) {
          retStrBuff.append(lineStrBuff);
          if (i > 0) {
            retStrBuff.append("-");
          }
          retStrBuff.append("\n");
          lineStrBuff = new StringBuffer();
        }
        lineStrBuff.append(strArrWord[i]);
      }
      lineStrBuff.append(" ");
    }

    retStrBuff.append(lineStrBuff + "\n");
    return retStrBuff.toString();
  }// end method

  private static HashSet<String> knownWordHashSet = newKnownWordHashSet() ;

  private static HashSet<String> newKnownWordHashSet() {
    HashSet<String> newHashSet = new HashSet<>();

    newHashSet.add("seiten") ;
    newHashSet.add("autoren") ;
    newHashSet.add("gesamt") ;
    return   newHashSet;
  }


  private static HashMap<String, String[]> wordHashMap = new HashMap<>();

  private static HashSet<String> syllHashSet = newSyllHashSet();

  private static HashSet<String> newSyllHashSet() {
    HashSet<String> newHashSet = new HashSet<String>();

    newHashSet.add("an") ;
    newHashSet.add("trag") ;
    newHashSet.add("schäfts") ;
    newHashSet.add("chen") ;
    newHashSet.add("gen") ;

    newHashSet.add("dung") ;
    newHashSet.add("nung") ;
    newHashSet.add("rung") ;
    newHashSet.add("tung") ;

    newHashSet.add("dungs") ;
    newHashSet.add("nungs") ;
    newHashSet.add("rungs") ;
    newHashSet.add("tungs") ;

    newHashSet.add("ent") ;
    newHashSet.add("auf") ;
    newHashSet.add("trag") ;

    newHashSet.add("lis") ;
    newHashSet.add("in") ;
    newHashSet.add("tion") ;
    newHashSet.add("grund") ;
    newHashSet.add("gründ") ;
    newHashSet.add("änderung") ;
    newHashSet.add("be") ;
    newHashSet.add("ver") ;
    newHashSet.add("lauf") ;
    newHashSet.add("schreib") ;
    newHashSet.add("ngen") ;
    newHashSet.add("ten") ;
    newHashSet.add("treten") ;
    newHashSet.add("mit") ;
    newHashSet.add("pro") ;
    newHashSet.add("jekt") ;
    newHashSet.add("re") ;
    newHashSet.add("agieren") ;
    newHashSet.add("arbeit") ;
    newHashSet.add("schaft") ;
    newHashSet.add("schaf") ;
    newHashSet.add("tränke") ;
    newHashSet.add("gesamt") ;
    newHashSet.add("samt") ;
    newHashSet.add("autor") ;
    newHashSet.add("rungs") ;
    newHashSet.add("text") ;
    return   newHashSet;

  }


  public static String[] spellWord(String paStrWord) {
    String[] retStrArr = null ;

    retStrArr = wordHashMap.get(paStrWord);
    if (retStrArr != null) {
      return retStrArr;
    }
    ArrayList<String> arrList = new ArrayList<>();

    paStrWord = paStrWord.trim();

    String strPreSyllable = "" ;
    String strPreSyllables = "" ;

    while (paStrWord.length() > 0) {
      System.out.println("-----------------------------------------------------");
      String syllable = parseSyllable(paStrWord,strPreSyllable,strPreSyllables) ;

      // System.out.println( "silbe:"+silbe);

      paStrWord = paStrWord.substring(syllable.length()) ;
      arrList.add(syllable) ;
      strPreSyllable = syllable ;
      strPreSyllables += syllable ;
    }// while

    retStrArr = (String[]) arrList.toArray(new String[0]) ;
    int countSyllables=0;
    for(String n : retStrArr){
      countSyllables ++;
    }
    System.out.println("Syllables: " + countSyllables);

    wordHashMap.put(paStrWord , retStrArr) ;

    return retStrArr;
  }


  private static String parseSyllable(String paStr, String paStrPreSyllable, String paStrPreSyllables) {
    int i = 0 ;
    boolean bCkToKK = false ;

    boolean bCont = true ;

    while (bCont) {
      bCont = false;

      boolean bMatch = false;

      for (;!bMatch && i < paStr.length() && isConsonant(paStr.charAt(i)) ; i++) {
        bMatch = checkKnownSyllable(paStr.substring(0 , Math.min(i , paStr.length())) ,
            paStr.substring(Math.min(i , paStr.length()))) ;
      }

      for (;!bMatch && i < paStr.length() && isVocal(paStr.charAt(i)) ; i++) {
        bMatch = checkKnownSyllable(paStr.substring(0 , Math.min(i , paStr.length())) ,
            paStr.substring(Math.min(i , paStr.length())));
      }

      for (;!bMatch && (i < (paStr.length() - 1)) && isConsonant(paStr.charAt(i + 1)) ; i++) {
        bMatch = checkKnownSyllable(paStr.substring(0 , Math.min(i , paStr.length())) ,
            paStr.substring(Math.min(i , paStr.length())));
      }

      System.out.println("vor den Regeln: " + paStr.substring(0 , Math.min(i , paStr.length())) + "|"
          + paStr.substring(Math.min(i , paStr.length()))) ;

      if (bMatch) {
        i--;
      }

      else if (checkKnownSyllable(paStr.substring(0 , Math.min(i , paStr.length())) ,
          paStr.substring(Math.min(i , paStr.length())))) {
        System.out.println("Trennung zweier bekannter Silben aufgetreten " + paStr.substring(i)) ;
      }

      else if (checkKnownSyllable(paStr.substring(0 , Math.min(i + 1 , paStr.length())) ,
          paStr.substring(Math.min(i + 1, paStr.length())))) {
        System.out.println("Trennung zweier bekannter Silben an Folgeposition 1 aufgetreten " + paStr.substring(i)) ;
        i += 1 ;
      }

      else if (checkKnownSyllable(paStr.substring(0 , Math.min(i + 2 , paStr.length())) ,
          paStr.substring(Math.min(i + 2, paStr.length())))) {
        System.out.println("Trennung zweier bekannter Silben an Folgeposition 2 aufgetreten " + paStr.substring(i)) ;
        i += 2 ;
      }

       else if (checkKnownSyllable(paStr.substring(0 , Math.min(i + 3 , paStr.length())) ,
       paStr.substring(Math.min(i + 3, paStr.length())))) {
       System.out.println("Trennung zweier bekannter Silben an Folgeposition 3 aufgetreten " + paStr.substring(i)) ;
       i += 3 ;
       }

      else if (i > 1 && (i < paStr.length() - 1) && paStr.substring(i - 1).startsWith("st")) {
        System.out.println("st wurde getrennt " + paStr.substring(i)) ;
        i--;
      }

      else if ((i < paStr.length() - 1) && paStr.substring(i).startsWith("st")) {
        System.out.println("st am Ende der Silbe " + paStr.substring(i)) ;
        i += 2;
      }

      else if ((i < paStr.length() - 1) && paStr.substring(i).startsWith("ft")) {
        System.out.println("ft am Ende der Silbe " + paStr.substring(i)) ;
        i += 2;
      }

      else if (i > 2 && (i < paStr.length() - 1) && paStr.substring(i - 2).startsWith("sch")) {
        System.out.println("sch wurde getrennt " + paStr.substring(i)) ;
        i -= 2;
      }

      else if (i > 1 && (i < paStr.length() - 1) && paStr.substring(i - 1).startsWith("ch")) {
        System.out.println("ch wurde getrennt " + paStr.substring(i)) ;
        i--;
      }

      else if (i > 2 && (i < paStr.length() - 1) && paStr.substring(i - 2).startsWith("str")) {
        System.out.println("str am Anfang der nächsten Silbe " + paStr.substring(i)) ;
        i -= 2;
      }


      else if ((i > 1 && (i < paStr.length() - 1) && paStr.substring(i - 1).startsWith("c")) // ...
          && (i < paStr.length() - 1) && paStr.substring(i).startsWith("k")) {
        System.out.println("ck wird in kk umgewandelt " + paStr.substring(i)) ;
        bCkToKK = true ;
      }

      else if ((i > 1 && (i < paStr.length() - 1) && paStr.substring(i - 1).toLowerCase().startsWith("n")) // ...
          && (i < paStr.length() - 1) && paStr.substring(i).startsWith("g")
          // && ( ! ( paStrPreSyllable.toLowerCase() + paStr.toLowerCase() ).startsWith( "seiten" ) ) // seiten-gestaltung als Ausnahme
          // && (!startsWithKnownWord(paStrPreSyllables.toLowerCase() + paStr.toLowerCase())) // Suchen nach Ausnahmen für ng-Trennung (seitengestaltung, autorengemeinschaft)
          // && (!startsWithKnownWord(paStrPreSyllables.toLowerCase() + paStr.substring(0,i).toLowerCase())) // Suchen nach Ausnahmen für ng-Trennung (seitengestaltung, autorengemeinschaft)
          // && (!endsWithKnownWord(paStrPreSyllables.toLowerCase() )) // Suchen nach Ausnahmen für ng-Trennung (seitengestaltung, autorengemeinschaft)
          // && (!endsWithKnownWord(paStrPreSyllables.toLowerCase() + paStr.toLowerCase())) // Suchen nach Ausnahmen für ng-Trennung (seitengestaltung, autorengemeinschaft)
          && (!endsWithKnownWord(paStrPreSyllables.toLowerCase() + paStr.substring(0,i).toLowerCase())) // Suchen nach Ausnahmen f�r ng-Trennung (seitengestaltung, autorengemeinschaft)
          ) {
        System.out.println("ng wird nicht getrennt " + paStr.substring(i)) ;
        i++;
        bCont = true;
        continue;
      }


      else if (i > 0 && (i < paStr.length() - 1) && isVocal(paStr.charAt(i + 1))) {
        System.out.println("ein Vocal folgt sofort nach dem endenden Konsonant " + paStr.substring(i)) ;
        ;
      }

      else if (i < paStr.length() && isConsonant(paStr.charAt(i))) {
        System.out.println("Ende der Silbe mit Konsonant " + paStr.substring(i)) ;
        i++;
      }

      else if (isAllConsonantes(paStr.substring(i))) {
        System.out.println("es folgen nur noch Konsonanten bis zum Ende des Wortes " + paStr.substring(i)) ;
        i = paStr.length();
      }

      else {
        System.out.println("keine Regel hat gezogen") ;
      }

    }

    String retStr = paStr.substring(0 , i) ;

    if (bCkToKK) {
      retStr = retStr.substring(0 , retStr.length() - 1) + "k" ;
    }

    return retStr ;
  }

  public static boolean isConsonant(char paCh) {
    return !isVocal(paCh) ;
  }// end method



  public static boolean isAllConsonantes(String paStr) {
    for (int i = 0 ; i < paStr.length() ; i++) {
      if (isVocal(paStr.charAt(i))) {
        return false ;
      }
    }
    return true ;

  }
  public static boolean isVocal(char paCh) {
    // ...
    return (
            paCh == 'e' ||
                    paCh == 'a' ||
                    paCh == 'o' ||
                    paCh == 'u' ||
                    paCh == 'i' ||
                    paCh == 'ä' ||
                    paCh == 'ü' ||
                    paCh == 'ö' ||

                    paCh == 'E' ||
                    paCh == 'A' ||
                    paCh == 'O' ||
                    paCh == 'U' ||
                    paCh == 'I' ||
                    paCh == 'Ä' ||
                    paCh == 'Ü' ||
                    paCh == 'Ö') ;
  }

  private static boolean startsWithKnownWord(String paStr) {
    System.out.println("startsWithKnownWord:" + paStr) ;
    paStr = paStr.toLowerCase() ;
    Iterator<String> iter = knownWordHashSet.iterator();

    while (iter.hasNext()) {
      if (paStr.startsWith(iter.next())) {
        return true;
      }
    }
    return false;
  }

  private static boolean endsWithKnownWord(String paStr) {
    System.out.println("endsWithKnownWord:" + paStr) ;
    paStr = paStr.toLowerCase() ;
    Iterator<String> iter = knownWordHashSet.iterator();

    while (iter.hasNext()) {
      if (paStr.endsWith(iter.next())) {
        return true;
      }
    }
    return false;
  }

  private static boolean contentsKnownWord(String paStr) {
    System.out.println("contentsKnownWord:" + paStr) ;
    paStr = paStr.toLowerCase() ;
    Iterator<String> iter = knownWordHashSet.iterator();

    while (iter.hasNext()) {
      if (paStr.indexOf(iter.next()) > -1) {
        return true;
      }
    }
    return false;
  }

  private static boolean contentsKnownWord(String paStrFirst,String paStrNext) {
    System.out.println("contentsKnownWord:" + paStrFirst + "?" + paStrNext) ;
    String paStr = paStrFirst + paStrNext ;

    Iterator<String> iter = knownWordHashSet.iterator();

    while (iter.hasNext()) {
      String strKnownWord = iter.next();

      if ((!paStrFirst.endsWith(strKnownWord)) && paStr.indexOf(strKnownWord) > -1) {
        return true;
      }
    }
    return false;
  }


  private static String arr2Str(String[] paStrArr , String paDelim) {
    StringBuffer sb = new StringBuffer();

    for (int i = 0 ; i < paStrArr.length ; i++) {
      sb.append(paStrArr[ i ]) ;
      if (i < (paStrArr.length - 1)) {
        sb.append(paDelim) ;
      }
    }
    return sb.toString();
  }
  private static boolean checkKnownSyllable(String paStrLast , String paStrNext) {
    System.out.println(paStrLast + "|" + paStrNext) ;
    if (endsWithKnownSyllable(paStrLast.toLowerCase()) && startsWithKnownSyllable(paStrNext)) {
      System.out.println("!!!");
      return true;
    }
    return false;

  }

  private static boolean endsWithKnownSyllable(String paStr) {
    Iterator<String> iter = syllHashSet.iterator();

    while (iter.hasNext()) {
      if (paStr.endsWith(iter.next())) {
        return true;
      }

    }
    return false;

  }

  private static boolean startsWithKnownSyllable(String paStr) {
    Iterator<String> iter = syllHashSet.iterator();

    while (iter.hasNext()) {
      if (paStr.startsWith(iter.next())) {
        return true;
      }
    }
    return false;

  }

}
