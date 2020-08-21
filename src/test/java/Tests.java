import org.junit.Assert;
import org.junit.Test;
import testTasks.Main;
import testTasks.MyPair;

import java.util.ArrayList;
import java.util.List;

public class Tests {

    @Test
    public void task1Test() {
        int[] arr = new int[100];
        List<MyPair> list = new ArrayList<>();
        list.add(new MyPair(100, 0));
        Assert.assertEquals(list,Main.task1(arr)); //Test for arr with 100 x {0}

        list = new ArrayList<>();
        arr = new int[]{1, 2, 3, 2, 2, 2, 3, 3, 1, 4};
        list.add(new MyPair(4, 2));
        list.add(new MyPair(3, 3));
        list.add(new MyPair(2, 1));
        list.add(new MyPair(1, 4));
        Assert.assertEquals(list, Main.task1(arr)); //Test for order of keys

        list = new ArrayList<>();
        arr = new int[]{1, 3, 5, 2, 4, 7, 6, 8, 9};
        list.add(new MyPair(1, 1));
        list.add(new MyPair(1, 2));
        list.add(new MyPair(1, 3));
        list.add(new MyPair(1, 4));
        list.add(new MyPair(1, 5));
        list.add(new MyPair(1, 6));
        list.add(new MyPair(1, 7));
        list.add(new MyPair(1, 8));
        list.add(new MyPair(1, 9));
        Assert.assertEquals(list, Main.task1(arr)); //Test for order of values

        list.remove(list.size() - 1);
        list.remove(list.size() - 1);
        list.add(new MyPair(1, 9)); //Change order of two last obj
        list.add(new MyPair(1, 8));
        Assert.assertNotEquals(list, Main.task1(arr)); //Order matters!
    }

    @Test
    public void task2Test() {
        Assert.assertTrue(Main.task2(""));
        Assert.assertTrue(Main.task2("()"));
        Assert.assertTrue(Main.task2("[]"));
        Assert.assertTrue(Main.task2("()[]"));
        Assert.assertTrue(Main.task2("([])"));
        Assert.assertTrue(Main.task2("()([])([][()])"));
        Assert.assertFalse(Main.task2("]"));
        Assert.assertFalse(Main.task2("["));
        Assert.assertFalse(Main.task2("("));
        Assert.assertFalse(Main.task2(")"));
        Assert.assertFalse(Main.task2("([)]"));
        Assert.assertFalse(Main.task2("[[])"));
        Assert.assertFalse(Main.task2("))(([[[]]]"));
    }

    @Test
    public void task3_1Test() {
        Assert.assertEquals(Integer.valueOf(0b1), Main.task3_1(0b0));
        Assert.assertEquals(Integer.valueOf(0b10011111), Main.task3_1(0b10010111));
        Assert.assertEquals(Integer.valueOf(0b1111111), Main.task3_1(0b111111));
    }

    @Test
    public void task3_2Test() {
        Assert.assertEquals(Integer.valueOf(1), Main.task3_2(0));
        Assert.assertEquals(Integer.valueOf(1), Main.task3_2(1));
        Assert.assertEquals(Integer.valueOf(11), Main.task3_2(10));
        Assert.assertEquals(Integer.valueOf(10111), Main.task3_2(10101));
        Assert.assertEquals(Integer.valueOf(10001), Main.task3_2(10000));
        Assert.assertEquals(Integer.valueOf(11923423), Main.task3_2(10923423));
        Assert.assertEquals(Integer.valueOf(-12312), Main.task3_2(-12302));
    }

}
