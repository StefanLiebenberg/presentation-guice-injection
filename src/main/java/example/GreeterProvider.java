package example;


import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.name.Named;


public class GreeterProvider implements Provider<GreeterModel> {

    private final Provider<GreeterBuilder> greeterBuilderProvider;

    private final String name;

    private final Provider<ClockModel> clockModel;

    @Inject
    public GreeterProvider(Provider<GreeterBuilder> greeterBuilderProvider, @Named("Now") Provider<ClockModel> clockModel, @Assisted String name) {
        this.greeterBuilderProvider = greeterBuilderProvider;
        this.name = name;
        this.clockModel = clockModel;
    }

    @Override
    public GreeterModel get() {
        return greeterBuilderProvider.get().setClockModel(clockModel.get()).setName(name).build();
    }
}
