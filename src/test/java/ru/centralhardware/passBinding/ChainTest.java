package ru.centralhardware.passBinding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ChainTest {

    public static List<Integer> a(){
        return Arrays.asList(1,2,3,4,5);
    }

    public static List<Integer> b(List<Integer> list){
        List<Integer> res = new ArrayList<>(list);
        res.add(6);
        return res;
    }

    public static List<Integer> c(List<Integer> list){
        List<Integer> res = new ArrayList<>(list);
        res.add(7);
        return res;
    }

    public static final List<Integer> expected = Arrays.asList(1,2,3,4,5,6,7);

    @Test
    public void of(){
        List<Integer> result = (List<Integer>) Chain.
                of(ChainTest::a).
                c(ChainTest::b).
                c(ChainTest::c).
                e();
        assertEquals(expected, result);
    }
}