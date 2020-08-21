package testTasks;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    /**
     * имеется массив чисел, получить список вида {число, количество вхождений числа в массив}, список
     * должен быть отсортирован по количеству вхождений, внутри по возрастания числа. Использовать
     * можно любой алгоритмический язык.
     */
    /*
     Сначала считаываем все в treeMap, т.к. map позволяет очень просто работать с парами значений, да и к тому же
     treeMap сортирует ключи в natural order. Затем создаю класс myPair, необходимый для простого сравнения пар (k, v)
     которое необходимо для сортировки. Сортируем по условию задачи и собираем в List, который и возвращаем.
    */
    public static List<MyPair> task1(int[] arr) {
        Map<Integer, Integer> tempMap = new TreeMap<>(); //map of (Number, Counter) and gives us natural order by key
        for (int value : arr) { //add numbers to map. If number already in map, increase the counter
            tempMap.compute(value, (k, v) -> v == null ? 1 : v + 1);
        }
        return tempMap.entrySet()//get entrySet from map
                .stream()//set to stream
                .map(entry -> new MyPair(entry.getValue(), entry.getKey())) //translate every Entry to MyPair
                .sorted()   //sort set of MyPairs
                .collect(Collectors.toList());
    }

    /**
     * написать алгоритм проверки корректности регулярного выражения, которое включает [,],(,)
     * т.е., например ([][[]()]) - правильно, ([][]()]) – неправильно
     */
    /*
     Задача решается с помощью стека, мы помещаем все открывающиеся скобки, которые встречаем итерируясь по строке,
     если встречаем закрывающуюся скобку, то смотрим в стек, если там открывающаяся скобка того же типа, то все ОК,
     идем дальше вытащив из стека одну скобку, если же стек пуст/там другая скобка, возвращаем false.
    */
    public static boolean task2(String seq) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < seq.length(); i++) {
            char ch = seq.charAt(i);
            if (ch == '(' || ch == '[') { //if '(' or '['  -> to stack
                stack.push(ch);
            } else if (ch == ')') { //if ')' -> stack.peek and if we have empty stack or '[' -> false
                if (!stack.empty() && stack.peek().equals('('))
                    stack.pop(); //if all OK pop one element from stack
                else
                    return false;
            } else if (ch == ']') { //if ']' -> stack.peek and if we have empty stack or '(' -> false
                if (!stack.empty() && stack.peek().equals('['))
                    stack.pop(); //if all OK pop one element from stack
                else
                    return false;
            } else {
                //we have checked current character and if it's not '(' or '[' or ')' or ']' -> throw Ex
                throw new IllegalArgumentException("Sequence contains unknown characters");
            }
        }
        return stack.empty();
    }

    /**
     * написать алгоритм, как в целом числе самый правый ноль превратить в единицу не используя
     * циклы и рекурсию.
     */
    /*
    Насколько я понял, речь идет о двоичном числе, если это так, то задача решается просто.
     */
    public static Integer task3_1(Integer num) {
        return (num | num + 1);
    }

    /**
     * написать алгоритм, как в целом числе самый правый ноль превратить в единицу не используя
     * циклы и рекурсию.
     */
    /*
     В случае с десятичным числом я бы решал так:
     В задаче не используюся циклы и рекурсии явно, однако в методе lastIndexOf цикл все же используется
     */
    public static Integer task3_2(Integer num) {
        StringBuilder sb = new StringBuilder(num.toString());
        int idx = sb.lastIndexOf("0");
        if (idx >= 0)
            sb.replace(idx, idx + 1, "1");
        return Integer.parseInt(sb.toString());
    }
}
