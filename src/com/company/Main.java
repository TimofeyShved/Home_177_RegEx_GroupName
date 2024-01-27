package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        // найдет "а", присвоет имя "Aletter" и добавит "-"
        System.out.println("abc".replaceAll("(?<Aletter>a)", "${Aletter}-"));

        // заставляем проверять что тег закрывается, так как полученый тег мы запихиваем в группу
        // и чуть позже вызываем когда нужно закрыть тег
        Pattern p1 = Pattern.compile("<(?<tag>[A-Z][A-Z0-9]*)[^>]*>.*?</\\k<tag>>");
        Matcher m1 = p1.matcher("This is a <EM>text</EM> test <b>?</u>");
        while (m1.find()){
            System.out.println(m1.start() +" "+ m1.group()+" ");
        }

        // обращение по номеру и по имени
        System.out.println("abcd".replaceAll("(a)(?<x>b)(c)(?<y>d)", "$1$2$3$4"));
        System.out.println("abcd".replaceAll("(a)(?<x>b)(c)(?<y>d)", "$1${x}$3${y}"));
    }
}
