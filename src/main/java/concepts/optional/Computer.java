package concepts.optional;

import java.util.Optional;

/**
 * Created by pradeep on 20/5/17.
 */
public class Computer {

    private Optional<DVDWriter> dvdWriter;

    public Optional<DVDWriter> getDvdWriter() {
        return dvdWriter == null ? Optional.empty() : dvdWriter;
    }

    public void setDvdWriter(Optional<DVDWriter> dvdWriter) {
        this.dvdWriter = dvdWriter;
    }
}
