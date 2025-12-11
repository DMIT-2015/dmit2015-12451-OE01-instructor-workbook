package dmit2015.batch.listener;


import jakarta.batch.api.listener.JobListener;
import jakarta.batch.runtime.context.JobContext;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.logging.Logger;

/**
 * This listener contains methods that executes before and after a job execution runs.
 * To apply this listener to a batch job you must define a listener element in the Job Specification Language (JSL) file
 * BEFORE the first step element as follows:
 * <pre>{@code
 *
 * <listeners>
 *      <listener ref="etlProcessDwPubsSalesJobListener" />
 * </listeners>
 *
 * }</pre>
 */
@Named
@Dependent
public class EtlProcessDwPubsSalesJobListener implements JobListener {

    @Inject
    private JobContext _jobContext;

    private Logger _logger = Logger.getLogger(EtlProcessDwPubsSalesJobListener.class.getName());

    private long _startTime;

    @Override
    public void beforeJob() throws Exception {
        _logger.info(_jobContext.getJobName() + " beforeJob");
        _startTime = System.currentTimeMillis();


    }

    @Override
    public void afterJob() throws Exception {
        _logger.info(_jobContext.getJobName() + "afterJob");
        long endTime = System.currentTimeMillis();
        long durationMilliseconds = (endTime - _startTime);
        String message = _jobContext.getJobName() + " completed in " + durationMilliseconds + " ms";
        _logger.info(message);

    }

}

