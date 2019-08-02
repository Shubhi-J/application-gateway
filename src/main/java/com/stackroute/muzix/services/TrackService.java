package com.stackroute.muzix.services;

import com.stackroute.muzix.Model.Track;

import java.util.List;

public interface TrackService {


    public boolean saveTrack(List<Track> tracks);

    public boolean deleteTrack(int id);

    public List<Track> getAllTracks();

    public Track getTrackById(int id);

    public boolean updateTrack(Track track);

    public Track findByName(String name);

    public List<Track> findByComment(String comment);

}
