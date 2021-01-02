package com.designProject.Pastebin.logger;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;
import org.hibernate.engine.jdbc.internal.Formatter;

public class P6spyHibernateSQLFormatter implements MessageFormattingStrategy {
    public static Formatter formatter = new BasicFormatterImpl();


    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql) {
        return "#" + now + " | took " + elapsed + "ms | " + category + " | connection " + connectionId
                + "\n" + "Hibernate query with params:" + formatter.format(sql)  +";";
    }

    @Override
    public String formatMessage(int i, String s, long l, String s1, String s2, String s3, String s4) {
        return null;
    }
}