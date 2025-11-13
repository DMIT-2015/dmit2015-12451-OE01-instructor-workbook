package dmit2015.resource;

import dmit2015.dto.JobDto;
import dmit2015.dto.RegionDto;
import dmit2015.entity.Job;
import dmit2015.entity.Region;
import dmit2015.mapper.JobMapper;
import dmit2015.mapper.RegionMapper;
import dmit2015.persistence.HumanResourcesRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.util.List;

@ApplicationScoped
@Path("/hr")
@Produces("application/json")
public class HumanResourceResource {

    @Inject
    private HumanResourcesRepository hrRepository;

    @GET
    @Path("/Regions")
    public List<RegionDto> findAllRegions() {
        return hrRepository.findAllRegions()
                .stream()
                .map(RegionMapper.INSTANCE::toDto)
                .toList();
    }

    @GET
    @Path("/jobs")
    public List<JobDto> findAllJobs() {
        return hrRepository.findAllJobs()
                .stream()
                .map(JobMapper.INSTANCE::toDto)
                .toList();
    }
}
