package com.stackroute.service;

import com.stackroute.muzix.Model.Track;
import com.stackroute.muzix.repository.TrackRepository;
import com.stackroute.muzix.services.TrackServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class TrackServiceTest {

    Track track;

    //Create a mock for TrackRepository

    TrackRepository trackRepository= Mockito.mock(TrackRepository.class);

    //Inject the mocks as dependencies into TrackServiceImpl
    @InjectMocks
    TrackServiceImpl trackService;
    List<Track> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        Track track=new Track();
        MockitoAnnotations.initMocks(this);
        track.setId(100);
        track.setName("Agha");
        track.setComment("Zafeer");

        list = new ArrayList<>();
        list.add(track);


    }

    @Test
    public void saveTrackTestSuccess() {

        when(trackRepository.save(any())).thenReturn(track);
        Boolean savedTrack = trackService.saveTrack(list);
        Assert.assertEquals(true,savedTrack);

        //verify here verifies that TrackRepository save method is only called once
        verify(trackRepository,times(1)).save(list.get(0));
      
    }

    @Test
    public void saveTrackTestFailure() {
        when(trackRepository.save((Track)any())).thenReturn(track);
        Boolean savedTrack = trackService.saveTrack(list);
        System.out.println("savedTrack" + savedTrack);
        //Assert.assertEquals(Track,savedTrack);

       /*doThrow(new TrackAlreadyExistException()).when(TrackRepository).findById(eq(101));
       TrackService.saveTrack(Track);*/


    }

    @Test
    public void getAllTracks(){

        trackRepository.save(track);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> Tracklist = trackService.getAllTracks();
        Assert.assertEquals(list,Tracklist);
    }





}
