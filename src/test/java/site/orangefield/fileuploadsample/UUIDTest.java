package site.orangefield.fileuploadsample;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class UUIDTest {

    @Test
    public void UUID_연습() {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());
    }

}
