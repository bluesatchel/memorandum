package com.mem;

import com.mem.model.Word;
import com.mem.mapper.WordMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class test {
    @Autowired
    private WordMapper wordMapper;
    @Test
    public void testWord(){
        long a=System.currentTimeMillis()/1000/(60*60*24);
        System.out.println(a);
        long b=1658161794000l/1000/(60*60*24);

        System.out.println(b);

    }
}
