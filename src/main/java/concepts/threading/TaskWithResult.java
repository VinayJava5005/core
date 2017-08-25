package concepts.threading;

import java.util.concurrent.Callable;

/**
 * Created by pradeep on 16/7/17.
 */
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }


    @Override
    public String call() throws Exception {
        if (id == 11) {
            while (true) {

            }
        }
        return "result of TaskWithResult " + id;
    }
}
