package web.quotes.data;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTest extends TestCase {

    private UserRepository userRepository;

    @Before
    public void setup() {
        userRepository = new UserRepositoryDummyImpl();
    }

    @Test
    public void testFindAll()  {
        Assert.assertEquals(3, userRepository.findAllLike("e").size());
        Assert.assertEquals(1, userRepository.findAllLike("mousse").size());
    }

}