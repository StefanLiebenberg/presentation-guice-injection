package example;

import com.google.inject.Singleton;

@Singleton
public class IdGenerator {

    private int idCounter = 0;

    public String getNextId() {
        return String.valueOf(idCounter++);
    }

}
