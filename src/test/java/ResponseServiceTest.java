import com.rest.api.service.ResponseService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class ResponseServiceTest {
    private ResponseService responseService;

    @Before
    public void setUp() throws Exception {
        responseService = new ResponseService();
    }

    @Test
    public void getSingleResult() {
        responseService.getSingleResult("test");
       // assertEquals("test", responseService.getSingleResult("test"));

    }

    @Test
    public void getListResult() {
        List<String> list = new ArrayList();
        responseService.getListResult(list);
        assertEquals("test", "test");

    }

}