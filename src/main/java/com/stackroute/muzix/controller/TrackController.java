package com.stackroute.muzix.controller;

import com.stackroute.muzix.Model.Track;
import com.stackroute.muzix.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api")
public class TrackController {

    @Autowired
    TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    //update all the methods with code
    @RequestMapping("/")
    public List<Track> displayAll() {
        List<Track> list = trackService.getAllTracks();
        return list;
    }

    @RequestMapping("/saveTrack")
    public ResponseEntity<?> saveTrack(@RequestBody List<Track> tracks) {
        ResponseEntity responseEntity;
        trackService.saveTrack(tracks);
        responseEntity = new ResponseEntity("Successfully created", HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping("/updateTrack")
    public Track updateTrack(@RequestBody Track track) {
        trackService.updateTrack(track);
//        Track track1=new Track();
//        track1.setId(track.getId());
//        track1.setName(track.getName());
//        track1.setComment(track.getComment());
//        trackService.deleteTrack(track.getId());
//        trackService.saveTrack(Arrays.asList(track1));
       return track;
    }

    @PostMapping("/deleteTrack")
    public ResponseEntity<?> deleteTrack(@PathVariable int id)
    {
        trackService.deleteTrack(id);
        ResponseEntity responseEntity = new ResponseEntity("Successfully deleted", HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping("/getAllTracks")
    public List<Track> getAllTracks() {
        return (trackService.getAllTracks());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findTrackByName (@PathVariable String name ){
        return new ResponseEntity<>(trackService.findByName(name), HttpStatus.OK);
    }


    @GetMapping("/comment/{comment}")
    public ResponseEntity<?> findTrackByComment (@PathVariable String comment ){
        return new ResponseEntity<>(trackService.findByComment(comment), HttpStatus.OK);
    }
}


