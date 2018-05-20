package com.harry.winser.api.article.temp;

import com.harry.winser.api.TestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class DatabasePopulatorTest {

    @Autowired
    private DatabasePopulator populator;

    @Test
    public void shouldDownloadAllArticles(){

        this.populator.populateDatabase();
    }
}
