package com.stackroute.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.muzix.Model.Track;
import com.stackroute.muzix.controller.TrackController;
import com.stackroute.muzix.services.TrackService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class TrackControllerTest {


    private MockMvc mockMvc;


    private TrackService trackService= Mockito.mock(TrackService.class);
    @InjectMocks
    private TrackController trackController;

    private List<Track> list =null;

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(trackController).build();
        Track track=new Track();
        track.setId(100);
        track.setName("Agha");
        track.setComment("Zafeer");

        list = new ArrayList();
        list.add(track);
    }

    @Test
    public void saveTrack() throws Exception {
        when(trackService.saveTrack(any())).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/saveTrack")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(list)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());


    }
      @Test
     public void saveTrackFailure() throws Exception {
        when(trackService.saveTrack(any())).thenReturn(false);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/saveTrack")
        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(list)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getAllTrack() throws Exception {
        when(trackService.getAllTracks()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/getAllTracks")
        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(list)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }


    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }










}
