package com.ikub.motidatabase.controller;
import com.ikub.motidatabase.entity.Moti;
import com.ikub.motidatabase.service.MotiService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MotiControllerTest {

    @Mock
    private MotiService motiService;

    @InjectMocks
    private MotiController motiController;

    @Test
    public void testPostDetails() {

        Moti motiToPost = new Moti();
        Mockito.when(motiService.saveDetails(motiToPost)).thenReturn(motiToPost);
        Moti postedMoti = motiController.postDetails(motiToPost);
        assertEquals(motiToPost, postedMoti);
    }

    @Test
    public void testGetDetails() {
        List<Moti> expectedList = Arrays.asList(
                new Moti(1, "Tirane", "2024-04-24", 25, 67),
                new Moti(2, "Durres", "2024-04-25", 26, 68)
        );

        Mockito.when(motiService.getAllDetails()).thenReturn(expectedList);
        List<Moti> resultList = motiController.getDetails();
        assertEquals(expectedList, resultList);
    }

    @Test
    public void testUpdateMotiDetails() {
        Moti motiToUpdate = new Moti(1, "Tirane", "2024-04-24", 25, 67);
        Mockito.when(motiService.updateDetail(motiToUpdate)).thenReturn(motiToUpdate);
        Moti updatedMoti = motiController.updateMotiDetails(motiToUpdate);
        assertEquals(motiToUpdate, updatedMoti);
    }

    @Test
    public void testUpdateMotiDetails_NotFound() {
        Moti motiToUpdate = new Moti(1, "Tirane", "2024-04-24", 25, 67);
        Mockito.when(motiService.updateDetail(motiToUpdate)).thenReturn(null);
        Moti updatedMoti = motiController.updateMotiDetails(motiToUpdate);
        assertNull(updatedMoti);
    }
}
