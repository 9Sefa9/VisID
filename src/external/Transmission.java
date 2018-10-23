package external;

import java.util.function.Supplier;

public class Transmission implements Supplier<Boolean> {
    public boolean isFormSended() {
        //TODO
    }

    @Override
    public Boolean get() {
        return isFormSended();
    }
}
