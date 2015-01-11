package example;

import com.google.inject.Guice;
import com.google.inject.Provider;
import org.junit.Assert;
import org.junit.Test;

public class IdGeneratorTest {

    @Test
    public void testGetNextId_generatesNextId() throws Exception {
        IdGenerator idGenerator = new IdGenerator();
        for (int i = 0; i < 100; i++) {
            Assert.assertEquals(String.valueOf(i), idGenerator.getNextId());
        }
    }

    @Test
    public void testInjectsItselfAsSingleton() throws Exception {
        Provider<IdGenerator> provider = Guice.createInjector().getProvider(IdGenerator.class);
        Assert.assertTrue(provider.get() == provider.get());
    }
}