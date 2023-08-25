package com.tmkim.stock.service.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StreamIntro {
    @Test
    public void stream() {
        // JDK8부터 Stream API와 람다, 함수형 인터페이스를 지원하면서 Java에서도 함수형 프로그래밍을 할 수 있게 되었다.
        // Stream API는 데이터를 추상화하고 처리하는데 자주 사용되는 함수를 정의한 것이다. 데이터가 추상화되었다는 것은
        // 데이터의 종류에 상관없이 같은 방식으로 데이터를 처리할 수 있다는 것이다.

        // 1. 스트림이 나오기 전
        // 나쁜 코드는 아니다. 하지만 읽기가 힘들고 원본 데이터가 변형된다는 단점이 있다.
        String[] nameArr = {"IronMan", "Captain", "Hulk", "Thor"};
        List<String> nameList = Arrays.asList(nameArr);

        // 원본 데이터가 직접 정렬된다.
        Arrays.sort(nameArr);
        Collections.sort(nameList);

        for(String str: nameArr) {
            System.out.println(str);
        }

        for(String str: nameList) {
            System.out.println(str);
        }

        // 2. 스트림 사용
        String[] nameArr2 = {"IronMan", "Captain", "Hulk", "Thor"};
        Stream<String> nameStream = Arrays.stream(nameArr2);
        nameStream.sorted().forEach(System.out::println);       // 이게 자바..?

        // 스트림 특징
        // 원본 데이터를 변경하지 않는다.
        // 일회용이다.
        // 내부 반복으로 작업을 처리한다.
        List<String> myList = Arrays.asList("a", "b", "c", "d", "e", "f", "c2");
        myList
                .stream()   // 1. 스트림 생성
                .filter(s -> s.startsWith("c")) // 2. 가공
                .map(String::toUpperCase)   // 2. 가공
                .sorted()
                .count();   // 2. 결과

        // stream이 없었다면 코드도 길고, 불필요한 지역변수도 많이 선언해야 했을거다.
    }
}
