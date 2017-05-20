package concepts.optional;

import java.util.Optional;

/**
 * Created by pradeep on 20/5/17.
 */
public class OptionalTester {

    public static void main(String[] args) {
        Computer c = new Computer();
        DVDWriter dvdWriter = new DVDWriter();
        dvdWriter.setVersion("mark 3");
        c.setDvdWriter(Optional.of(dvdWriter));

        Optional<Computer> computer = Optional.of(c);

        String version = null;
        version = computer
                .flatMap(Computer::getDvdWriter)
                .map(DVDWriter::getVersion)
                .orElse("No Version");
        System.out.println(version);

        version = computer
                .flatMap(Computer::getDvdWriter)
                .orElse(dvdWriter)
                .getVersion();
        System.out.println(version);
    }
}
