package com.stackroute.muzix.repository;

import com.stackroute.muzix.Model.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends MongoRepository<Track,Integer> {

    public Track findByName(String name);
    public List<Track> findByComment(String comment);


}
