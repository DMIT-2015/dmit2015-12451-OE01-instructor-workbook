package dmit2015.batch.listener;


import jakarta.batch.api.listener.StepListener;
import jakarta.batch.runtime.context.JobContext;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Intercepts step execution before and after running a step.
 * It is referenced from the listener element inside the step element
 * To apply this listener to a batch job you must define a listener element in the Job Specification Language (JSL) file
 * INSIDE the step element as follows:
 * <pre>{@code
 * 	<listeners>
 * 		<listener ref="etlProcessDwPubsSalesStepListener" />
 * 	</listeners>
 * }</pre
 */
@Named
@Dependent
public class EtlProcessDwPubsSalesStepListener implements StepListener {

    @Inject
    private JobContext _jobContext;

    private long _startTime;

    @Override
    public void beforeStep() throws Exception {
        System.out.println("beforeStep");
        _startTime = System.currentTimeMillis();
    }

    @Override
    public void afterStep() throws Exception {
        System.out.println("afterStep");
        long endTime = System.currentTimeMillis();
        long durationMilliseconds = (endTime - _startTime);
        String message = String.format("Step completed in %d milliseconds", durationMilliseconds);
        System.out.println(message);

    }

}

