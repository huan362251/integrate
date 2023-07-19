package com.bawangbai.elastic.search.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

@Slf4j
public class Demo {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        log.info("monthFirst date:{}",localDate.toString());

    }
}
