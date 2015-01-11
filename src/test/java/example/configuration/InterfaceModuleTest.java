package example.configuration;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import example.ModelFormatter;
import example.ModelFormatterImpl;
import org.junit.Assert;
import org.junit.Test;

public class InterfaceModuleTest {


    @Test
    public void testConfiguration() throws Exception {
        Module interfaceModule = new InterfaceModule();
        Module formatModule = new FormatModule(true);
        Injector injector = Guice.createInjector(interfaceModule, formatModule);
        ModelFormatter formatter = injector.getInstance(ModelFormatter.class);
        Assert.assertTrue(formatter instanceof ModelFormatterImpl);
    }

}